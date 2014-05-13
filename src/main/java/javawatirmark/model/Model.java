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
    public HashMap<String, Defaults> map;

    public Model() {
        map = new HashMap<String, Defaults>();
    }

    public Model(HashMap<String, Defaults> _map) {
        map = _map;
    }

    public Object getValue(String key) {
        if (map.get(key) == null)
        {
            return null;
        }
        else
        {
            return map.get(key).value();
        }

    }

    public void setValue(String key, Defaults value)
    {
        map.put(key, value);
    }

    public void createDefaultValues() {
        for (Field f : this.getClass().getFields()) {
            try {
                Object obj = f.get(this);
                if (obj instanceof Defaults) {
                    String name = f.getName();
                    map.put(name, (Defaults) obj);
                }
            } catch (Exception e) {
                System.out.println("BAD");
            }
        }
    }
}
