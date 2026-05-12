package com.krce.pages;

import com.krce.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormInteraction extends BasePage {

    public FormInteraction(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // ---------------- NAVIGATION ----------------
    private By pages = By.xpath("//a[span[text()='Pages']]");
    private By forms = By.xpath("//a[contains(text(),'Forms')]");
    private By htmlForm = By.xpath("//a[contains(text(),'HTML Form')]");

    public void navigateToHtmlForm() {

        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState=='complete'"));

        click(pages);

        click(forms);

        click(htmlForm);
    }

    // ---------------- LOCATORS ----------------
    private By username = By.name("username");
    private By password = By.name("password");
    private By comments = By.name("comments");
    private By dropdown = By.name("dropdown");
    private By file = By.xpath("//input[@type='file']");

    private By checkbox1 = By.cssSelector("input[value='cb1']");
    private By checkbox2 = By.cssSelector("input[value='cb2']");
    private By checkbox3 = By.cssSelector("input[value='cb3']");

    private By radio1 = By.cssSelector("input[value='rd1']");
    private By radio2 = By.cssSelector("input[value='rd2']");
    private By radio3 = By.cssSelector("input[value='rd3']");

    private By submit = By.cssSelector("input[type='submit']");

    // ---------------- RESULT ----------------
    private By resultUsername = By.id("_valueusername");
    private By resultPassword = By.id("_valuepassword");
    private By resultComments = By.id("_valuecomments");
    private By resultDropdown = By.id("_valuedropdown");
    private By resultRadio = By.id("_valueradioval");

    // ---------------- ACTIONS ----------------
    public void enterUsername(String value) { type(username, value); }

    public void enterPassword(String value) { type(password, value); }

    public void enterComments(String value) { type(comments, value); }

    public void selectDropdown(String value) { selectByVisibleText(dropdown, value); }

    public void uploadFile(String path) {
        driver.findElement(file).sendKeys(path);
    }

    public void selectCheckbox(int num) {
        if (num == 1) click(checkbox1);
        else if (num == 2) click(checkbox2);
        else click(checkbox3);
    }

    public void selectRadio(int num) {
        if (num == 1) click(radio1);
        else if (num == 2) click(radio2);
        else click(radio3);
    }

    public void submitForm() { click(submit); }
    public void scrollToElement(By locator) {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );

        new org.openqa.selenium.interactions.Actions(driver)
                .moveToElement(element)
                .perform();
    }
    // ---------------- RESULTS ----------------
    public String getUsernameResult() {
        return getText(resultUsername); }

    public String getPasswordResult() {
        return getText(resultPassword); }

    public String getCommentsResult() {
        return getText(resultComments); }

    public String getDropdownResult() {
        String raw = getText(resultDropdown);
        switch (raw) {
            case "dd1": return "Drop Down Item 1";
            case "dd2": return "Drop Down Item 2";
            case "dd3": return "Drop Down Item 3";
            case "dd4": return "Drop Down Item 4";
            default: return raw;
        }
    }
    public String getRadioResult() {
        return getText(resultRadio); }

    public String getUploadedFileName() {
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(file)
        );
        return element.getAttribute("value");  // IMPORTANT FIX
    }
}