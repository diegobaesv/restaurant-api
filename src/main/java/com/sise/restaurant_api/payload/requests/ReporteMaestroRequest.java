package com.sise.restaurant_api.payload.requests;

import java.util.List;

import lombok.Data;

@Data
public class ReporteMaestroRequest {
    private List<Cabecera> cabeceras;
    private Tabla tabla;
}

@Data
class Cabecera {
    private String campo;
    private String contenido;
}

@Data
class Tabla {
    private List<String> cabeceras;
    private List<List<String>> data;
}
