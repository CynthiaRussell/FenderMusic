package com.awesome.fender.test;

import com.awesome.fender.page.BasePageObject;
import com.awesome.fender.page.ShopPage;

import com.sun.org.apache.xpath.internal.operations.String;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ShopFenderGuitarTest extends BaseTest{


    private String expectedGuitarName;
    private String searchName;


    @BeforeSuite
    public void setupTest(){
        //do stuff
    }

    @BeforeMethod
    public void setupStuffBeforeMethods(){
        //do something before each test case
    }

    @Test
    public void clickGuitarsFinestTest(){
        ShopPage shopPage = new ShopPage(driver);
        shopPage.openPage(BASE_URL);
        BasePageObject basePageObject = new BasePageObject(driver);
        shopPage.setSearchInput("JIMI HENDRIX STRATOCASTER®");
        shopPage.searchSubmitButton();
//        shopPage.addItemToCard();





    }


}
