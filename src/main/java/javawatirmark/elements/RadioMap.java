package javawatirmark.elements;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RadioMap {

    public HashMap<String, String> map;

    public RadioMap(Pair... pairs) {
        map = new HashMap<>();
        for (Pair pair : pairs) {
            map.put((String) pair.getKey(), (String) pair.getValue());
        }
    }

    public String findMatch(String value) {
        Set<String> keys = map.keySet();
        String matchedValue = "";
        for (String key : keys) {
            Pattern pattern = Pattern.compile(key);
            Matcher matcher = pattern.matcher(value);
            if (matcher.find()) {
                matchedValue = map.get(key);
                break;
            }
        }
        return matchedValue;
    }


}
