package javawatirmark.controller;

import javawatirmark.page.Keyword;
import javawatirmark.page.Page;

import java.util.HashMap;
import java.util.Iterator;

public abstract class Controller {

    protected Page view;
    protected HashMap model;

    public void create() {
        view.create(model);
        populateData();
    }

    public void verify() {
        view.verify(model);
        verifyData();
    }

    public void populateData() {
        HashMap<String, Keyword> keywords = view.getKeywords();
        Iterator<String> keys = keywords.keySet().iterator();

        while (keys.hasNext()) {
            String key = keys.next();
            if (model.get(key) != null) {
                Keyword keyword = keywords.get(key);
                keyword.set((String) model.get(key));
            }
        }
    }

    public Page getView() {
        return view;
    }

    public boolean populateValues() {
        return true;
    }

    public void verifyData() {
        HashMap<String, Keyword> keywords = view.getKeywords();
        Iterator<String> keys = keywords.keySet().iterator();

        while (keys.hasNext()) {
            String key = keys.next();
            if (model.get(key) != null) {
                Keyword keyword = keywords.get(key);
                keyword.verify((String) model.get(key));
            }
        }
    }

    public void run() {

    }

}
