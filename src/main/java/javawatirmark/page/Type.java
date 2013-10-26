package javawatirmark.page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public enum Type{
    TEXT_FIELD{
        /* Clears the value in the text field before populating */
        public void handleElement(WebElement element, String value){
            element.clear();
            element.sendKeys(value);
        }
    },
    SELECT_LIST{
        /* Selects based on the visible text of the select list */
        public void handleElement(WebElement element, String value){
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(value);
        }
    },
    CHECKBOX{
        /* If the value passed in is not true, then the checkbox will be set to false */
        public void handleElement(WebElement element, String value){
            boolean checkStatus = Boolean.parseBoolean(value);
            if(checkStatus){
                if(!element.isSelected())
                    element.click();
            } else {
                if(element.isSelected())
                    element.click();
            }
        }
    };

    public abstract void handleElement(WebElement element, String value);
}

