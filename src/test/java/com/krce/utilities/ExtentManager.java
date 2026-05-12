package com.krce.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getReportObject() {

        if (extent == null) {

            String path = System.getProperty("user.dir") + "/reports/index.html";

            File folder = new File(System.getProperty("user.dir") + "/reports");
            if (!folder.exists()) {
                folder.mkdirs();
            }

            ExtentSparkReporter reporter = new ExtentSparkReporter(path);

            reporter.config().setReportName("KRCE Automation Report");
            reporter.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            extent.setSystemInfo("Tester", "Yuhan");
            extent.setSystemInfo("Framework", "Selenium");
        }

        return extent;
    }
}