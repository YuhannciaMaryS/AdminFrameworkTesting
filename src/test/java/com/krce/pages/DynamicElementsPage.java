package com.krce.pages;

import com.krce.base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicElementsPage extends BasePage {

    public DynamicElementsPage(WebDriver driver,
                               WebDriverWait wait) {

        super(driver, wait);
    }

    // ---------------- LOCATORS ----------------

    // Dynamic Buttons Page
    private By startButton =
            By.id("button00");

    private By oneButton =
            By.id("button01");

    private By twoButton =
            By.id("button02");

    private By threeButton =
            By.id("button03");

    // Redirect Page
    private By redirectLink =
            By.id("redirect");

    // ---------------- ACTIONS ----------------

    // Open Dynamic Buttons Page
    public void openDynamicButtonsPage() {

        driver.get(
                "https://testpages.eviltester.com/styled/dynamic-buttons-disabled.html");
    }

    // Open Redirect Page
    public void openRedirectPage() {

        driver.get(
                "https://testpages.eviltester.com/styled/redirect");
    }

    // ---------------- DYNAMIC BUTTON ACTIONS ----------------

    public void clickStartButton() {

        click(startButton);
    }

    public boolean isButtonOneVisible() {

        return isDisplayed(oneButton);
    }

    public void clickButtonOne() {

        click(oneButton);
    }

    public boolean isButtonTwoVisible() {

        return isDisplayed(twoButton);
    }

    public void clickButtonTwo() {

        click(twoButton);
    }

    public boolean isButtonThreeVisible() {

        return isDisplayed(threeButton);
    }

    // ---------------- REDIRECT ----------------

    public void clickRedirectLink() {

        click(redirectLink);
    }
}