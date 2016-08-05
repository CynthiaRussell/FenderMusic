package com.awesome.fender.page;

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

    public void addItemToCard(){
        clickElement(selectAddToCart);
    }

    public void selectViewCart(){
        clickElement(viewCart);
    }

    public void verifyProduct(String cartContainer){
        String bodyText = driver.findElement(By.cssSelector(cartContainer)).getText();
        Assert.assertTrue("Product text not found!", bodyText.contains("JIMI HENDRIX STRATOCASTER®"));
    }

    public void verifyQuantity(String quanitityDropDownMenu) {
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
