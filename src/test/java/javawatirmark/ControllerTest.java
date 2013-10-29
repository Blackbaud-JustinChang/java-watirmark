package javawatirmark;

import javawatirmark.page.Keyword;
import javawatirmark.page.Page;
import javawatirmark.page.Session;
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
public class ControllerTest {

    private PageController controller;

    @Before
    public void setUp(){
        controller = new PageController();
    }

    @AfterClass
    public static void tearDown(){

    }

    @Test
    public void testControllerView(){
        assertEquals(controller.view.getClass(), new PageView().getClass());
    }
}
