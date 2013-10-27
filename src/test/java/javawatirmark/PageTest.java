package javawatirmark;

import javawatirmark.page.Keyword;
import javawatirmark.page.Page;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(JUnit4.class)
public class PageTest {

    private PageView view;
    private PageView viewChild;
    private static WebDriver browser;

    @Before
    public void setUp(){
        view = new PageView();
        viewChild = new OtherView();
        browser = Page.browser();
        File file = new File("src/test/resources/page_test.html");
        browser.get(file.getAbsolutePath());
    }

    @AfterClass
    public static void tearDown(){
        browser.quit();
    }

    @Test
    public void testKeywords(){
        HashMap<String, Keyword> keywords = view.getKeywords();
        Set<String> keys = keywords.keySet();
        Set<String> keysTestSet = new HashSet<String>();
        keysTestSet.add("firstname");
        keysTestSet.add("companySelect");
        keysTestSet.add("includeEmail");
        keysTestSet.add("gender");
        assertEquals(keys, keysTestSet);
    }

    @Test
    public void testKeywordInheritance(){
        HashMap<String, Keyword> keywords = viewChild.getKeywords();
        Set<String> keys = keywords.keySet();
        Set<String> keysTestSet = new HashSet<String>();
        keysTestSet.add("firstname");
        keysTestSet.add("companySelect");
        keysTestSet.add("includeEmail");
        keysTestSet.add("lastname");
        keysTestSet.add("gender");
        assertEquals(keys, keysTestSet);
    }

    @Test
    public void testPagePopulateTextField(){
        view.firstname.set("John");
        assertEquals(view.firstname.get().getAttribute("value"), "John");
    }

    @Test
    public void testPagePopulateSelectList(){
        view.companySelect.set("Regional");
        Select dropDown = new Select(view.companySelect.get());
        assertEquals(dropDown.getFirstSelectedOption().getText(), "Regional");
    }

    @Test
    public void testPagePopulateCheckbox(){
        view.includeEmail.set("True");
        assert(view.includeEmail.get().isSelected());
        view.includeEmail.set("False");
        assertFalse(view.includeEmail.get().isSelected());
    }

    @Test
    public void testPagePopulateRadio(){
        view.gender.set("Male");
        assert(view.gender.get("Male").isSelected());
        view.gender.set("Guy");
        assert(view.gender.get("Guy").isSelected());
        view.gender.set("Female");
        assert(view.gender.get("Female").isSelected());
        view.gender.set("Girl");
        assert(view.gender.get("Girl").isSelected());
    }
}
