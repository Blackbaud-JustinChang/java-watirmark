package javawatirmark;

import javafx.util.Pair;
import javawatirmark.elements.RadioMap;
import javawatirmark.elements.Type;
import javawatirmark.page.*;
import org.openqa.selenium.By;

public class PageView extends Page {

    public Keyword firstname = new Keyword(Type.TEXT_FIELD, By.name("firstname"));
    public Keyword companySelect = new Keyword(Type.SELECT_LIST, By.id("company"));
    public Keyword includeEmail = new Keyword(Type.CHECKBOX, By.name("mailing_list"));
    public RadioKeyword gender = new RadioKeyword(By.name("sex"),
            new RadioMap(new Pair<>("Male|Guy", "0"),
                         new Pair<>("Female|Girl", "1")));

    public PageView(){
        createKeywords();
    }


}


