package com.sise.restaurant_api.payload.requests;

import lombok.Data;

@Data
public class ReporteCabeceraRequest {
    private String campo;
    private String contenido;
}
