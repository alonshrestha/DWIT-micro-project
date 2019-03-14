package com.practice.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.sql.SQLException;
import java.util.List;

public class CheckInternet {
    public boolean yesInternet = false;

    public boolean serverStatus(String ipAddress) {
        Process p = null;
        try {
            p = Runtime.getRuntime().exec("ping " + ipAddress);
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            // reading output stream of the command
            if ((inputStream.readLine()) != null) {
//                System.out.println(s);
                yesInternet = true;
                System.out.println(yesInternet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return yesInternet;
    }


    boolean isURLOn = false;

    public boolean httpStatus(String httpUrl) {
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int code = connection.getResponseCode();
            System.out.println("Response code of the object is " + code);
            if (code == 200) {
                isURLOn = true;
                System.out.println("OK");
            } else if (code == 404){
                System.out.println("404 Not Found");
            }else if (code == 500){
                System.out.println("500 Internal Server Error");
            }else {
                System.out.println("Alert The Site Is Down");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Alert The Site Is Down");
        }
        return isURLOn;
    }



    public boolean httpStatusList(List<Host> httpUrlList) {
        boolean isURLOnList = false;
        String appName=null;
        for ( Host urlList : httpUrlList) {
            SendMail callObj = new SendMail();
            try {
                URL url = new URL(urlList.getUrl());
                appName = urlList.getUrl();
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                connection.connect();

                int code = connection.getResponseCode();
                System.out.println("Response code of the object is " + code);

                switch (code) {
                    case 200:
                        isURLOnList = true;
                        System.out.println(appName + " OK");
                        break;
                    case 404:

                        callObj.sendAlert(appName);
                        isURLOnList = false;
                        System.out.println(appName + " 404 Not Found");
                        break;
                    case 500:
                        callObj.sendAlert(appName);
                        isURLOnList = false;
                        System.out.println(appName + " 500 Internal Server Error");
                        break;

                    default:
                        callObj.sendAlert(appName);
                        isURLOnList = false;
                        System.out.println(appName + " Alert The Site Is Down");
                }
            } catch (IOException e) {
                e.printStackTrace();
                isURLOnList = false;
                System.out.println("ex: "+appName);
                callObj.sendAlert(appName);

            }

        }
        return isURLOnList;
    }

    public static void main(String[] args) {
     CheckInternet obj = new CheckInternet();
     obj.httpStatus("http://profe.deerwalk.edu.np");


    }


}



