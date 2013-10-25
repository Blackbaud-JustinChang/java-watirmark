package test.java;

import main.java.page.Keyword;
import main.java.page.Page;

public class PageView extends Page {

    public Keyword submitbtn = new Keyword("submitbtn");
    public Keyword teamdivisions = new Keyword("teamdivisions");

    public PageView(){
        this.getKeywords();
    }



}
