package com.krce.pages;

import com.krce.base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FramesPage extends BasePage {

    public FramesPage(WebDriver driver,
                      WebDriverWait wait) {

        super(driver, wait);
    }

    // ---------------- LOCATORS ----------------

    // Left frame
    private By leftFrame =
            By.name("left");

    private By leftFrameHeader =
            By.tagName("h1");

    // Middle frame
    private By middleFrame =
            By.name("middle");

    private By middleFrameHeader =
            By.tagName("h1");

    // Main page content
    private By mainHeader =
            By.tagName("h1");

    // ---------------- ACTIONS ----------------

    public void openFramesPage() {

        driver.get(
                "https://testpages.eviltester.com/styled/frames/frames-test.html");
    }

    // ---------------- LEFT FRAME ----------------

    public void switchToLeftFrame() {

        switchToFrame(leftFrame);
    }

    public String getLeftFrameText() {

        return getText(leftFrameHeader);
    }

    // ---------------- MIDDLE FRAME ----------------

    public void switchToMiddleFrame() {

        switchToFrame(middleFrame);
    }

    public String getMiddleFrameText() {

        return getText(middleFrameHeader);
    }

    // ---------------- DEFAULT CONTENT ----------------

    public void switchBackToMainPage() {

        switchToDefaultContent();
    }

    public String getMainPageText() {

        return getText(mainHeader);
    }
}