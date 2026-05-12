package com.krce.tests;

import com.krce.base.BaseTest;
import com.krce.pages.DynamicElementsPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicElementsTest extends BaseTest {

    @Test
    public void verifyDynamicButtons() {

        DynamicElementsPage page =
                new DynamicElementsPage(driver, wait);

        page.openDynamicButtonsPage();

        page.clickStartButton();

        Assert.assertTrue(
                page.isButtonOneVisible(),
                "Button 1 not visible"
        );

        page.clickButtonOne();

        Assert.assertTrue(
                page.isButtonTwoVisible(),
                "Button 2 not visible"
        );

        page.clickButtonTwo();

        Assert.assertTrue(
                page.isButtonThreeVisible(),
                "Button 3 not visible"
        );
    }

    @Test
    public void verifyRedirectPage() {

        DynamicElementsPage page =
                new DynamicElementsPage(driver, wait);

        page.openRedirectPage();

        page.clickRedirectLink();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("redirected"),
                "Redirect failed"
        );
    }
}