package com.coderplus.materialdrawerdemo.model;

/**
 * Created by xiejianchao on 15/10/15.
 */
public class JobModel {

    private String jobTitle;
    private String companyLogoUrl;
    private int companyLogoResId;
    private String company;
    private String publishDate;
    private String jobIntroduction;
    private int salary;

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyLogoUrl() {
        return companyLogoUrl;
    }

    public void setCompanyLogoUrl(String companyLogoUrl) {
        this.companyLogoUrl = companyLogoUrl;
    }

    public int getCompanyLogoResId() {
        return companyLogoResId;
    }

    public void setCompanyLogoResId(int companyLogoResId) {
        this.companyLogoResId = companyLogoResId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getJobIntroduction() {
        return jobIntroduction;
    }

    public void setJobIntroduction(String jobIntroduction) {
        this.jobIntroduction = jobIntroduction;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
