package javawatirmark.page;

import org.openqa.selenium.WebDriver;

import java.lang.reflect.Field;
import java.util.HashMap;

public abstract class Page {

    private static WebDriver browser;
    public HashMap<String, Keyword> keywords = new HashMap<String, Keyword>();

    public static WebDriver browser(){
        if( browser == null)
            browser = Session.getInstance().openbrowser();
        return browser;
    }

    public HashMap<String, Keyword> getKeywords(){
        if(keywords.isEmpty())
            createKeywords();
        return keywords;
    }

    public Keyword getKeyword(String key){
        return keywords.get(key);
    }

    public void createKeywords(){
        for(Field f: this.getClass().getFields()){
            try{
                Object obj = f.get(this);
                if(obj instanceof Keyword){
                    String name = f.getName();
                    keywords.put(name, (Keyword)obj);
                }
            } catch(Exception e){
                System.out.println("BAD");
            }
        }
    }
}
