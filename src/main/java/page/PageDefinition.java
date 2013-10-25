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
    public static HashMap<String, Keyword> keywords = new HashMap<String, Keyword>();

    public static WebDriver browser(){
        if( browser == null)
            browser = Session.getInstance().openbrowser();
        return browser;
    }

    public HashMap<String, Keyword> keywords(){
        return keywords;
    }

    public void getKeywords(){
        for(Field f: this.getClass().getFields()){
            try{
                Object obj = f.get(this);
                if(obj instanceof Keyword){
                    String name = ((Keyword) obj).getName();
                    keywords.put(name, (Keyword)obj);
                }
            } catch(Exception e){
                System.out.println("BAD");
            }
        }
    }

}
