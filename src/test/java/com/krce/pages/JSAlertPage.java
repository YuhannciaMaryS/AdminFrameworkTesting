package com.krce.pages;

import com.krce.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSAlertPage extends BasePage {

    public JSAlertPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private By alertBtn = By.id("alertexamples");
    private By confirmBtn = By.id("confirmexample");
    private By promptBtn = By.id("promptexample");

    private By alertResult = By.id("alertexplanation");
    private By confirmResult = By.id("confirmexplanation");
    private By promptResult = By.id("promptexplanation");

    public void clickAlert() { click(alertBtn); }
    public void clickConfirm() { click(confirmBtn); }
    public void clickPrompt() { click(promptBtn); }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void enterPrompt(String text) {
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
    }

    public String getAlertResult() {
        return getText(alertResult);
    }

    public String getConfirmResult() {
        return getText(confirmResult);
    }

    public String getPromptResult() {
        return getText(promptResult);
    }
}