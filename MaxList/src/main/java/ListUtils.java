
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by tommyyang on 2017/11/3.
 */
public class ListUtils {

    private final static Logger logger = LoggerFactory.getLogger(ListUtils.class);

    public static List maxArrayList(int size) {
        List<String> strList = new ArrayList<String>(size);
        for (int i = 0; i < size; i++) {
            strList.add(i + "test");
        }
        return strList;
    }

    public static List maxList(int size) {
        List<String> strList = new LinkedList<String>();
        for (int i = 0; i < size; i++) {
            strList.add(i + "test");
        }
        return strList;
    }

    public static List testList(int size) {
        List<String> testList = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            testList.add(i + "test");
        }
        return testList;
    }

    public static Set testSet(int size) {
        Set<String> testSet = new HashSet<String>();
        for (int i = 0; i < size; i++) {
            testSet.add(i + "test");
        }
        return testSet;
    }

    public static void deWeightList(List<String> des, List<String> sourse) {
        if (sourse == null || sourse.size() <= 0) {
            return;
        }
        Iterator<String> listStr = sourse.iterator();
        while (listStr.hasNext()) {
            String item = listStr.next();
            if (des.contains(item)) {
                listStr.remove();
            }
        }
        logger.info("after deWight list size: " + sourse.size());
    }

    public static void deWeightList(Set<String> des, List<String> sourse) {
        if (sourse == null || sourse.size() <= 0) {
            return;
        }
        Iterator<String> listStr = sourse.iterator();
        while (listStr.hasNext()) {
            String item = listStr.next();
            if (des.contains(item)) {
                listStr.remove();
            }
        }
        logger.info("after deWight list size: " + sourse.size());
    }

    public static void deWeightListOther(List<String> des, List<String> sourse) {
        if (sourse == null || sourse.size() <= 0) {
            return;
        }
        for (int i = sourse.size() - 1; i >= 0; i--) {
            String str = sourse.get(i);
            for (String item : des) {
                if (str.equals(item)) {
                    sourse.remove(i);
                    break;
                }
            }
        }
        logger.info("after other deWight list size: " + sourse.size());
    }

}
