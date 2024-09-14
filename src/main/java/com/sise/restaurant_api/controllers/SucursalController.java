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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




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


    @GetMapping("/{idSucursal}")
    public ResponseEntity<Sucursal> obtenerSucursal(@PathVariable Integer idSucursal) {
        try {
            Sucursal sucursal = sucursalService.obtenerSucursal(idSucursal);
            return new ResponseEntity<>(sucursal, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Sucursal> insertarSucursal(@RequestBody Sucursal sucursalInsert) {
        try {
            Sucursal sucursal = sucursalService.insertarSucursal(sucursalInsert);
            return new ResponseEntity<>(sucursal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{idSucursal}")
    public ResponseEntity<Sucursal> actualizarSucursal(@PathVariable Integer idSucursal, @RequestBody Sucursal sucursalUpdate) {
        try {
            sucursalUpdate.setIdSucursal(idSucursal);
            Sucursal sucursal = sucursalService.actualizarSucursal(sucursalUpdate);
            return new ResponseEntity<>(sucursal, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    

}