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

    public DefaultListValue(String[] listValues)
    {
        values = new ArrayList<>();
        for (String val :listValues)
        {
            values.add(new DefaultValue(val));
        }
    }

    public ArrayList<Defaults> value()
    {
        return values;
    }
}
