package com.sise.restaurant_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sise.restaurant_api.models.Sucursal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/saludo")
public class SaludoController {
    
    @GetMapping("")    
    public String saludar(){
        return "Hola SISE - LENG AVANZADO!!";
    }

    @GetMapping("/alumno")
    public String saludarAlumno() {
        return "Hola Alumno de SISE!!";
    }

    @GetMapping("/alumno/{id}")
    public String saludarAlumnoUnico(
        @PathVariable Integer id, 
        @RequestParam(required = false) String query
        ) {
        return "Hola , estas saludando al alumno: "+id+ ", has ingresado el query: "+query;
    }

    @GetMapping("/sucursal/{idSucursal}")
    public ResponseEntity<Sucursal> obtenerSucursal(@PathVariable("idSucursal") String idSucursalStr){

        try {
            Sucursal sucursal = new Sucursal(Integer.parseInt(idSucursalStr), "Aqui va el nombre");
            return new ResponseEntity<Sucursal>(sucursal,HttpStatus.OK);
        } catch (Exception e) {
            Sucursal sucursal = new Sucursal(0, e.getMessage());
            return new ResponseEntity<Sucursal>(sucursal, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}



