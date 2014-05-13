package javawatirmark.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: kyle.martinez
 * Date: 1/22/14
 * Time: 4:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultValue implements Defaults {
    public String value;

    public DefaultValue(String val)
    {
        value = val;
    }

    public String value()
    {
        return value;
    }
}

