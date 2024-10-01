package com.sise.restaurant_api.services.impl;

import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.itextpdf.html2pdf.HtmlConverter;
import com.sise.restaurant_api.payload.requests.ReporteMaestroRequest;
import com.sise.restaurant_api.services.IReporteService;

@Service
public class ReporteServiceImpl implements IReporteService{

    @Override
    public byte[] reporteMaestro(ReporteMaestroRequest reporteMaestroRequest) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HtmlConverter.convertToPdf(
            "<!DOCTYPE html><html><body><h1>Mi primer reporte con html</h1></body></html>", 
            byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
    
}
