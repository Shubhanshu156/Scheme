package com.example.schema;

public class ChildItem {

    // Declaration of the variable
    private String ChildItemTitle;
    private int imageid;
    private String information;
    private String Application;

    // Constructor of the class
    // to initialize the variable*
    public ChildItem(String childItemTitle,int imageid,String information,String application)
    {
        this.ChildItemTitle = childItemTitle;
        this.imageid=imageid;
        this.information=information;
        this.Application=application;
    }


    // Getter and Setter method
    // for the parameter
    public String getChildItemTitle()
    {
        return ChildItemTitle;
    }
    public int getImageid(){
        return imageid;
    }

    public void setChildItemTitle(
            String childItemTitle)
    {
        ChildItemTitle = childItemTitle;
    }
    public void setImageid(int imageid){
        this.imageid=imageid;
    }

    public String getApplication() {
        return Application;
    }

    public String getInformation() {
        return information;
    }

    public void setApplication(String application) {
        Application = application;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
