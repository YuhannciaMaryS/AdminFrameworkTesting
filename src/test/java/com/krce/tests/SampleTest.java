package com.krce.tests;

import com.krce.utils.ScreenshotUtil;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.krce.base.BaseTest;

public class SampleTest extends BaseTest {
    @Test
    public void sampleTest() {

        driver.get("https://example.com");

        // valid element on page
        driver.findElement(By.tagName("h1")).click();

        // screenshot
        ScreenshotUtil.takeScreenshot(driver, "sampleTest");
    }
}