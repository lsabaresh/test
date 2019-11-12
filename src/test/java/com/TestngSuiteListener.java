package com;

import org.apache.commons.lang3.time.DurationFormatUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITestContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestngSuiteListener implements ISuiteListener {
//    private static final Logger LOGGER = LoggerFactory.getLogger(TestngSuiteListener.class);
    public static final String PATTERN = "dd/MM/yyyy HH:mm:ss SS";
    public static final SimpleDateFormat FORMAT = new SimpleDateFormat(PATTERN);
    public static final String DURATION_FORMAT = "HH:mm:ss,SSS";

    @Override
    public void onStart(ISuite suite) {
        System.out.println("Suite "+suite.getName()+ " started at " + FORMAT.format(System.currentTimeMillis()));
    }

    @Override
    public void onFinish(ISuite suite) {
        long totalTime = 0;

        System.out.println("Suite "+suite.getName()+" Results : ");



        for (ISuiteResult eachResult : suite.getResults().values()) {
            ITestContext ctx = eachResult.getTestContext();

//            ctx.getSuite()

//            ctx.getAttribute()
            Date start = ctx.getStartDate();
            Date end = ctx.getEndDate();
            long ms = end.getTime() - start.getTime();
            totalTime += ms;
            System.out.println("Test Group "+ctx.getName() + " started at [" + FORMAT.format(start) + "] and "
                    + "ended at [" + FORMAT.format(end) + "] and took [" + ms + "] ms to run. "+ctx.getAllTestMethods().length);
        }

        System.out.println("Total time taken: " + DurationFormatUtils.formatDuration(totalTime, DURATION_FORMAT)+ " ("+ DURATION_FORMAT +")");
    }
}
