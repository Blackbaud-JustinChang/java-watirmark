package javawatirmark.model;

/**
 * Created with IntelliJ IDEA.
 * User: kyle.martinez
 * Date: 5/12/14
 * Time: 12:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultIntegerValue implements Defaults {

    public Integer value;

    public DefaultIntegerValue(Integer val)
    {
        value = val;
    }

    public Integer value()
    {
        return value;
    }


}
