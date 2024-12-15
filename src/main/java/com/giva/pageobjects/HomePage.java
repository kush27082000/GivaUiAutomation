package com.giva.pageobjects;

import com.giva.actiondriver.Action;
import com.giva.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    Action action= new Action();

    @FindBy(xpath="//span[text()='My wishlists']")
    private WebElement myWishList;

    @FindBy(xpath = "//span[text()='Order history and details']")
    private WebElement orderHistory;

    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }


    public boolean validateMyWishList() throws Throwable {
        return action.isDisplayed(getDriver(), myWishList);
    }

    public boolean validateOrderHistory() throws Throwable {
        return action.isDisplayed(getDriver(), orderHistory);
    }

    public String getCurrURL() throws Throwable {
        String homePageURL=action.getCurrentURL(getDriver());
        return homePageURL;
    }
}
