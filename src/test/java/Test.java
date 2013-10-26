//package test
import javawatirmark.page.*;

import java.io.File;
import java.util.HashMap;

public class Test {


    public static void main(String[] args) throws Exception {
        PageView view = new OtherView();

        HashMap<String, Keyword> keywords = view.getKeywords();
        System.out.println(keywords.toString());
        File file = new File("src/test/resources/page_test.html");
        Page.browser().get(file.getAbsolutePath());
        view.firstname.set("Hello");
        view.companySelect.set("Regional");
        view.includeEmail.set("true");
        view.includeEmail.set("True");
        view.includeEmail.set("false");
        view.includeEmail.set("False");
        view.includeEmail.set("nonBoolean");
        view.includeEmail.set("true");

    }



}


