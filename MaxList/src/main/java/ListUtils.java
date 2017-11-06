import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by tommyyang on 2017/11/3.
 */
public class ListUtils {

    private final static Logger logger = LoggerFactory.getLogger(ListUtils.class);


    public static List maxArrayList(){
        List<String> strArrayList = new ArrayList<String>(2500000);
        for(int i = 0; i < 2500000; i ++){
            strArrayList.add( i + "test");
        }
        return strArrayList;
    }

    public static List maxLinkedList(){
        List<String> strList = new LinkedList<String>();
        for(int i = 0; i < 1000000; i ++){
            strList.add( i + "test");
        }
        return strList;
    }

    public static Set maxSet(){
        Set<String> set = new HashSet<String>(1000000);
        for(int i = 0; i < 1000000; i ++){
            set.add( i + "test");
        }
        return set;
    }

    public static List testList(){
        List<String> testList = new ArrayList<String>();
        for(int i = 0; i < 50000; i++){
            testList.add(i + "test");
        }
        return testList;
    }

    public static void deWeightList(String des, List<String> sourse){
        if(sourse == null || sourse.size() <= 0){
            return;
        }
        Iterator<String> listStr = sourse.iterator();
        while (listStr.hasNext()){
            String item = listStr.next();
            if(item.equals(des)){
                listStr.remove();
            }
        }
        //logger.info("after deWight list size: " + sourse.size());
    }

    public static void deWeightList(List<String> des, List<String> sourse){
        if(sourse == null || sourse.size() <= 0){
            return;
        }
        Iterator<String> listStr = sourse.iterator();
        while (listStr.hasNext()){
            String item = listStr.next();
            for (String ditem: des) {
                if(item.equals(ditem)){
                    listStr.remove();
                    break;
                }
            }

        }
        logger.info("after deWight list size: " + sourse.size());
    }

    public static void deWeightSet(List<String> des, Set<String> sourse){
        if(sourse == null || sourse.size() <= 0){
            return;
        }
        Iterator<String> setStr = sourse.iterator();
        while (setStr.hasNext()){
            String item = setStr.next();
            for (String ditem:des) {
                if(item.equals(ditem)){
                    setStr.remove();
                    break;
                }
            }
        }
        logger.info("after deWight set size: " + sourse.size());
    }

}
