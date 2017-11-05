# JavaBigData

##MaxList 模块

> MaxList模块主要是对Java集合中存储大数据的相关介绍。

最近在项目中遇到了List集合中的数据要去重，大概一个600万的List吧，需要跟一个5万的List去去重。

## 单例模式（饿汉模式）

```sh
public  class  Logger
{
    private  static  Logger  instance = new Logger();
    private  Logger() { }
    public  static  Logger  GetInstance()
    {
        return instance;
    }
}
```

通过以上的代码，我们就可以使用 GetInstance() 方法来获取被提前创建出来的 Logger类的实例，而且每次调用 GetInstance() 所获得到的对象都是同一个实例。这种方式就叫做单例模式。

单例模式在实现上分为两种，饿汉模式和懒汉模式，上边的实现就是饿汉模式，它在类初始化的过程中就已经把单例 instance对象创建好了，而另一种方式则是现用现加载（延迟加载）也就是懒汉模式，如下所示：

## 懒汉模式

```sh
public  class  Logger
{
    private  static  Logger  instance;
    private  Logger() { }
    public  static  Logger  GetInstance()
    {
        if (instance ==  null)
        {
            instance =  new  Logger();
        }
        return instance;
    }
}
```

但是这种实现存在线程安全问题的，例如现在有 A、 B两个线程，当 A线程调用了 GetInstance() 方法，并在黄色位置处进行了实例的空判别，并且进入了 if逻辑，而这是发生了线程切换（线程切换是不可预知的，随机发生的）， B线程也调用了 GetInstance() 方法，其在黄色位置处也进行了判空操作，而 A线程并没有完成 new操作，所以 B线程依然进入了 if体内，准备 new出实例。随后，假设线程切换回 A， A创建出实例并返回了实例 A，而后 B线程继续， B有 new除了一个实例而返回了另一个实例。那么，对于 A和 B线程，他们所得到的实例就是不同的实例了。为了避免这种情况的发生，我们需要为其添加一个锁，来实现线程安全。

```sh
public  static  Logger GetInstance()
{
    lock  (initLockHelper)
    {
        if (instance ==  null)
        {
            instance =  new  Logger();
        }
    }
    return  instance;
}
```

但是，这个锁的目的是为了防止首次创建对象时发生的线程问题而增加的，对于之后的更多时间里，我们是不需要再进行加锁操作的，这个操作的资源消耗还是比较大的，因此，我们需要在 lock之前先一次检查一下 instance是否为 null：

## 双检锁机制

```sh
public  static  Logger GetInstance()
{
    if  (instance == null)
    {
        lock (initLockHelper)
        {
            if (instance ==  null)
            {
                instance =  new  Logger();
            }
        }
    }
    return  instance;
}
```

这种锁机制我们称为双检锁机制，这样既保证了效率，又保证了线程安全。当我们的对象是一个轻量级类型时（类中没有太多的资源，比较简单）这是应该优先考虑使用饿汉模式，而对于类型复杂、资源占用较多的对象，可以考虑现用现加载，即懒汉模式。

## 多例模式
除了上述介绍的单例模式，其实还有多例模式，我们可以在 Logger类中维护一个 Dictionary对象，其中的成员就是具体的一个个实例，我们可以指定一个名字来获得对应的对象，比如名为 ModuleALogger、和ModuleBLogger 分别对应两个不同的实例，随后可以通过 Logger GetInstance(string instanceName) 来获得具体的实例。
