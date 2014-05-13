package javawatirmark;

import javafx.util.Pair;
import javawatirmark.elements.RadioMap;
import javawatirmark.elements.Type;
import javawatirmark.model.Model;
import javawatirmark.page.Keyword;
import javawatirmark.page.Page;
import javawatirmark.page.RadioKeyword;
import org.openqa.selenium.By;

import java.io.File;
import java.util.HashMap;

public class PageView extends Page {

    public static Keyword firstname = new Keyword(Type.TEXT_FIELD, By.name("firstname"));
    public static Keyword companySelect = new Keyword(Type.SELECT_LIST, By.id("company"));
    public static Keyword includeEmail = new Keyword(Type.CHECKBOX, By.name("mailing_list"));
    public static RadioKeyword gender = new RadioKeyword(By.name("sex"),
                                        new RadioMap(new Pair<>("Male|Guy", "0"),
                                        new Pair<>("Female|Girl", "1")));

    public static Keyword newPage = new Keyword(Type.H1, By.id("test"));

    public PageView() {
        createKeywords();
    }

    public void home(Model model) {
        File file = new File("src/test/resources/page_test.html");
        browser().get("file://"+file.getAbsolutePath());
    }


    public void create(Model model) {
        home(model);
    }
}


