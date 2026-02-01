package com.thetestingacademy.tests.pageObjectModel.vwo;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.pageObjectModel.vwo.improvedPOM.DashboardPage;
import com.thetestingacademy.pages.pageObjectModel.vwo.improvedPOM.LoginPage;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VWOLogin_ImprovedPOM_Test extends CommonToAllTest {

    private static final Logger logger = Logger.getLogger(VWOLogin_ImprovedPOM_Test.class.getName());

    @Owner("Aditya")
    @Epic("VWO Application")
    @Feature("Authentication")
    @Story("Login Functionality")
    @Description("Verifying vwo login by using invalid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2, groups = {"negative", "smoke"})
    public void invalidVWOLoginTest(){
        String err_msg=null;
        try {
            logger.info("Starting the invalid VWO login test case using improved POM");
            LoginPage loginPage = new LoginPage(DriverManager.getDriver());
            err_msg = loginPage.loginToInvalidVWOCredentials(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));
            logger.info("Error message received after invalid login attempt: {} " + err_msg);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        assertThat(err_msg).isNotBlank().isEqualTo(PropertiesReader.readKey("error_message"));
        Assert.assertEquals(err_msg,PropertiesReader.readKey("error_message"));
        logger.info("Completed the invalid VWO login test case using improved POM");
    }

    @Owner("Aditya")
    @Epic("VWO Application")
    @Feature("Authentication")
    @Story("Login Functionality")
    @Description("Verifying vwo login by using valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority=1, groups = {"positive", "smoke"})
    public void validVWOLoginTest(){
        String user_name=PropertiesReader.readKey("username");
        String password=PropertiesReader.readKey("password");
        String expected_logged_in_username=PropertiesReader.readKey("expected_username");
        String actual_logged_in_username=null;

        try {
            logger.info("Starting the valid VWO login test case using improved POM");
            LoginPage loginPage = new LoginPage(DriverManager.getDriver());
            loginPage.loginToValidVWOCredentials(user_name,password);
            logger.info("Successfully logged in to VWO application with valid credentials");

            logger.info("Now moving to the Dashboard page");
            DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
            actual_logged_in_username=dashboardPage.loggedInUserName();
            logger.info("Logged user name on dashboard pase is:: {} " + actual_logged_in_username);

            assertThat(actual_logged_in_username).isNotEmpty().isEqualTo(expected_logged_in_username);
            Assert.assertEquals(actual_logged_in_username,expected_logged_in_username);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
    @Owner("Aditya")
    @Epic("VWO Application")
    @Feature("Authentication")
    @Story("Login Functionality")
    @Description("Verfiying VWO login functionality by providing deleted account credentials")
    @Test(priority = 3,groups = {"negative", "smoke"})
    public void deletedVWOAccountTest(){
        String deleted_account_error_msg=null;

        logger.info("Starting the deleted account VWO Login test case using improved POM");
        try {
            LoginPage loginPage = new LoginPage(DriverManager.getDriver());
            deleted_account_error_msg=loginPage.loginToDeletedVWOCredentials(PropertiesReader.readKey("username"), PropertiesReader.readKey("password"));
            logger.info("Error message received after trying login with deleted account credentials: {} " + deleted_account_error_msg);

            assertThat(deleted_account_error_msg).isNotBlank().isEqualTo(PropertiesReader.readKey("deleted_account_error_message"));
            Assert.assertEquals(deleted_account_error_msg, PropertiesReader.readKey("deleted_account_error_message"));
            logger.info("Completed the deleted account VWO Login test case using improved POM");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}




