package javawatirmark.controller;

import javawatirmark.page.*;
import javawatirmark.model.*;

import java.util.HashMap;
import java.util.Iterator;

public abstract class Controller {

    protected Page view;
    protected HashMap model;

    public void create(){
        view.create(model);
        populateData(model);
    }

    public void populateData(HashMap model){
        HashMap<String, Keyword> keywords = view.getKeywords();
        Iterator<String> keys = keywords.keySet().iterator();

        while(keys.hasNext()){
            String key = keys.next();
            if (model.get(key) != null){
                Keyword keyword = keywords.get(key);
                keyword.set((String) model.get(key));
            }
        }
    }

    public Page getView(){
        return view;
    }

    public boolean populateValues(){
        return true;
    }

    public void verifyData(){
    }

    public void run(){

    }

}
