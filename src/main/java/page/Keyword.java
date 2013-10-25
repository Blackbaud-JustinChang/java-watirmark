package main.java.page;

import main.java.Session;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Keyword {

    public By map;

    public Keyword(By _map){
        map = _map;
    }

    public void set(){
        WebElement element = Page.browser().findElement(map);
        String type = element.getTagName();

    }

    public WebElement get(){
        return Page.browser().findElement(map);
    }

}
