package javawatirmark;

import javawatirmark.controller.*;
import javawatirmark.model.Model;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Justin
 * Date: 10/27/13
 * Time: 11:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class PageController extends Controller {
    public static PageView view = new PageView();

    public PageController(){
        setView(view);
    }
}
