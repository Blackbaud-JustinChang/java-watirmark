package javawatirmark;

import javawatirmark.elements.Type;
import javawatirmark.page.Keyword;
import org.openqa.selenium.By;

public class OtherView extends PageView {

    public static Keyword lastname = new Keyword(Type.TEXT_FIELD, By.name("lastname"));


    public OtherView() {
        createKeywords();
    }


}