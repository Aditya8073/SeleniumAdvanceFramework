package com.thetestingacademy.pages.pageObjectModel.vwo.normalPOM;

import com.thetestingacademy.utils.PropertiesReader;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    // Step 1- Page Locators
    private By userName=By.id("login-username");
    private By password=By.id("login-password");
    private By signInButton=By.id("js-login-btn");
    private By errorMessage=By.id("js-notification-box-msg");

    // If you are not using it , don't keep.
    //private By signBySSO = By.xpath("//button[normalize-space()='Sign in using SSO']");

    // Step 2 - Page Actions
    public String loginToInvalidVwoCredentials(String user, String pass){
        driver.get(PropertiesReader.readKey("url"));
        driver.findElement(userName).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(signInButton).click();

        WaitHelpers.checkVisibility(driver,errorMessage,5);
        String error_message_text=driver.findElement(errorMessage).getText();
        return error_message_text;
    }

    public void loginValidVwoCredentials(String user, String pass){
        driver.get(PropertiesReader.readKey("url"));
        driver.findElement(userName).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(signInButton).click();

    }
}
