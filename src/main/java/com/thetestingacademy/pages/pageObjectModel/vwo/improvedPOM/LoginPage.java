package com.thetestingacademy.pages.pageObjectModel.vwo.improvedPOM;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.thetestingacademy.driver.DriverManager.getDriver;

public class LoginPage extends CommonToAllPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    // Step 1- Page Locators
    private By userName=By.id("login-username");
    private By password=By.id("login-password");
    private By signInButton=By.id("js-login-btn");
    private By errorMessage=By.id("js-notification-box-msg"); //same for deleted account and invalid account


    // If you are not using it , don't keep.
    //private By signBySSO = By.xpath("//button[normalize-space()='Sign in using SSO']");

    // Step 2 - Page Actions
    public String loginToInvalidVWOCredentials(String user, String pass){
        openVWOUrl();
        enterInput(userName,user);
        enterInput(password, pass);
        clickElement(signInButton);
        WaitHelpers.checkVisibility(getDriver(), errorMessage);
        return getText(errorMessage);
    }

    public void loginToValidVWOCredentials(String user, String pass){
        openVWOUrl();
        enterInput(userName,user);
        enterInput(password, pass);
        clickElement(signInButton);
    }

    public String loginToDeletedVWOCredentials(String user, String pass){
        openVWOUrl();
        enterInput(userName,user);
        enterInput(password,pass);
        clickElement(signInButton);
        WaitHelpers.checkVisibility(getDriver(),errorMessage);
        return getText(errorMessage);
    }


}
