package com.krce.pages;

import com.krce.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class TablePage extends BasePage {

    public TablePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // ---------------- LOCATORS ----------------
    private By headers = By.cssSelector("table th");
    private By rows = By.cssSelector("table tr");

    // ---------------- HEADERS ----------------
    public List<String> getHeaders() {

        List<WebElement> headerElements = driver.findElements(headers);
        List<String> headerText = new ArrayList<>();

        for (WebElement el : headerElements) {
            headerText.add(el.getText().trim());
        }

        return headerText;
    }

    // ---------------- TABLE DATA ----------------
    public List<List<String>> getTableData() {

        List<WebElement> allRows = driver.findElements(rows);
        List<List<String>> tableData = new ArrayList<>();

        for (int i = 1; i < allRows.size(); i++) { // skip header row

            List<WebElement> cols = allRows.get(i).findElements(By.tagName("td"));
            List<String> rowData = new ArrayList<>();

            for (WebElement col : cols) {
                rowData.add(col.getText().trim());
            }

            tableData.add(rowData);
        }

        return tableData;
    }

    // ---------------- SINGLE CELL ----------------
    public String getCell(int row, int col) {

        List<WebElement> allRows = driver.findElements(rows);

        // skip header row properly
        WebElement actualRow = allRows.get(row + 1);

        List<WebElement> cols = actualRow.findElements(By.tagName("td"));

        return cols.get(col).getText().trim();
    }
    public void openTablePage() {
        driver.get("https://testpages.eviltester.com/styled/tag/table.html");
    }
}