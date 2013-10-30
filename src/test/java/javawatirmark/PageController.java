package javawatirmark;

import javawatirmark.controller.Controller;

import java.util.HashMap;


public class PageController extends Controller {

    public PageController(HashMap model) {
        view = new PageView();
        this.model = model;
    }


}
