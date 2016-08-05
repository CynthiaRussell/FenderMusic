package com.awesome.fender.page;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class BasePageObject {

    protected WebDriver driver;
    protected Wait<WebDriver> wait;

    public BasePageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = setupWait(driver, 15);

    }

    public void clickElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

    public void sendKeys(WebElement element, String keys){
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys();
        element.clear();
        element.sendKeys(keys);
    }


    /**
     * Will wait for up to 15 seconds (set by the constructor).
     * This is better than a sleep, since it pings for the element every 500 ms
     * @param element
     * @return
     */
    public boolean isElementDisplayed(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    public void openPage(String url){
        driver.get(url);
    }

    public Wait<WebDriver> setupWait(WebDriver driver, Integer timeout) {
        return new FluentWait<>(driver)
                .withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    /**
     * Thread sleeps should never be used. However, this is placed here to slow the execution time and show clicks.
     * @param time
     */
    public void sleepy(int time){
        try{
            TimeUnit.SECONDS.sleep(time);
        }catch (InterruptedException e){
            //always avoid sleeps, but this is just to show that the click worked.
        }
    }
}