package javawatirmark;

import javawatirmark.page.*;
import org.openqa.selenium.By;

public class PageView extends Page {

    public Keyword firstname = new Keyword(Type.TEXT_FIELD, By.name("firstname"));
    public Keyword companySelect = new Keyword(Type.SELECT_LIST, By.id("company"));
    public Keyword includeEmail = new Keyword(Type.CHECKBOX, By.name("mailing_list"));

    public PageView(){
        createKeywords();
    }


}


