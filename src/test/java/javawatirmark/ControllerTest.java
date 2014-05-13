package javawatirmark;

import javawatirmark.model.DefaultValue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ControllerTest {

    private PageController controller;
    private static PageView view;
    private PageModel model;

    @Before
    public void setUp() {
        model = new PageModel();
        controller = new PageController(model);
        view = new PageView();
    }

    @After
    public void tearDown(){
        view.browser().quit();
    }

    @Test
    public void testControllerView(){
        assertEquals(controller.getView().getClass(), new PageView().getClass());
    }

    @Test
    public void testControllerPopulation(){
        controller.create();
        assertEquals(view.firstname.get().getAttribute("value"), "Justin");
        assertEquals(new Select(view.companySelect.get()).getFirstSelectedOption().getText(), "National");
        assert(view.includeEmail.get().isSelected());
        assert(view.gender.get("Female").isSelected());
    }

    @Test
    public void testControllerVerification() {
        controller.create();
        controller.verify();
    }

    @Test
    public void testOverwritePopulateMethod(){
        model.setValue("newPage", new DefaultValue("POPULATED NEWPAGE"));
        PageController newController = new PageController(model);
        newController.create();
        assertEquals(view.newPage.text(), "POPULATED NEWPAGE");
    }

}
