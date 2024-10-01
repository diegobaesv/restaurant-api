package com.sise.restaurant_api.services;

import com.sise.restaurant_api.payload.requests.ReporteMaestroRequest;

public interface IReporteService {
    public byte[] reporteMaestro(ReporteMaestroRequest reporteMaestroRequest);
}
