package main.java.page;

import main.java.Session;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Keyword {

    public By map;

    private enum ElementType{
        input, select, table
    }

    public Keyword(By _map){
        map = _map;
    }

    public void set(String value){
        WebElement element = Page.browser().findElement(map);
        ElementType type = ElementType.valueOf(element.getTagName());
        switch(type){
            case input:
                element.sendKeys(value);
        }

    }

    public WebElement get(){
        return Page.browser().findElement(map);
    }

}
