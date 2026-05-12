package com.krce.pages;

import com.krce.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicElementsPage extends BasePage {

    public static final String URL =
            "https://testpages.eviltester.com/pages/input-elements/form-controls/";

    public DynamicElementsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // ---------------- LOCATORS ----------------
    private By showHiddenBtn = By.id("showHiddenButton");
    private By hiddenElement = By.id("hiddenElement");

    private By triggerBtn = By.id("revealButton");
    private By resultText = By.id("revealText");

    private By redirectBtn = By.id("redirectButton");

    // ---------------- ACTIONS ----------------
    public void openPage() {
        driver.get(URL);
    }

    // Hidden element
    public void clickShowHidden() {
        click(showHiddenBtn);
    }

    public boolean isHiddenElementVisible() {
        return isDisplayed(hiddenElement);
    }

    // Dynamic text
    public void clickTrigger() {
        click(triggerBtn);
    }

    public String getDynamicResult() {
        return getText(resultText);
    }

    // Redirect
    public void clickRedirect() {
        click(redirectBtn);
    }
}