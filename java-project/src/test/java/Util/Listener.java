package Util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    private final Logger logger = LogManager.getRootLogger();
    @Override
    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailure(ITestResult Result) {
        System.out.println();
        System.out.println("The name of the test failed is :" + Result.getName());
        logger.info("The name of the test failed is :" + Result.getName());
        System.out.println();
    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestStart(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestSuccess(ITestResult Result) {
        // TODO Auto-generated method stub
        System.out.println();
        System.out.println("The name of the test passed is :" + Result.getName());
        logger.info("The name of the test passed is :" + Result.getName());
        System.out.println();
    }

}

