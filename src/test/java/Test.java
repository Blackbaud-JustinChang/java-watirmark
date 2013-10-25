package test.java;

import main.java.page.Keyword;

import java.util.HashMap;

public class Test {


    public static void main(String[] args) throws Exception {
        PageView a = new OtherView();
        HashMap<String, Keyword> keywords = a.getKeywords();
        System.out.println(keywords.toString());
    }



}


