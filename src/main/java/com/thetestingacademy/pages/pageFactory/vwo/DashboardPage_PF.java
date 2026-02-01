package com.thetestingacademy.pages.pageFactory.vwo;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage_PF extends CommonToAllPage {
    WebDriver driver;

    public DashboardPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //private By userNameOnDashboard = By.xpath("//h6[contains(@class,'Fw(medium) Mb(0) Mend(4px')]");
    @FindBy(xpath = "//h6[contains(@class,'Fw(medium) Mb(0) Mend(4px')]")
    private By userNameOnDashboard;

    //Page Actions
    public String loggedInUserName() {
        WaitHelpers.visibilityOfElementLocated(userNameOnDashboard);
        return getText(userNameOnDashboard);
    }
}
