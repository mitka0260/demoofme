package com.portfolio.demoofme.email;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@RestController
public class SendEmail {

    /*
    https://snov.io/knowledgebase/ru/how-to-set-up-an-smtp-gmail-account-to-allow-full-google-authorization-ru/
     */

    @GetMapping("/sendEmail")
    public String sendMail(
            @RequestParam("name") String name,
            @RequestParam("message1") String message1
    ) throws MessagingException {

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("mitkaut", "vlhzmhvkiadypplm");
                    }
                });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("mitkaut@gmail.com"));
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse("mitkaut@gmail.com")
        );

        message.setSubject(name);
        message.setText(message1);
        Transport.send(message);

        return "Your message was sent";

    }
}
