package javawatirmark;

import javawatirmark.controller.Controller;
import javawatirmark.model.Model;
import javawatirmark.page.Page;

import java.io.File;
import java.util.HashMap;


public class PageController extends Controller {

    public PageController(Model model) {
        view = new PageView();
        this.model = model;
    }

    public void populateNewPage(){
        File file = new File("src/test/resources/test.html");
        Page.browser().get("file://"+file.getAbsolutePath());
    }


}
