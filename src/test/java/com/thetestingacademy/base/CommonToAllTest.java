package com.thetestingacademy.base;

import com.thetestingacademy.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.sql.Driver;

public class CommonToAllTest extends DriverManager {

    @BeforeMethod
    public void setup(){
        DriverManager.init();
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.down();
    }

}
