package com.krce.base;

import com.aventstack.extentreports.ExtentReports;
import com.krce.utilities.ExtentManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseReportSetup {

    public static ExtentReports extent;

    @BeforeSuite
    public void startReport() {
        extent = ExtentManager.getReportObject();
        System.out.println("Extent Report Started");
    }

    @AfterSuite
    public void endReport() {
        if (extent != null) {
            extent.flush();   // 🔥 generates index.html
            System.out.println("Extent Report Generated");
        }
    }
}