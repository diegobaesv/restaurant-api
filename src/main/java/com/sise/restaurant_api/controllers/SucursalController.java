package com.sise.restaurant_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sise.restaurant_api.services.ISucursalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {

    @Autowired
    private ISucursalService sucursalService;
    
    @GetMapping("")
    public String listarSucursales() {
        
        return new String();
    }
    

}
