import com.sun.xml.internal.bind.v2.TODO;
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

        List<String> maxArrayList = ListUtils.maxArrayList(25000000);
//        Set<String> maxSet = new HashSet<String>(maxArrayList);
//        maxSet.addAll(maxArrayList);

        List<String> testList = ListUtils.testList(20000);
        Set<String> testSet = ListUtils.testSet(20000);


        //遍历过程中去重
        logger.info("start test foreach list directly, start time: " + sdf.format(new Date()));

        for (String item: maxArrayList) {
            if(testSet.contains(item)){
                //TODO
            }
        }

        logger.info("end test foreach list directly, end time: " + sdf.format(new Date()) + "\n");


        //List结合List去重
        logger.info("start test list, start time: " + sdf.format(new Date()));

        ListUtils.deWeightList(testList, maxArrayList);

        logger.info("end test list, end time: " + sdf.format(new Date()) + "\n");

        maxArrayList.clear();
        maxArrayList = ListUtils.maxArrayList(25000000);

        //List结合Set去重
        logger.info("start test set, start time: " + sdf.format(new Date()));

        ListUtils.deWeightList(testSet, maxArrayList);

        logger.info("end test set, end time: " + sdf.format(new Date()));


    }

}
