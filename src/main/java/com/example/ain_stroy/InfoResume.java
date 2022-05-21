package com.example.ain_stroy;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class InfoResume {

    @FXML
    private Button AllowButton;

    @FXML
    private Label Info;

    @FXML
    private Label Lastname;

    @FXML
    private Label Name;

    @FXML
    private Label Number;

    @FXML
    private Label Position;

    public static String Username;
    public static String Userlastname;
    public static String Usernumber;
    public static String position;
    public static String info;
    public static String email;

    @FXML
    void initialize() {
        try {
            ResumeSelect();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Name.setText(Username);
        Lastname.setText(Userlastname);
        Number.setText(Usernumber);
        Position.setText(position);
        Info.setText(info);

        AllowButton.setOnAction(actionEvent -> {
            try {
                SendEmail();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        });

    }

    public void ResumeSelect() throws SQLException, ClassNotFoundException {
        DatebaseHandler dbHandler = new DatebaseHandler();
        ResultSet result = dbHandler.ResumeView(Username);
        while (result.next()) {

            Userlastname = result.getString("lastname");
            Usernumber = result.getString("number");
            position = result.getString("position");
            info = result.getString("info");
            email = result.getString("number");
        }
    }
    public void SendEmail() throws MessagingException {
//        String text = "Hello dear " + Username + " " + Userlastname + " AIN Stroy invites you to interview for the position of  " + position + ". Please come by the office tomorrow at 2:00. We will be waiting for you at Maldybaeva 34B.  " ;
//
//        String from = "toktorbaev1311@gmail.com";
//
//        String pass = "aa13112016";
//        String RECIPT = email;
//        String TOPIC = "Welcome " + Username + "!";
//        String[] to = {RECIPT};
//        Properties props = System.getProperties();
//        String host = "smtp.gmail.com";
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", host);
//        props.put("mail.smtp.user", from);
//        props.put("mail.smtp.password", pass);
//        props.put("mail.smtp.port", "587");
//        props.put("mail.smtp.auth", "true");
//        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(
//                        "****", pass);
//            }
//        });
//        MimeMessage message = new MimeMessage(session);
//
//
//        try {
//            try {
//                message.setFrom(new InternetAddress(from));
//            } catch (MessagingException e) {
//                e.printStackTrace();
//            }
//            InternetAddress[] toAddress = new InternetAddress[to.length];
//            // To get the array of addresses
//            for (int i = 0; i < to.length; i++) {
//                try {
//                    toAddress[i] = new InternetAddress(to[i]);
//                } catch (AddressException e) {
//                    e.printStackTrace();
//                }
//            }
//            for (int i = 0; i < toAddress.length; i++) {
//                try {
//                    message.addRecipient(Message.RecipientType.TO, toAddress[i]);
//                } catch (MessagingException e) {
//                    e.printStackTrace();
//                }
//            }
//            try {
//                message.setSubject(TOPIC);
//            } catch (MessagingException e) {
//                e.printStackTrace();
//            }
//            try {
//                message.setText(text);
//            } catch (MessagingException e) {
//                e.printStackTrace();
//            }
//            try {
//                message.saveChanges();
//            } catch (MessagingException e) {
//                e.printStackTrace();
//            }
//
//            Transport transport = session.getTransport("smtp");
//            System.out.println("get protocl");
//            transport.connect(host, from, pass);
//            System.out.println("get host,from and password");
//            transport.sendMessage(message, message.getAllRecipients());
//            System.out.println("get recipients");
//            transport.close();
//            System.out.println("close");
//            System.out.println("Email Sent Successfully!");
//        } finally {
//            System.out.println("Complete Process");
//        }
//
//    }
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SuccessfullyDialog.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    }


