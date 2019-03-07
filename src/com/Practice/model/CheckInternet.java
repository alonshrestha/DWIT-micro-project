package com.Practice.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class CheckInternet {
    public boolean yesInternet = false;

    public boolean internetStatus() {
        Process p = null;
        try {
            p = Runtime.getRuntime().exec("ping 192.168.4.1");
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



        /*try {
            String ipAddress = "192.168.4.1";
            InetAddress inet = InetAddress.getByName(ipAddress);
            System.out.println("Sending Ping Request to " + ipAddress);
            if (inet.isReachable(5000)) {
                yesInternet = true;
                System.out.println(ipAddress + " is reachable.");
            } else {
                yesInternet = false;
                System.out.println(ipAddress + " NOT reachable.");
            }
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }*/
        return yesInternet;
    }





        /* try {
            System.out.println(host);
            int port = 80;
            int timeOutInMilliSec = 5000;// 5 Seconds
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(host, port), timeOutInMilliSec);
            yesInternet = true;
            System.out.println(yesInternet);
        } catch (Exception ex) {
            System.out.println("No Connectivity");
        }
        System.out.println(yesInternet);
        return yesInternet;
    }*/


    boolean isURLOn = false;

    public boolean httpsStatus(){
        try{
            URL url = new URL("http://profile.deerwalk.edu.np/");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int code = connection.getResponseCode();
            System.out.println("Response code of the object is "+code);
            if (code==200)
            {
                isURLOn = true;
                System.out.println("OK");
            }else{
                System.out.println("Application Down");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("DOwn cha haii");
        }
        return isURLOn;
    }

    public static void main(String[] args) {

        CheckInternet obj = new CheckInternet();
        obj.httpsStatus();
        obj.internetStatus();
    }


}
//----------------------------------------------------------------------------------------------
//    public boolean runSystemCommand() {
//        boolean isStatusActive = false;
//        String command = "8.8.8.8";
//        try {
//            Process p = Runtime.getRuntime().exec(command);
//            BufferedReader inputStream = new BufferedReader(
//                    new InputStreamReader(p.getInputStream()));
//
//            // reading output stream of the command
//            if ((inputStream.readLine()) != null) {
//            System.out.println(s);
//                isStatusActive = true;
//                System.out.println(isStatusActive);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return isStatusActive;
//    }

//}

