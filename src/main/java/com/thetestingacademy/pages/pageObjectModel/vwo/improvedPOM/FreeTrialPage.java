package com.thetestingacademy.pages.pageObjectModel.vwo.improvedPOM;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class FreeTrialPage extends CommonToAllPage {

    public static WebDriver driver;

    public FreeTrialPage(WebDriver driver){
        this.driver=driver;
    }

    private By start_free_trial_link=By.xpath("//a[text()=\"Start a free trial\"]");
    private By vwo_logo=By.xpath("//a[@title='VWO Logo']");
    private By email_input_box=By.id("page-v1-step1-email");
    private By gdpr_checkbox=By.xpath("//input[@data-qa='page-free-trial-step1-gdpr-consent-checkbox']");
    private By checkbox_label=By.xpath("//label[contains(text(),\"I agree to\")]");
    private By createButton=By.xpath("//button[text()=\"Create a Free Trial Account\"]");
    private By first_name=By.xpath("//input[@data-qa='page-su-v1-fname']");
    private By last_name=By.xpath("//input[@data-qa='page-su-v1-lname']");
    private By phone_number=By.xpath("//input[@data-qa='page-su-v1-pnumber']");
    private By gdpr2_checkbox=By.xpath("//input[@data-qa='page-free-trial-step2-gdpr-consent-checkbox']");
    private By createAccountButton=By.xpath("//button[text()='Create Account']");
    private By skiplink=By.xpath("//button[contains(text(),'skip & continue to app')]");
    private By firstNameLabel=By.xpath("//label[text()=\"First Name \"]");


    public void clickOnStratFreeTrialLink(){
        openVWOUrl();
        clickElement(start_free_trial_link);
        WaitHelpers.checkVisibility(driver, vwo_logo);
    }

    public void createFreeTrialAccount(String email){
        enterInput(email_input_box, email);
        driver.findElement(with(gdpr_checkbox).toLeftOf(checkbox_label)).click();
        WaitHelpers.checkVisibility(driver, createButton);
        clickElement(createButton);
    }

    public void fillPersonalDetails(String fname, String lname, String pnumber){
        WaitHelpers.checkVisibility(driver, firstNameLabel);
        enterInput(first_name,fname);
        enterInput(last_name, lname);
        enterInput(phone_number, pnumber);
        //driver.findElement(with(gdpr2_checkbox).toLeftOf(checkbox_label)).click();
        WaitHelpers.checkVisibility(driver, createAccountButton);
        clickElement(createAccountButton);
        if(WaitHelpers.isElementDisplayed(skiplink)){
            clickElement(skiplink);
        }
        else {
            System.out.println("Skip link not displayed");
        }
    }
}
