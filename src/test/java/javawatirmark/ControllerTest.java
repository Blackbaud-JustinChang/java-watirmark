package javawatirmark;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ControllerTest {

    private PageController controller;
    private PageView view;
    private HashMap model;

    @Before
    public void setUp() {
        model = new HashMap();
        model.put("firstname", "Bobby");
        model.put("companySelect", "Regional");
        model.put("includeEmail", "True");
        model.put("gender", "Male");
        controller = new PageController(model);
        view = new PageView();

    }

    @AfterClass
    public static void tearDown(){

    }

    @Test
    public void testControllerView(){
        assertEquals(controller.getView().getClass(), new PageView().getClass());
    }

    @Test
    public void testControllerPopulation(){
        controller.create();
        assertEquals(view.firstname.get().getAttribute("value"), "Bobby");
        assertEquals(new Select(view.companySelect.get()).getFirstSelectedOption().getText(), "Regional");
        assert(view.includeEmail.get().isSelected());
        assert(view.gender.get("Male").isSelected());
    }

    @Test
    public void testControllerVerification() {
        controller.verify();
    }
}
