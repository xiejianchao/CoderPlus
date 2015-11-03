package com.coderplus.materialdrawerdemo.model;

/**
 * Created by xiejianchao on 15/10/15.
 */
public class CoderModel {

    /**
     * coder name
     */
    private String name;
    /**
     * coder cover resource id
     */
    private int coverResId;

    /**
     * coder cover url

     */
    private String coverUrl;
    /**
     * Android or iOS or Web developer
     */
    private String jobType;

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public int getCoverResId() {
        return coverResId;
    }

    public void setCoverResId(int coverResId) {
        this.coverResId = coverResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }
}
