package com.thetestingacademy.pages.pageObjectModel.vwo.improvedPOM;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends CommonToAllPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    private By userNameOnDashboard = By.xpath("//h6[contains(@class,'Fw(medium) Mb(0) Mend(4px')]");

    //Page Actions
    public String loggedInUserName(){
        WaitHelpers.visibilityOfElementLocated(userNameOnDashboard);
        return getText(userNameOnDashboard);
    }
}
