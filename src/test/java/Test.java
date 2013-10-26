package test.java;

import main.java.page.Keyword;
import main.java.page.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.HashMap;

public class Test {


    public static void main(String[] args) throws Exception {
        PageView view = new OtherView();
        HashMap<String, Keyword> keywords = view.getKeywords();
        System.out.println(keywords.toString());
        File file = new File("src/test/resources/page_test.html");
        Page.browser().get(file.getAbsolutePath());
        view.firstname.set("Hello");

    }



}


