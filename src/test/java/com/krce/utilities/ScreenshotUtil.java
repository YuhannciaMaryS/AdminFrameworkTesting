package com.krce.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String testName) {

        // STEP 1: Convert driver to screenshot type
        TakesScreenshot ts = (TakesScreenshot) driver;

        // STEP 2: Capture screenshot as file
        File src = ts.getScreenshotAs(OutputType.FILE);

        // STEP 3: Define where to store it
        String path = System.getProperty("user.dir")
                + "/screenshots/" + testName + ".png";

        File dest = new File(path);

        // STEP 4: Copy file to folder
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // STEP 5: Return path (optional use later)
        return path;
    }
}