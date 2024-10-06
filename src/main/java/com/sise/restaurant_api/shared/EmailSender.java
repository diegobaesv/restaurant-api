package com.sise.restaurant_api.shared;

import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.sise.restaurant_api.payload.requests.EmailRequest;

public class EmailSender {
    private JavaMailSender mailSender;

    public EmailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(EmailRequest emailRequest, String subject, String content) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("dbaes97ps5asia@gmail.com", "Diego Spring");
        helper.setTo(emailRequest.getEmailTo());
        if(emailRequest.getEmailCC() != null && emailRequest.getEmailCC().length > 0) {
            helper.setCc(emailRequest.getEmailCC());
        }
        if(emailRequest.getEmailBCC() != null && emailRequest.getEmailBCC().length > 0){
            helper.setBcc(emailRequest.getEmailBCC());
        }
        helper.setSubject(subject);
        helper.setText(content, true);

        mailSender.send(message);
    }

}
