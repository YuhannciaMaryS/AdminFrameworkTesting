package com.krce.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());

        String screenshotPath =
                "screenshots/" + testName + "_" + timeStamp + ".png";

        File srcFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        File destFile = new File(screenshotPath);

        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }
}