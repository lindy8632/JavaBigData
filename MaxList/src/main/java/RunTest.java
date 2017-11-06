import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by tommyyang on 2017/11/3.
 */
public class RunTest {

    private final static Logger logger = LoggerFactory.getLogger(RunTest.class);

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

        List<String> maxArrayList = ListUtils.maxArrayList();
        List<String> maxLinkedList = new LinkedList<String>();
//        Set<String> maxSet = new HashSet<String>(maxArrayList);
//        maxSet.addAll(maxArrayList);

        maxLinkedList.addAll(maxArrayList);

        List<String> testList = ListUtils.testList();


        logger.info("start test ArrayList, start time: " + sdf.format(new Date()));

        ListUtils.deWeightList(testList, maxArrayList);

        logger.info("end test ArrayList, end time: " + sdf.format(new Date()));

        logger.info("start test LinkedList, start time: " + sdf.format(new Date()));

        ListUtils.deWeightList(testList, maxLinkedList);

        logger.info("end test LinkedList, end time: " + sdf.format(new Date()));
//
//        logger.info("start test Set, start time: " + sdf.format(new Date()));
//
//        ListUtils.deWeightSet(testList, maxSet);
//
//        logger.info("end test Set, end time: " + sdf.format(new Date()));


    }

}
