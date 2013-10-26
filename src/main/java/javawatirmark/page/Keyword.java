package javawatirmark.page;

import javawatirmark.elements.RadioMap;
import javawatirmark.elements.Type;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Keyword {

    public By map;
    public Type type;


    public Keyword(){
    }

    public Keyword(Type _type, By _map){
        map = _map;
        type = _type;
    }



    public void set(String value){
        WebElement element = Page.browser().findElement(map);
        type.handleElement(element, value);
    }

    public WebElement get(){
        return Page.browser().findElement(map);
    }
}
