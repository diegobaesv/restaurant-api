package com.sise.restaurant_api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sise.restaurant_api.payload.requests.EmailRequest;
import com.sise.restaurant_api.services.IEmailService;
import com.sise.restaurant_api.shared.EmailSender;

@Service
public class EmailServiceImpl implements IEmailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public void sendWelcome(EmailRequest emailRequest) throws Exception {
        new EmailSender(javaMailSender)
        .sendEmail(
            emailRequest, 
            "TENGO HAMBRE'S - GRACIAS POR REGISTRARTE", 
            buildHtmlTemplate("<p>Hola este es mi correo</p>")
            );
    }

    @Override
    public void sendNotice(EmailRequest emailRequest) throws Exception {
        new EmailSender(javaMailSender)
        .sendEmail(
            emailRequest, 
            "TENGO HAMBRE'S - OFERTAS DEL MES", 
            buildHtmlTemplate("<p>Hola este es mi correo</p>")
            );
    }

    private String buildHtmlTemplate(String body){
        return new StringBuilder()
                .append("<!DOCTYPE PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>")
                .append("<html xmlns=\"http://www.w3.org/1999/xhtml\">")
                .append("<head>")
                    .append("<meta charset=\"UTF-8\">")
                    .append("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0\">")
                    .append("<title></title>")
                .append("</head>")
                .append("<body>")
                    .append(body)
                .append("</body>")
                .append("</html>")
                .toString();
    }





    
}
