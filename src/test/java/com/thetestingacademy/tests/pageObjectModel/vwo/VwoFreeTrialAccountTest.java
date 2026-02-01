package com.thetestingacademy.tests.pageObjectModel.vwo;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.pageObjectModel.vwo.improvedPOM.DashboardPage;
import com.thetestingacademy.pages.pageObjectModel.vwo.improvedPOM.FreeTrialPage;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VwoFreeTrialAccountTest extends CommonToAllTest {

    private static final Logger logger = Logger.getLogger(VwoFreeTrialAccountTest.class.getName());
    @Owner("Aditya")
    @Epic("VWO Application")
    @Feature("Free Trial Account Creation")
    @Story("Free Trial Account Functionality")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verifying VWO Free Trial Account Creation Functionality")
    @Test(priority=1, groups = {"positive", "smoke"})
    public void vwoFreeTrialAccountCreationTest(){
        logger.info("Strating the VWO Free Trial Account Creation Test case");
        FreeTrialPage freeTrialPage = new FreeTrialPage(DriverManager.getDriver());
        freeTrialPage.clickOnStratFreeTrialLink();

        Assert.assertEquals(getDriver().getCurrentUrl(), PropertiesReader.readKey("free_trial_url"));
        logger.info("The current url after landing on Free Trial page is: " + getDriver().getCurrentUrl());
        logger.info("Landed on Free Trial page successfully");

        freeTrialPage.createFreeTrialAccount(PropertiesReader.readKey("temp_email"));
        logger.info("Created a new trial account with email: " + PropertiesReader.readKey("temp_email"));

        freeTrialPage.fillPersonalDetails(PropertiesReader.readKey("first_name"),PropertiesReader.readKey("last_name"),PropertiesReader.readKey("phone_number"));
        logger.info("Filled personal details with first name: " + PropertiesReader.readKey("first_name") + ", last name: " + PropertiesReader.readKey("last_name") + " and phone number: " + PropertiesReader.readKey("phone_number"));

        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        String loggedUserName=dashboardPage.loggedInUserName();
        logger.info("Logged in user name on dashboard is: {} " + loggedUserName);

        Assert.assertEquals(loggedUserName,PropertiesReader.readKey("expected_username"));
        assertThat(loggedUserName).isNotBlank().isEqualTo(PropertiesReader.readKey("expected_username"));

        logger.info("Completed the VWO Free Trial Account Creation Test case successfully");
    }
}
