package javawatirmark.controller;

import javawatirmark.model.Model;
import javawatirmark.page.Keyword;
import javawatirmark.page.Page;

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
                beforeKeyword(key);
                populateKeyword(key);
                afterKeyword(key);
                seen = true;
            }
        }
        return seen;
    }

    public void verifyData() {
        HashMap<String, Keyword> keywords = view.getKeywords();
        Iterator<String> keys = keywords.keySet().iterator();

        while (keys.hasNext()) {
            String key = keys.next();
            if (model.getValue(key) != null) {
                Keyword keyword = keywords.get(key);
                keyword.verify((String) model.getValue(key));
            }
        }
    }

    private void populateKeyword(String key) {
        Keyword keyword = view.getKeywords().get(key);
        String capKey = key.substring(0,1).toUpperCase() + key.substring(1);
        if(callMethodIfExists("populate"+ capKey)) {
        } else {
            if (model.getValue(key) instanceof String)
            {
                keyword.set((String) model.getValue(key));
            }
        }
    }

    private void beforeKeyword(String key) {
        String capKey = key.substring(0,1).toUpperCase() + key.substring(1);
        callMethodIfExists("before"+ capKey);
    }

    private void afterKeyword(String key){
        String capKey = key.substring(0,1).toUpperCase() + key.substring(1);
        callMethodIfExists("after"+ capKey);
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
}
