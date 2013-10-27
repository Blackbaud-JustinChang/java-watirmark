package javawatirmark.controller;

import javawatirmark.page.*;
import javawatirmark.model.*;
public class Controller {

    public Page view;

    public Controller(){

    }

    public Controller(Model model){

    }

    public void populateData(){
    }

    public boolean populateValues(){
        return true;
    }

    public void verifyData(){
    }

    public Page getView(){
        return view;
    }

}
