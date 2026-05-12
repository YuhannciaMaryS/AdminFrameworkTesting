package com.krce.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    // INIT REPORT
    public static ExtentReports getInstance() {
        if (extent == null) {

            ExtentSparkReporter spark = new ExtentSparkReporter(
                    "reports/KRCE_Report.html"
            );

            spark.config().setDocumentTitle("KRCE Automation Report");
            spark.config().setReportName("Test Execution Report");
            spark.config().setTheme(Theme.DARK);

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Project", "KRCE Framework");
            extent.setSystemInfo("Tester", "Yuhan");
            extent.setSystemInfo("Type", "Selenium + TestNG");
        }
        return extent;
    }

    // CREATE TEST (ONLY THIS WAY)
    public static void createTest(String testName) {
        ExtentTest extentTest = getInstance().createTest(testName);
        test.set(extentTest);
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}