package javawatirmark.controller;

import javawatirmark.page.*;
import javawatirmark.model.*;

public abstract class Controller {

    private Page view;

    public void setView(Page view){
        this.view = view;
    }

    public void populateData(){
    }

    public boolean populateValues(){
        return true;
    }

    public void verifyData(){
    }

    public void run(){

    }


}
