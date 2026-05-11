package com.krce.tests;

import com.krce.base.BaseTest;
import com.krce.pages.TablePage;
import com.krce.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TableTest extends BaseTest {

    @Test
    public void verifyTableHeadersArePresent() {

        HomePage home = new HomePage(driver, wait);
        TablePage table = new TablePage(driver, wait);

        home.navigateToHomePage();

        // navigate manually to table page (update if you have method in HomePage)
        driver.get("https://testpages.eviltester.com/styled/tag/table.html");

        List<String> headers = table.getHeaders();

        Assert.assertTrue(headers.contains("Name"), "Name header missing");
        Assert.assertTrue(headers.contains("Amount"), "Amount header missing");
    }

    @Test
    public void verifyTableDataIsDisplayed() {

        HomePage home = new HomePage(driver, wait);
        TablePage table = new TablePage(driver, wait);

        home.navigateToHomePage();

        driver.get("https://testpages.eviltester.com/styled/tag/table.html");

        List<List<String>> data = table.getTableData();

        Assert.assertFalse(data.isEmpty(), "Table data is empty");

        // optional check for first row
        Assert.assertEquals(data.get(0).get(0), "Alan");
        Assert.assertEquals(data.get(0).get(1), "12");
    }

    @Test
    public void verifySingleCellValue() {

        HomePage home = new HomePage(driver, wait);
        TablePage table = new TablePage(driver, wait);

        home.navigateToHomePage();
        table.openTablePage();

        String value = table.getCell(1, 0); // Bob row

        Assert.assertEquals(value, "Bob");
    }
}