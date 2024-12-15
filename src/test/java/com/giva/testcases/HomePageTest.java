package com.giva.testcases;

import com.giva.baseclass.BaseClass;
import com.giva.dataprovider.DataProviders;
import com.giva.pageobjects.HomePage;
import com.giva.pageobjects.IndexPage;
import com.giva.pageobjects.LoginPage;
import com.giva.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {
    private IndexPage indexPage;
    private LoginPage loginPage;
    private HomePage homePage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(String browser) {
        launchApp(browser);
    }

    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown() {
        getDriver().quit();
    }

    @Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
    public void wishListTest(String uname, String pswd) throws Throwable {
        Log.startTestCase("wishListTest");
        indexPage= new IndexPage();
        loginPage=indexPage.clickOnSignIn();
        homePage=loginPage.login(uname,pswd,homePage);
        boolean result=homePage.validateMyWishList();
        Assert.assertTrue(result);
        Log.endTestCase("wishListTest");
    }

    @Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
    public void orderHistoryandDetailsTest(String uname, String pswd) throws Throwable {
        Log.startTestCase("orderHistoryandDetailsTest");
        indexPage= new IndexPage();
        loginPage=indexPage.clickOnSignIn();
        homePage=loginPage.login(uname,pswd,homePage);
        boolean result=homePage.validateOrderHistory();
        Assert.assertTrue(result);
        Log.endTestCase("orderHistoryandDetailsTest");
    }

}
