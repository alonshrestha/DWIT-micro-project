package com.practice.model;

public class Host {

    int id;
    String appName;
    String ipAddr;
    String url;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id =id ;
    }

    public String getAppName(){
        return appName;
    }
    public void setAppName(String appName){
        this.appName = appName;
    }

    public String getIpAddr(){
        return ipAddr;
    }
    public void setIpAddr(String ipAddr){
        this.ipAddr = ipAddr;
    }

    public String getUrl(){
        return url;
    }
    public void setUrl(String url){
        this.url = url;
    }



}
