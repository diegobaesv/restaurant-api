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
            "<p>Hola este es mi correo</p>"
            );
    }

    @Override
    public void sendNotice(EmailRequest emailRequest) throws Exception {
        new EmailSender(javaMailSender)
        .sendEmail(
            emailRequest, 
            "TENGO HAMBRE'S - OFERTAS DEL MES", 
            "<p>Hola este es mi correo</p>"
            );
    }


    
    
}
