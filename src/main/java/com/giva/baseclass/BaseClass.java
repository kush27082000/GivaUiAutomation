package com.giva.baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.module.Configuration;
import java.util.Properties;

//What is the use of Base Class ?
public class BaseClass {
    public static Properties prop;
    public static WebDriver driver;

    @BeforeTest
    public void loadConfig() {
        try {
        prop = new Properties();
        FileInputStream ip = null;

            ip = new FileInputStream(System.getProperty("user.dir") + "\\Configurations\\config.properties" );
            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void launchApp() {
        WebDriverManager.chromedriver().setup();
        String browserName = prop.getProperty("browser");

        switch (browserName) {
            case "Chrome" -> driver = new ChromeDriver();
            case "Safari" -> driver = new SafariDriver();
            case "FireFox" -> driver = new InternetExplorerDriver();
            default -> System.out.println("incorrect browser name");
        }

    }



}
