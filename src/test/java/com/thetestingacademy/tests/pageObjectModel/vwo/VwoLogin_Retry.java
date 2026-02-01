package com.thetestingacademy.tests.pageObjectModel.vwo;

import com.thetestingacademy.listeners.RetryAnalyzer;
import com.thetestingacademy.listeners.ScreenshotListener;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.thetestingacademy.driver.DriverManager.getDriver;

@Listeners(ScreenshotListener.class)
@Test(retryAnalyzer=RetryAnalyzer.class)
public class VwoLogin_Retry {

    private static final Logger logger = LogManager.getLogger(VwoLogin_Retry.class.getName());

    @Owner("Aditya")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testFail(){
        logger.info("Starting the test case for veriying fail scenario");
        getDriver().get("https://app.vwo.com");
        Allure.addAttachment("Log output", "text/plain", "This is some log text");
        Assert.assertTrue(false);
    }

    @Owner("Aditya")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testPass() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
        Assert.assertTrue(true);
    }

}
