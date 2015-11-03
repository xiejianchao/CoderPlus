package com.coderplus.materialdrawerdemo.model;

import java.util.ArrayList;

/**
 * Created by xiejianchao on 15/10/22.
 */
public class ResumeModel {

    private String title;
    private ArrayList<String> details;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<String> details) {
        this.details = details;
    }
}
