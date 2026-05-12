package com.krce.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.krce.utilities.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.*;
import com.krce.utils.ExtentReportManager;

import java.time.Duration;

@Listeners(com.krce.listeners.TestListener.class)
public class BaseTest {

    public static WebDriver driver;

    public WebDriverWait wait;

    @BeforeMethod

    public void setup() {

        String browser =
                ConfigReader.getProperty("browser");

        if(browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();
        }

        else if(browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();

            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();

        driver.get(
                ConfigReader.getProperty("baseUrl"));

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(
                        Integer.parseInt(
                                ConfigReader.getProperty("timeout")
                        )
                )
        );
    }

    @AfterMethod

    public void tearDown() {

        if(driver != null) {

            driver.quit();
        }
    }


    @AfterSuite
    public void tearDownReport() {
        ExtentReportManager.flush();
    }




}