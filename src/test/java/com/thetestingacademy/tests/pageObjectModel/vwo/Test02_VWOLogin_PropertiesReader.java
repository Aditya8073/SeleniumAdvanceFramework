package com.thetestingacademy.tests.pageObjectModel.vwo;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.pageObjectModel.vwo.improvedPOM.DashboardPage;
import com.thetestingacademy.pages.pageObjectModel.vwo.normalPOM.LoginPage;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Test02_VWOLogin_PropertiesReader extends CommonToAllTest {

    //private static final Logger logger = LogManager.getLogger(Test02_InvalidVWOLogin_PropertiesReader.class);
    private static final Logger logger=Logger.getLogger(Test02_VWOLogin_PropertiesReader.class.getName());


    @Owner("Aditya")
    @Description("Verifying invalid vwo login by using credentials from Properties Reader")
    @Test(priority=1)
    public void test_invalid_vwo_login_properties_reader(){

        logger.info("Starting the test case with page object model");
        // Page Object Model Code - POM Code - 2
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        String err_msg=loginPage.loginToInvalidVwoCredentials(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        logger.info("Error message received after invalid login attempt: "+err_msg);
        assertThat(err_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(err_msg,PropertiesReader.readKey("error_message"));
        logger.info("Completed the test case with page object model");
    }

    public void test_valid_vwo_login_properties_reader(){
        logger.info("Starting the test case with page object model for valid login");
        // Page Object Model Code - POM Code - 2
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.loginValidVwoCredentials(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));
        logger.info("Completed the test case with valid login using page object model");
        logger.info("Now moving to Dashboard page");

        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        String userName=dashboardPage.loggedInUserName();
        logger.info("Logged in user name on dashboard is: " + userName);

        assertThat(userName).isNotEmpty().isNotBlank().isNotNull().isEqualTo(PropertiesReader.readKey("expected_username"));
        Assert.assertEquals(userName,PropertiesReader.readKey("expected_username"));

        logger.info("Completed the test case for dashboard page with the user name verification");

    }


}
