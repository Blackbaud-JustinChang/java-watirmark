package javawatirmark.page;

import org.openqa.selenium.WebDriver;

public class PageDefinition {

    private static WebDriver browser;

    public static WebDriver browser() {
        browser = Session.getInstance().openbrowser();
        return browser;
    }
}
