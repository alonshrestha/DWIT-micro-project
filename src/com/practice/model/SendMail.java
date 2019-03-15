package com.practice.model;

import java.io.IOException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;


public class SendMail {
    private static final String user = "alon.stha01@gmail.com";
    private static final String pass = "gunda012345";
//    private static final String to = "alon.shrestha@deerwalk.edu.np";
    private static final String to= "alon.shrestha@deerwalk.edu.np";

    public static void send(String name, String batch, String cc, String sub,
                            String msg)     {
        //create an instance of Properties Class
        Properties props = new Properties();
     /* Specifies the IP address of your default mail server
     	   for e.g if you are using gmail server as an email sever
           you will pass smtp.gmail.com as value of mail.smtp host.
           As shown here in the code.
           Change accordingly, if your email id is not a gmail id
        */
        props.put("mail.smtp.host", "smtp.gmail.com");
        //below mentioned mail.smtp.port is optional
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
     /* Pass Properties object(props) and Authenticator object
           for authentication to Session instance
        */
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });
        try {
 	/* Create an instance of MimeMessage,
 	      it accept MIME types and headers
 	   */
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
            message.setSubject(sub);
            message.setText("By : " + name + " From Batch Of : " + batch + "\n" + "Problem : " + msg);
            /* Transport class is used to deliver the message to the recipients */
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void sendAlertUrl(String urlSubject, int urlMessage){
        //create an instance of Properties Class
        Properties props = new Properties();
     /* Specifies the IP address of your default mail server
     	   for e.g if you are using gmail server as an email sever
           you will pass smtp.gmail.com as value of mail.smtp host.
           As shown here in the code.
           Change accordingly, if your email id is not a gmail id
        */
        props.put("mail.smtp.host", "smtp.gmail.com");
        //below mentioned mail.smtp.port is optional
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
     /* Pass Properties object(props) and Authenticator object
           for authentication to Session instance
        */
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });
        try {
 	/* Create an instance of MimeMessage,
 	      it accept MIME types and headers
 	   */
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(user));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//            mimeMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(CC));
            mimeMessage.setSubject("Alert " + urlSubject + " Site Down!!");
            mimeMessage.setText(urlMessage + " error!!");
            /* Transport class is used to deliver the message to the recipients */
            Transport.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendAlertIP(String ipStubject){

        Properties props = new Properties();
     /* Specifies the IP address of your default mail server
     	   for e.g if you are using gmail server as an email sever
           you will pass smtp.gmail.com as value of mail.smtp host.
           As shown here in the code.
           Change accordingly, if your email id is not a gmail id
        */
        props.put("mail.smtp.host", "smtp.gmail.com");
        //below mentioned mail.smtp.port is optional
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
     /* Pass Properties object(props) and Authenticator object
           for authentication to Session instance
        */
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });
        try {
 	/* Create an instance of MimeMessage,
 	      it accept MIME types and headers
 	   */
            MimeMessage ipMimeMessage = new MimeMessage(session);
            ipMimeMessage.setFrom(new InternetAddress(user));
            ipMimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//            mimeMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(CC));
            ipMimeMessage.setSubject("Alert " + ipStubject + " Server Down!!");
            ipMimeMessage.setText( " error!!");
            /* Transport class is used to deliver the message to the recipients */
            Transport.send(ipMimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



}