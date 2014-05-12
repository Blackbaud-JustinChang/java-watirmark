package javawatirmark.model;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: kyle.martinez
 * Date: 5/8/14
 * Time: 9:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultListValue implements Defaults {

    public ArrayList<Defaults> values;

    public DefaultListValue(int[] listValues)
    {
        values = new ArrayList<>();
        for (int val :listValues)
        {
            values.add(new DefaultIntegerValue(val));
        }
    }

    public DefaultListValue(double[] listValues)
    {
        values = new ArrayList<>();
        for (double val :listValues)
        {
            values.add(new DefaultDoubleValue(val));
        }
    }

    public DefaultListValue(String[] listValues)
    {
        values = new ArrayList<>();
        for (String val :listValues)
        {
            values.add(new DefaultStringValue(val));
        }
    }

    public ArrayList<Defaults> value()
    {
        return values;
    }
}
