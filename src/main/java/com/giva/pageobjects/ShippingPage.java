package com.giva.pageobjects;

import com.giva.actiondriver.Action;
import com.giva.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends BaseClass {

    Action action= new Action();

    @FindBy(id="cgv")
    private WebElement terms;

    @FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckOutBtn;

    public ShippingPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void checkTheTerms() throws Throwable {
        action.click(getDriver(), terms);
    }

    public PaymentPage clickOnProceedToCheckOut() throws Throwable {
        action.click(getDriver(), proceedToCheckOutBtn);
        return new PaymentPage();
    }

}
