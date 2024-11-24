package com.giva.baseclass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.module.Configuration;
import java.util.Properties;

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

}
