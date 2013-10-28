package javawatirmark.page;

import javawatirmark.elements.RadioMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioKeyword extends Keyword{

    public RadioMap rmap;

    public RadioKeyword(By _map, RadioMap _rmap){
        map = _map;
        rmap = _rmap;
    }

    public void set(String value){
        List<WebElement> radios = Session.getInstance().browser.findElements(map);
        for(WebElement radio: radios){
            if(radio.getAttribute("value").equals(rmap.findMatch(value))){
                radio.click();
            }
        }
    }

    public WebElement get(String value){
        WebElement element = null;
        List<WebElement> radios = Session.getInstance().browser.findElements(map);
        for(WebElement radio: radios){
            if(radio.getAttribute("value").equals(rmap.findMatch(value))){
                element = radio;
                break;
            }
        }
        return element;
    }

}
