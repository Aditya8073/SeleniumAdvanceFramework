package com.thetestingacademy.driver;

import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    public static WebDriver driver;

    public static void init(){
        String browser=PropertiesReader.readKey("browser");
        browser.toLowerCase();
        switch(browser){
            case "edge":
                EdgeOptions edgeOptions=new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--guest");
                driver=new EdgeDriver(edgeOptions);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions=new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                firefoxOptions.addArguments("--guest");
                driver=new FirefoxDriver(firefoxOptions);
                driver.manage().window().maximize();
                break;

            case "chrome":
                ChromeOptions chromeOptions=new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--guest");
                driver=new ChromeDriver(chromeOptions);
                break;

            default:
                System.out.println("No browser supported");

        }
    }
    public static void down(){
        if(getDriver()!=null){
            driver.quit();
            driver=null;
        }
    }
}
