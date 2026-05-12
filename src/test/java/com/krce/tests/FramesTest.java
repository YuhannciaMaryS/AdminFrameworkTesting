package com.krce.tests;

import com.krce.base.BaseTest;
import com.krce.pages.FramesPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {

    // ---------------- 1. IFRAME INTERACTION ----------------

    @Test
    public void verifyLeftFrameContent() {

        FramesPage page =
                new FramesPage(driver, wait);

        page.openFramesPage();

        page.switchToLeftFrame();

        String text =
                page.getLeftFrameText();

        Assert.assertTrue(
                text.contains("Left"),
                "Left frame text mismatch"
        );
    }

    // ---------------- 2. NESTED FRAME CONTENT ----------------

    @Test
    public void verifyMiddleFrameContent() {

        FramesPage page =
                new FramesPage(driver, wait);

        page.openFramesPage();

        page.switchToMiddleFrame();

        String text =
                page.getMiddleFrameText();

        Assert.assertTrue(
                text.contains("Middle"),
                "Middle frame text mismatch"
        );
    }

    // ---------------- 3. SWITCH BACK ----------------

    @Test
    public void verifySwitchBackToDefaultContent() {

        FramesPage page =
                new FramesPage(driver, wait);

        page.openFramesPage();

        page.switchToLeftFrame();

        page.switchBackToMainPage();

        String mainText =
                page.getMainPageText();

        Assert.assertTrue(
                mainText.contains("Frames"),
                "Main page not accessible"
        );
    }
}