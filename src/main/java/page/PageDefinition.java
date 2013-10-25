package main.java.page;

import main.java.Session;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.lang.reflect.Field;
import java.util.HashMap;

public class PageDefinition {

    private static WebDriver browser;


    public static WebDriver browser(){
        if( browser == null)
            browser = Session.getInstance().openbrowser();
        return browser;
    }





}
