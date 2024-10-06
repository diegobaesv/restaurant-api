package com.sise.restaurant_api.payload.requests;

import lombok.Data;

@Data
public class EmailRequest {
    private String[] emailTo;
    private String[] emailCC;
    private String[] emailBCC;
}
