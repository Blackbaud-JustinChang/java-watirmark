package javawatirmark.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Session {

    private static Session instance = null;
    public WebDriver browser;

    protected Session(){
        //Exists only to defeat instantiation;
    }

    public static Session getInstance(){
        if(instance == null)
            instance = new Session();
        return instance;
    }

    public WebDriver openbrowser(){
        if(browser == null)
            browser = newWatirBrowser();
        return browser;
    }

    public WebDriver newWatirBrowser(){
        //TODO add firefox configurations
        browser = new FirefoxDriver();
        return browser;
    }

}
