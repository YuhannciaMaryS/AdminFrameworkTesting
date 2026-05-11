package com.krce.tests;

import com.krce.base.BaseTest;
import com.krce.utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuthTest extends BaseTest {

    @Test
    public void verifyBasicAuthSuccess() {

        String url =
                "https://" +
                        ConfigReader.getProperty("authUser") + ":" +
                        ConfigReader.getProperty("authPass") +
                        "@testpages.eviltester.com/pages/auth/basic-auth/basic-auth-results.html";

        driver.get(url);

        String pageSource = driver.getPageSource();

        Assert.assertFalse(
                pageSource.contains("You were Not Authenticated"),
                "Authentication failed"
        );
    }
}