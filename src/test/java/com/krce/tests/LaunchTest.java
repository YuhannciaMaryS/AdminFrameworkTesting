package com.krce.tests;

import com.krce.base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LaunchTest extends BaseTest {

    @Test

    public void verifyWebsiteLaunch() {

        String title = driver.getTitle();

        System.out.println(title);

        Assert.assertTrue(
                title.contains("Software Testing Practice Pages"));
    }
}