package javawatirmark;
import javawatirmark.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ModelTest {

    @Test
    public void testDefaultValueString(){
        DefaultValue string = new DefaultValue("test");
        assertEquals(string.value, "test");
    }

    @Test
    public void testDefaultListStringValue(){
        String[] list = {"one", "two", "three"};

        DefaultListValue listValue = new DefaultListValue(list);
        Defaults valueOne = listValue.value().get(0);
        Defaults valueTwo = listValue.value().get(1);
        Defaults valueThree = listValue.value().get(2);

        assertEquals(valueOne.value(), "one");
        assertEquals(valueTwo.value(), "two");
        assertEquals(valueThree.value(), "three");
    }

    @Test
    public void testModel(){
        PageModel x = new PageModel();
        assertEquals(x.getValue("firstname"), "Justin");
        assertEquals(x.getValue("companySelect"), "National");
        assertEquals(x.getValue("gender"), "Female");
    }
}
