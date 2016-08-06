package com.awesome.fender.page;

import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;


public class ShopPage extends BasePageObject {

    @FindBy(css = "#home-slot-2-container > article > div:nth-child(2) > div:nth-child(4) > a > div.thbcopy > p.subhead")
    private WebElement shopFenderPageUniqueElement;

    @FindBy(css = "#search-value")
    private WebElement searchBar;

    @FindBy(css = "#navigation > nav.nav-content.site-search.visible-desktop > div > form > div > button")
    private WebElement submitButton;

    @FindBy(css = ".add-to-cart.large.button.full.green-btn")
    private WebElement selectAddToCart;

    @FindBy(css = ".mini-cart-label")
    private WebElement viewCart;

    @FindBy(css = ".row.vpad.element")
    private WebElement cartContainer;

    @FindBy(css = ".icon-arrow-bottom")
    private WebElement quanitityDropDownMenu;

    @FindBy(css = "product-price price-total")
    private WebElement productPriceElement;

    @FindBy(css = ".arrow-circle.tablet-small")
    private WebElement secureCheckout;

    @FindBy(css = ".large.full.button.green-btn")
    private WebElement guestCheckout;


    public ShopPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickShopFender(){
        clickElement(shopFenderPageUniqueElement);
    }

    public void setSearchInput(java.lang.String keys){
        sendKeys(searchBar, keys);
    }

    public void searchSubmitButton(){
        clickElement(submitButton);
    }

//    public void addItemToCard(java.lang.String element){
//        moveToElement(driver.findElement(By.cssSelector(".add-to-cart.large.button.full.green-btn")));
//        clickElement(selectAddToCart);
//    }

    public void selectViewCart(){
        clickElement(viewCart);
    }

    public void verifyProduct(String cartContainer){
        java.lang.String bodyText = driver.findElement(By.cssSelector(java.lang.String.valueOf(cartContainer))).getText();
        Assert.assertTrue("Product text not found!", bodyText.contains("JIMI HENDRIX STRATOCASTER®"));
    }

    public void verifyQuantity(java.lang.String quanitityDropDownMenu) {
        List<WebElement> listOfQuantity = driver.findElements(By.cssSelector(quanitityDropDownMenu));
        log.info(listOfQuantity.get(0).getText());
        Assert.assertEquals("The quantity is not what we found!", true, quanitityDropDownMenu);
    }

    public void selectSecureCheckout(){
        clickElement(secureCheckout);
    }

    public void selectGuestCheckout(){
        clickElement(guestCheckout);
    }






}
