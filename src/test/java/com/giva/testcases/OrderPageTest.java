package com.giva.testcases;

import com.giva.baseclass.BaseClass;
import com.giva.dataprovider.DataProviders;
import com.giva.pageobjects.AddToCartPage;
import com.giva.pageobjects.IndexPage;
import com.giva.pageobjects.OrderPage;
import com.giva.pageobjects.SearchResultPage;
import com.giva.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrderPageTest extends BaseClass {

    private IndexPage index;
    private SearchResultPage searchResultPage;
    private AddToCartPage addToCartPage;
    private OrderPage orderPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(String browser) {
        launchApp(browser);
    }

    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown() {
        getDriver().quit();
    }

    @Test(groups = "Regression",dataProvider = "getProduct", dataProviderClass = DataProviders.class)
    public void verifyTotalPrice(String productName, String qty, String size) throws Throwable {
        Log.startTestCase("verifyTotalPrice");
        index= new IndexPage();
        searchResultPage=index.searchProduct(productName);
        addToCartPage=searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity(qty);
        addToCartPage.selectSize(size);
        addToCartPage.clickOnAddToCart();
        orderPage=addToCartPage.clickOnCheckOut();
        Double unitPrice=orderPage.getUnitPrice();
        Double totalPrice=orderPage.getTotalPrice();
        Double totalExpectedPrice=(unitPrice*(Double.parseDouble(qty)))+2;
        Assert.assertEquals(totalPrice, totalExpectedPrice);
        Log.endTestCase("verifyTotalPrice");
    }
}
