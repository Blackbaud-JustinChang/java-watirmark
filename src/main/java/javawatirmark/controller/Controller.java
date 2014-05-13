package javawatirmark.controller;

import javawatirmark.model.Model;
import javawatirmark.page.Keyword;
import javawatirmark.page.Page;
import javawatirmark.page.Permission;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;

public abstract class Controller {

    protected Page view;
    protected Model model;

    public void run() {

    }

    public Page getView() {
        return view;
    }

    public void create() {
        view.create(model);
        populateData();
    }

    public void verify() {
        view.verify(model);
        verifyData();
    }

    public void populateData() {
        if (populateValues()){
            //Submit Process Page
        }
    }

    public boolean populateValues() {
        boolean seen = false;
        for(Field field : view.getClass().getFields())
        {
            String key = field.getName();
            if (model.getValue(key) != null) {
                if (populateAllowed(key))
                {
                    beforeKeyword(key);
                    populateKeyword(key);
                    afterKeyword(key);
                    seen = true;
                }

            }
        }
        return seen;
    }

    public void verifyData()
    {
        for(Field field : view.getClass().getFields())
        {
            String key = field.getName();
            if (model.getValue(key) != null)
            {
                if (verifyAllowed(key))
                {
                    Keyword keyword = keywords().get(key);
                    keyword.verify((String) model.getValue(key));
                }
            }
        }
    }

    private boolean populateAllowed(String key)
    {
        return ( keywords().get(key).permission == Permission.POPULATE );
    }

    private boolean verifyAllowed(String key)
    {

        return ( keywords().get(key).permission == Permission.POPULATE || keywords().get(key).permission == Permission.VERIFY );
    }


    private void populateKeyword(String key) {
        Keyword keyword = keywords().get(key);
        if(callMethodIfExists("populate"+ camolizeKey(key))) {
        } else {
            if (model.getValue(key) instanceof String)
            {
                keyword.set((String) model.getValue(key));
            }
        }
    }

    private void beforeKeyword(String key) {
        callMethodIfExists("before"+ camolizeKey(key));
    }

    private void afterKeyword(String key){

        callMethodIfExists("after"+ camolizeKey(key));
    }

    private boolean callMethodIfExists(String method){
        boolean exists = true;
        try {
            getClass().getMethod(method).invoke(this, null);
        } catch (NoSuchMethodException e){
//            System.out.println("The method '"+method+"'does not exist");
            exists = false;
        } catch (Exception e){
            System.out.println("Error: " + e.toString());
        }
        return exists;
    }

    private HashMap<String, Keyword> keywords()
    {
        return view.keywords;
    }

    private String camolizeKey(String key)
    {
        return key.substring(0,1).toUpperCase() + key.substring(1);
    }

}
