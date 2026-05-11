package com.krce.tests;

import com.krce.base.BaseTest;
import com.krce.pages.FormInteraction;
import com.krce.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FormInteractionTest extends BaseTest {

    @DataProvider(name = "formData")
    public Object[][] formData() {
        return new Object[][]{
                {"Yuhan","123456789","Hello world","Drop Down Item 2"},
                {"Leno","pass123","Hi everyone","Drop Down Item 4"},
                {"Sindu","0987654321","Eating","Drop Down Item 1"},
        };
    }

    @Test(dataProvider = "formData")
    public void testValidFormSubmission(String username, String password,
                                        String comments, String dropdown) {

        HomePage home = new HomePage(driver, wait);
        FormInteraction form = new FormInteraction(driver, wait);

        home.navigateToHomePage();

        form.navigateToHtmlForm();

        form.enterUsername(username);
        form.enterPassword(password);
        form.enterComments(comments);
        form.selectDropdown(dropdown);
        form.submitForm();

        Assert.assertEquals(form.getUsernameResult(), username);
        Assert.assertEquals(form.getPasswordResult(), password);
        Assert.assertEquals(form.getCommentsResult(), comments);
        Assert.assertEquals(form.getDropdownResult(), dropdown);
    }

    @Test
    public void testDropdownSelection() {

        HomePage home = new HomePage(driver, wait);
        FormInteraction form = new FormInteraction(driver, wait);

        home.navigateToHomePage();
        form.navigateToHtmlForm();

        form.selectDropdown("Drop Down Item 1");
        form.submitForm();

        String actual = form.getDropdownResult();

        Assert.assertEquals(actual, "dd1");
    }

    @Test
    public void testFileUpload() {

        HomePage home = new HomePage(driver, wait);
        FormInteraction form = new FormInteraction(driver, wait);

        home.navigateToHomePage();
        form.navigateToHtmlForm();

        form.uploadFile("C:\\Users\\yuhan\\Desktop\\test.txt");
        form.submitForm();

        Assert.assertTrue(driver.getPageSource().contains("test.txt"));
    }

    @Test
    public void testRadioButtonSelection() {

        HomePage home = new HomePage(driver, wait);
        FormInteraction form = new FormInteraction(driver, wait);

        home.navigateToHomePage();
        form.navigateToHtmlForm();

        form.selectRadio(2);
        form.submitForm();

        Assert.assertEquals(form.getRadioResult(), "rd2");
    }

    @Test
    public void testCheckboxSelection() {

        HomePage home = new HomePage(driver, wait);
        FormInteraction form = new FormInteraction(driver, wait);

        home.navigateToHomePage();
        form.navigateToHtmlForm();

        form.selectCheckbox(1);
        form.selectCheckbox(3);
        form.submitForm();

        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("cb1"));
        Assert.assertTrue(pageSource.contains("cb3"));
    }

    @Test
    public void testEmptyFormSubmission() {

        HomePage home = new HomePage(driver, wait);
        FormInteraction form = new FormInteraction(driver, wait);

        home.navigateToHomePage();
        form.navigateToHtmlForm();

        form.submitForm();

        Assert.assertTrue(form.getUsernameResult().isEmpty());
    }
}