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
            } else {
                System.out.println("Application Down");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DOwn cha haii");
        }
        return isURLOn;
    }



    public boolean httpStatusList(List<Host> httpUrlList) {
        boolean isURLOnList = false;

        for ( Host urlList : httpUrlList) {

            try {
                URL url = new URL(urlList.getUrl());
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                int code = connection.getResponseCode();
                System.out.println("Response code of the object is " + code);
                if (code == 200) {
                    isURLOnList = true;
                    System.out.println("OK");
                } else {
                    System.out.println(urlList.getUrl());
                    System.out.println("Application Down");

                }

            }catch (Exception e){
                e.printStackTrace();
                System.out.println("exception aayo !!!");
                isURLOnList = false;
            }

        }
        return isURLOnList;
    }

    public static void main(String[] args) {

    }


}



