package test.java;

import main.java.page.Keyword;
import main.java.page.Page;
import org.openqa.selenium.By;

public class PageView extends Page {

    public Keyword search = new Keyword(By.name("q"));
//    public Keyword teamdivisions = new Keyword();

    public PageView(){
        createKeywords();
    }


}


