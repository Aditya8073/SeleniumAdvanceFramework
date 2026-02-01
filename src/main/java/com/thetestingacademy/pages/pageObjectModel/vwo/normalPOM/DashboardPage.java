package com.thetestingacademy.pages.pageObjectModel.vwo.normalPOM;

import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver=driver;
    }

    private By userNameOnDashboard=By.xpath("//h6");

    public String loggedInUserName(){
        driver.get(PropertiesReader.readKey("dashboard_url"));
        String loggedUserName=driver.findElement(userNameOnDashboard).getText();
        return loggedUserName;
    }


}
