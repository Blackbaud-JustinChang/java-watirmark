package test.java;

import main.java.page.Keyword;
import main.java.page.Page;
import org.openqa.selenium.By;

public class PageView extends Page {

    public Keyword firstname = new Keyword(By.name("firstname"));
    public Keyword companySelect = new Keyword(By.id("company"));
    public Keyword includeEmail = new Keyword(By.name("mailing_list"));

    public PageView(){
        createKeywords();
    }


}


