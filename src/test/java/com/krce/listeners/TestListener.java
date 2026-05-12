package com.krce.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.krce.utilities.ExtentManager;
import org.testng.*;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getReportObject();
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest =
                extent.createTest(result.getMethod().getMethodName());

        test.set(extentTest);
        test.get().info("🚀 Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("✔ Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail("❌ Test Failed");
        test.get().fail(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        System.out.println("📊 Report Generated");
        System.out.println(System.getProperty("user.dir"));
    }
}