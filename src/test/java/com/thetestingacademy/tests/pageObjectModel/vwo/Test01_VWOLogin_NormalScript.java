package com.thetestingacademy.tests.pageObjectModel.vwo;

import com.thetestingacademy.pages.pageObjectModel.vwo.normalPOM.DashboardPage;
import com.thetestingacademy.pages.pageObjectModel.vwo.normalPOM.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.thetestingacademy.driver.DriverManager.driver;
import static com.thetestingacademy.driver.DriverManager.getDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Test01_VWOLogin_NormalScript {

    @Owner("Aditya")
    @Description("Verify the error message by loggin in with invalid vwo credentials")
    @Test(priority = 1)
    public void test_negative_vwo_login(){

        // Driver Manager Code - 1
        WebDriver driver = new FirefoxDriver();

        // Page object model Code (POM Code) - 2
        LoginPage loginPage = new LoginPage(driver);
        String error_message=loginPage.loginToInvalidVwoCredentials("admin@123","123");

        assertThat(error_message).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_message,"Your email, password, IP address or location did not match");

        driver.quit();
    }

    @Owner("Aditya")
    @Description("Verify that with valid vwo credentials dashboard page is loaded")
    @Test
    public void testVWOLoginPositive(){
        try {
            WebDriver driver = new FirefoxDriver();
            LoginPage loginPage=new LoginPage(driver);
            loginPage.loginValidVwoCredentials("hebiva4776@amcret.com","Test@4321");

            DashboardPage dashboardPage = new DashboardPage(driver);
            String loggedInUserName=dashboardPage.loggedInUserName();

            assertThat(loggedInUserName).isNotNull().isNotBlank().isNotEmpty();
            Assert.assertEquals(loggedInUserName,"Amcret");

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            getDriver().quit();
        }
    }
}
