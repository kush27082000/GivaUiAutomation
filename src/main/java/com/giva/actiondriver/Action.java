package com.giva.actiondriver;

import com.giva.actioninterface.ActionInterface;
import com.giva.baseclass.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action extends BaseClass implements ActionInterface {

    @Override
    public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
        //In Selenium There is no command for that so need to use Javascript scrolling by visibility of element in a view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", ele);
    }

    @Override
    public void click(WebDriver ldriver, WebElement ele) {
        //build().perform() method is necessary for any Action classes
         Actions act = new Actions(driver);
         act.moveToElement(ele).click().build().perform();
    }

    @Override
    public boolean isDisplayed(WebDriver ldriver, WebElement ele) {
        boolean flag = false;
        flag = ele.isDisplayed();
        if (flag) {
            System.out.println("The element is Displayed");
        } else {
            System.out.println("The element is not Displayed");
        }
        return flag;
    }

    @Override
    public boolean type(WebElement ele, String text) {
        boolean flag = ele.isDisplayed();
        if(flag) {
            ele.clear();
            ele.sendKeys(text);
            System.out.println("The Text is Sent For Write");
        } else {
            System.out.println("The element is not Displayed So The Text is not Sent For Write");
        }
        return flag;
    }

    @Override
    public boolean findElement(WebDriver ldriver, WebElement ele) {
        boolean flag = false;
        flag = ele.isDisplayed();
        if (flag) {
            System.out.println("The element is Displayed");
        } else {
            System.out.println("The element is not Displayed");
        }
        return flag;
    }

    @Override
    public boolean isSelected(WebDriver ldriver, WebElement ele) {
        boolean flag = false;
        flag = ele.isSelected();
        if (flag) {
            System.out.println("The element is Displayed");
        } else {
            System.out.println("The element is not Displayed");
        }
        return flag;
    }

    @Override
    public boolean isEnabled(WebDriver ldriver, WebElement ele) {
        boolean flag = false;
        flag = ele.isEnabled();
        if (flag) {
            System.out.println("The element is Displayed");
        } else {
            System.out.println("The element is not Displayed");
        }
        return flag;
    }

    @Override
    public boolean selectBySendkeys(String value, WebElement ele) {
        boolean flag = ele.isDisplayed();
        if(flag) {
            ele.clear();
            ele.sendKeys(value);
            System.out.println("Drop Down Values Are Available");
            System.out.println("Can Select value from the DropDown");
        } else {
            System.out.println("The element is not Displayed So The Text is not Sent For Write And Can not generate Dropdowns");
        }
        return flag;
    }

    @Override
    public boolean selectByIndex(WebElement element, int index) {
        return false;
    }

    @Override
    public boolean selectByValue(WebElement element, String value) {
        return false;
    }

    @Override
    public boolean selectByVisibleText(String visibletext, WebElement ele) {
        return false;
    }

    @Override
    public boolean mouseHoverByJavaScript(WebElement locator) {
        return false;
    }

    @Override
    public boolean JSClick(WebDriver driver, WebElement ele) {
        return false;
    }

    @Override
    public boolean switchToFrameByIndex(WebDriver driver, int index) {
        return false;
    }

    @Override
    public boolean switchToFrameById(WebDriver driver, String idValue) {
        return false;
    }

    @Override
    public boolean switchToFrameByName(WebDriver driver, String nameValue) {
        return false;
    }

    @Override
    public boolean switchToDefaultFrame(WebDriver driver) {
        return false;
    }

    @Override
    public void mouseOverElement(WebDriver driver, WebElement element) {

    }

    @Override
    public boolean moveToElement(WebDriver driver, WebElement ele) {
        return false;
    }

    @Override
    public boolean mouseover(WebDriver driver, WebElement ele) {
        return false;
    }

    @Override
    public boolean draggable(WebDriver driver, WebElement source, int x, int y) {
        return false;
    }

    @Override
    public boolean draganddrop(WebDriver driver, WebElement source, WebElement target) {
        return false;
    }

    @Override
    public boolean slider(WebDriver driver, WebElement ele, int x, int y) {
        return false;
    }

    @Override
    public boolean rightclick(WebDriver driver, WebElement ele) {
        return false;
    }

    @Override
    public boolean switchWindowByTitle(WebDriver driver, String windowTitle, int count) {
        return false;
    }

    @Override
    public boolean switchToNewWindow(WebDriver driver) {
        return false;
    }

    @Override
    public boolean switchToOldWindow(WebDriver driver) {
        return false;
    }

    @Override
    public int getColumncount(WebElement row) {
        return 0;
    }

    @Override
    public int getRowCount(WebElement table) {
        return 0;
    }

    @Override
    public boolean Alert(WebDriver driver) {
        return false;
    }

    @Override
    public boolean launchUrl(WebDriver driver, String url) {
        return false;
    }

    @Override
    public boolean isAlertPresent(WebDriver driver) {
        return false;
    }

    @Override
    public String getCurrentURL(WebDriver driver) {
        return "";
    }

    @Override
    public String getTitle(WebDriver driver) {
        return "";
    }

    @Override
    public boolean click1(WebElement locator, String locatorName) {
        return false;
    }

    @Override
    public void fluentWait(WebDriver driver, WebElement element, int timeOut) {

    }

    @Override
    public void implicitWait(WebDriver driver, int timeOut) {

    }

    @Override
    public void explicitWait(WebDriver driver, WebElement element, int timeOut) {

    }

    @Override
    public void pageLoadTimeOut(WebDriver driver, int timeOut) {

    }

    @Override
    public String screenShot(WebDriver driver, String filename) {
        return "";
    }

    @Override
    public String getCurrentTime() {
        return "";
    }
}
