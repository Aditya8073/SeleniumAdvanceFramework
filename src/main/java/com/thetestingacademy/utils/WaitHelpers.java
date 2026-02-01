package com.thetestingacademy.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.thetestingacademy.driver.DriverManager.driver;
import static com.thetestingacademy.driver.DriverManager.getDriver;

public class WaitHelpers {

    public static void waitJVM(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        }
    public static void implicitWait(WebDriver driver,int time){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    public static void checkVisibility(WebDriver driver, By locator, int time){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void checkVisibility(WebDriver driver,By locator){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement visibilityOfElementLocated(By elementLocator){
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    public static WebElement visibilityOfElement(WebElement webElement){
        return new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(webElement));
    }
    public static boolean isElementDisplayed(By by){
        try {
            visibilityOfElementLocated(by);
            return getDriver().findElement(by).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
}
