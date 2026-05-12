package com.krce.base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // ---------------- CLICK ----------------
    public void click(By locator) {

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        new Actions(driver)
                .moveToElement(element)
                .pause(java.time.Duration.ofMillis(200))
                .perform();

        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void safeClick(By locator) {
        try {
            click(locator);
        } catch (Exception e) {
            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void scrollToElement(By locator) {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    // ---------------- TYPE ----------------
    public void type(By locator, String value) {
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(value);
    }

    // ---------------- GET TEXT ----------------
    public String getText(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).getText();
    }

    // ---------------- GET VALUE (INPUT FIELDS) ----------------
    public String getValue(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).getAttribute("value");
    }

    // ---------------- ALERT HANDLING ----------------
    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
    }

    public void sendTextToAlert(String text) {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
    }

    // ---------------- DROPDOWN ----------------
    public void selectByVisibleText(By locator, String text) {
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    // ---------------- FRAME HANDLING ----------------
    public void switchToFrame(By locator) {
        WebElement frame =
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.switchTo().frame(frame);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    // ---------------- BASIC VALIDATION ----------------
    public boolean isDisplayed(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).isDisplayed();
    }
}