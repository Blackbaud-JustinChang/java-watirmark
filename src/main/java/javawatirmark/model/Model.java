package javawatirmark.model;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Justin
 * Date: 10/27/13
 * Time: 10:31 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Model {
    public class DefaultValue {
        String value;

        public DefaultValue(String _str) {
            value = _str;
        }

        public String get() {
            return value;
        }
    }

    public HashMap<String, DefaultValue> map;

    public Model() {
        map = new HashMap<String, DefaultValue>();
    }

    public Model(HashMap<String, DefaultValue> _map) {
        map = _map;
    }

    public String getValue(String str) {
        return map.get(str).get();
    }

    public HashMap<String, DefaultValue> getDefaultValues() {
        return map;
    }

    public void createDefaultValues() {
        for (Field f : this.getClass().getFields()) {
            try {
                Object obj = f.get(this);
                if (obj instanceof DefaultValue) {
                    String name = f.getName();
                    map.put(name, (DefaultValue) obj);
                }
            } catch (Exception e) {
                System.out.println("BAD");
            }
        }
    }
}
