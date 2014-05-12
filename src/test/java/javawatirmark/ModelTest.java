package javawatirmark;
import javawatirmark.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ModelTest {

    @Test
    public void testDefaultValueString(){
        DefaultStringValue string = new DefaultStringValue("test");
        assertEquals(string.value, "test");
    }

    @Test
    public void testDefaultValueInteger(){
        DefaultIntegerValue integer = new DefaultIntegerValue(10);
        assertEquals((int) integer.value, 10);
    }

    @Test
    public void testDefaultValueDouble(){
        DefaultDoubleValue doubleValue = new DefaultDoubleValue(10.1);
        assertEquals(doubleValue.value, 10.1, 0);
    }

    @Test
    public void testDefaultListIntegerValue(){
        int[] list = {1, 2, 3};

        DefaultListValue listValue = new DefaultListValue(list);
        Defaults valueOne = listValue.value().get(0);
        Defaults valueTwo = listValue.value().get(1);
        Defaults valueThree = listValue.value().get(2);

        assertEquals(valueOne.value(), 1);
        assertEquals(valueTwo.value(), 2);
        assertEquals(valueThree.value(), 3);
    }

    @Test
    public void testDefaultListDoubleValue(){
        double[] list = {1.1, 2.2, 4.4};

        DefaultListValue listValue = new DefaultListValue(list);
        Defaults valueOne = listValue.value().get(0);
        Defaults valueTwo = listValue.value().get(1);
        Defaults valueThree = listValue.value().get(2);

        assertEquals(valueOne.value(), 1.1);
        assertEquals(valueTwo.value(), 2.2);
        assertEquals(valueThree.value(), 4.4);
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
