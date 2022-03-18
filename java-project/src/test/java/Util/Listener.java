package Util;

import com.codeborne.selenide.WebDriverRunner;
import com.google.common.io.BaseEncoding;
import com.google.common.io.Resources;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

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
            logger.info("The name of the test passed is :" + Result.getName());
            saveScreenshot();
            String screenshot = "screenshot.png";
            try {
                logger.info(
                        "RP_MESSAGE#BASE64#{}#{}",
                        BaseEncoding.base64().encode(Resources.asByteSource(Resources.getResource(screenshot)).read()),
                        "on test success screenshot"
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private void saveScreenshot(){
        File screenCapture = ((TakesScreenshot) WebDriverRunner
                .getWebDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    "src/main/resources/"
                            +
                            "screenshot.png"));
        } catch (IOException e) {
            logger.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

}

