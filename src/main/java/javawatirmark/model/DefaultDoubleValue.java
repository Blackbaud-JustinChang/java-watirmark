package javawatirmark.model;

/**
 * Created with IntelliJ IDEA.
 * User: kyle.martinez
 * Date: 5/12/14
 * Time: 12:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultDoubleValue implements Defaults {

    public Double value;

    public DefaultDoubleValue(Double val)
    {
        value = val;
    }

    public Double value()
    {
        return value;
    }

}
