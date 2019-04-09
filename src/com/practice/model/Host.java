package com.practice.model;

public class Host {

    int id;
    int serverId;
    int appCount;
    int serverCount;
    String serverName;
    String serverAddr;
    String appName;
    String ipAddr;
    String url;


    public int getAppCount(){return appCount;}
    public void setAppCount(int appCount){this.appCount=appCount;}

    public int getServerCount(){return serverCount;}
    public void setServerCount(int serverCount){this.serverCount=serverCount;}

    public int getserverId(){return serverId;}
    public void setserverId(int sid){this.serverId=sid;}

    public String getServerName(){return  serverName;}
    public void setServerName(String serverName){this.serverName = serverName;}

    public String getServerAddr(){return serverAddr;}
    public void setServerAddr(String serverAddr){this.serverAddr = serverAddr;}

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
