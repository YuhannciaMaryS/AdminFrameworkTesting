package com.krce.listeners;

import com.krce.base.BaseTest;
import com.krce.utils.ExtentReportManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.krce.utils.ScreenshotUtil;

public class TestListener extends BaseTest implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ExtentReportManager.getInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportManager.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.getTest().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentReportManager.getTest()
                .fail("Test Failed: " + result.getThrowable());

        String screenshotPath =
                ScreenshotUtil.captureScreenshot(
                        BaseTest.driver,
                        result.getMethod().getMethodName()
                );

        ExtentReportManager.getTest()
                .addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.getTest().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.flush();
    }
}