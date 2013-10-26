package main.java.page;

import main.java.Session;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class Keyword {

    public By map;

    private enum InputType{
        text, password, checkbox, radio, submit
    }

    public Keyword(By _map){
        map = _map;
    }

    public void set(String value){
        WebElement element = Page.browser().findElement(map);
        String tagName = element.getTagName();
        if(tagName.equals("input")){
            InputType type = InputType.valueOf(element.getAttribute("type"));
            switch(type){
                case text:
                    element.sendKeys(value);
                    break;
                case checkbox:
                    checkboxHandler(element, value);
                    break;


            }
        }
        else if(tagName.equals("select")){
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(value);
        }

    }

    public WebElement get(){
        return Page.browser().findElement(map);
    }

    /* If the value passed in is not true, then the checkbox will be set to false */
    private void checkboxHandler(WebElement element, String value){
        boolean checkStatus = Boolean.parseBoolean(value);
        if(checkStatus){
            if(!element.isSelected())
                element.click();
        } else {
            if(element.isSelected())
                element.click();
        }

    }

}
