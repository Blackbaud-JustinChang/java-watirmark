package test.java;

import main.java.page.Keyword;
import main.java.page.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class Test {


    public static void main(String[] args) throws Exception {
        PageView a = new OtherView();
        HashMap<String, Keyword> keywords = a.getKeywords();
        System.out.println(keywords.toString());
        Page.browser().get("http://www.google.com");
        a.search.set();
//        a.search.get().sendKeys("CHEESE!");
//        WebElement element = Page.browser().findElement(By.name("q"));
//        element.sendKeys("Cheese!");

    }



}


