package com.sise.restaurant_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sise.restaurant_api.entities.Sucursal;
import com.sise.restaurant_api.services.ISucursalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {

    @Autowired
    private ISucursalService sucursalService;
    
    @GetMapping("")
    public ResponseEntity<List<Sucursal>> listarSucursales() {
        try {
            List<Sucursal> sucursales = sucursalService.listarSucursales();
            return new ResponseEntity<>(sucursales, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}