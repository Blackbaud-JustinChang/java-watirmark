package main.java.page;

import main.java.Session;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Keyword {

    public String name;

    public Keyword(String _name){
        name = _name;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return name;
    }

}
