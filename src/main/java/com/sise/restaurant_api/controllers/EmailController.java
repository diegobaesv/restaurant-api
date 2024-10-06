package com.sise.restaurant_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sise.restaurant_api.payload.requests.EmailRequest;
import com.sise.restaurant_api.shared.BaseResponse;
import com.sise.restaurant_api.shared.EmailSender;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/email")
public class EmailController {

    @PostMapping("/send-welcome")
    public ResponseEntity<BaseResponse> sendWelcome(@RequestBody EmailRequest emailRequest) {
        try {
            JavaMailSender javaMailSender = new JavaMailSenderImpl();
            EmailSender emailSender = new EmailSender(javaMailSender);
            emailSender.sendEmail(emailRequest, "ASUNTO DE PRUEBA", "<p>Hola este es mi correo</p>");
            return new ResponseEntity<>(BaseResponse.success(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(BaseResponse.error(e.toString()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
