package com.krce.tests;

import com.krce.base.BaseTest;
import com.krce.pages.JSAlertPage;
import com.krce.pages.JSAlertPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSAlertTest extends BaseTest {

    private final String URL =
            "https://testpages.eviltester.com/pages/basics/alerts-javascript/";

    @Test
    public void testConfirmAlertAccept() {

        driver.get(URL);

        JSAlertPage alert = new JSAlertPage(driver, wait);

        alert.clickConfirm();
        alert.acceptAlert();

        Assert.assertTrue(alert.getConfirmResult().contains("OK"));
    }

    @Test
    public void testConfirmAlertDismiss() {

        driver.get(URL);

        JSAlertPage alert = new JSAlertPage(driver, wait);

        alert.clickConfirm();
        alert.dismissAlert();

        Assert.assertTrue(alert.getConfirmResult().contains("Cancel"));
    }

    @Test
    public void testSimpleAlertAccept() {

        driver.get(URL);

        JSAlertPage alert = new JSAlertPage(driver, wait);

        alert.clickAlert();
        alert.acceptAlert();

        // Simple alert result says this, NOT "OK"
        Assert.assertTrue(alert.getAlertResult().contains("You triggered and dismissed the alert"));
    }

    @Test
    public void testPromptAlert() {

        driver.get(URL);

        JSAlertPage alert = new JSAlertPage(driver, wait);

        String input = "Yuhan";

        alert.clickPrompt();
        alert.enterPrompt(input);

        Assert.assertTrue(alert.getPromptResult().contains(input));
    }
}