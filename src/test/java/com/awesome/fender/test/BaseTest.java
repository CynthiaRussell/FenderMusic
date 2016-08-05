package com.awesome.fender.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    public static final String BASE_URL = "http://shop.fender.com/en-US/";

    protected WebDriver driver;

    @BeforeSuite
    public void setup(){

        String driverType = System.getProperty("driverType");
        if(driverType == null || driverType.isEmpty()){
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();

        }else
        {
            //could be used from maven command line to init different drivers.
            //unused, but for demo
        }


    }

    @AfterSuite
    public void killDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
