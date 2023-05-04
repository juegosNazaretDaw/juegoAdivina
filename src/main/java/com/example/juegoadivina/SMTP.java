package com.example.juegoadivina;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class SMTP {
    public static void main(String[] args) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable","true");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("nz01@nazaretzentroa.com", "nznznznz"); //no cambiar el email
                    }
                });





        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("nz01@nazaretzentroa.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("destinatario"));
        message.setSubject("Este email se ha enviado con Java");
        message.setText("Hola");
        Transport.send(message);



    }
}