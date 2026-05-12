package com.krce.tests;

import com.krce.base.BaseTest;
import com.krce.pages.DynamicElementsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicElementsTest extends BaseTest {

    // ---------------- 1. HIDDEN → VISIBLE ----------------
    @Test
    public void verifyHiddenElementBecomesVisible() {

        DynamicElementsPage page = new DynamicElementsPage(driver, wait);

        page.openPage();
        page.clickShowHidden();

        Assert.assertTrue(
                page.isHiddenElementVisible(),
                "Hidden element did not become visible"
        );
    }

    // ---------------- 2. DYNAMIC TEXT ----------------
    @Test
    public void verifyDynamicResultChange() {

        DynamicElementsPage page = new DynamicElementsPage(driver, wait);

        page.openPage();
        page.clickTrigger();

        String result = page.getDynamicResult();

        Assert.assertNotNull(result, "Result is null");
        Assert.assertFalse(result.isEmpty(), "Dynamic result not updated");
    }

    // ---------------- 3. REDIRECT CHECK ----------------
    @Test
    public void verifyRedirectPage() {

        DynamicElementsPage page = new DynamicElementsPage(driver, wait);

        page.openPage();
        page.clickRedirect();

        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://testpages.eviltester.com/pages/input-elements/form-controls/",
                "Redirect failed or wrong page loaded"
        );
    }
}