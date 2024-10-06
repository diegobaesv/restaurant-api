package com.sise.restaurant_api.services;

import com.sise.restaurant_api.payload.requests.EmailRequest;

public interface IEmailService {
    void sendWelcome(EmailRequest emailRequest) throws Exception;
    void sendNotice(EmailRequest emailRequest) throws Exception;
}
