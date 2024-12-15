package com.giva.testcases;

import com.giva.baseclass.BaseClass;
import com.giva.dataprovider.DataProviders;
import com.giva.pageobjects.IndexPage;
import com.giva.pageobjects.SearchResultPage;
import com.giva.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchResultPageTest extends BaseClass {
    private IndexPage index;
    private SearchResultPage searchResultPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(String browser) {
        launchApp(browser);
    }

    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown() {
        getDriver().quit();
    }

    @Test(groups = "Smoke",dataProvider = "searchProduct", dataProviderClass = DataProviders.class)
    public void productAvailabilityTest(String productName) throws Throwable {
        Log.startTestCase("productAvailabilityTest");
        index= new IndexPage();
        searchResultPage=index.searchProduct(productName);
        boolean result=searchResultPage.isProductAvailable();
        Assert.assertTrue(result);
        Log.endTestCase("productAvailabilityTest");
    }

}
