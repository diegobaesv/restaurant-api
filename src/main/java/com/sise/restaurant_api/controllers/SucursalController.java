package com.sise.restaurant_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sise.restaurant_api.entities.Sucursal;
import com.sise.restaurant_api.payload.requests.SucursalRequest;
import com.sise.restaurant_api.services.ISucursalService;
import com.sise.restaurant_api.shared.BaseResponse;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController

@RequestMapping("/sucursales")
public class SucursalController {

    @Autowired
    private ISucursalService sucursalService;
    
    @GetMapping("")
    public ResponseEntity<BaseResponse> listarSucursales() {
        try {
            List<Sucursal> sucursales = sucursalService.listarSucursales();
            return new ResponseEntity<>(BaseResponse.success(sucursales), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(BaseResponse.error(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/{idSucursal}")
    public ResponseEntity<BaseResponse> obtenerSucursal(@PathVariable Integer idSucursal) {
        try {
            Sucursal sucursal = sucursalService.obtenerSucursal(idSucursal);
            if(sucursal == null) {
                return new ResponseEntity<>(BaseResponse.errorNotFound(),HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(BaseResponse.success(sucursal), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(BaseResponse.error(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<BaseResponse> insertarSucursal(@Valid @RequestBody SucursalRequest sucursalRequest) {
        try {
            /*if(errors.hasErrors()){
                return new ResponseEntity<BaseResponse>(BaseResponse.error("Ha ocurrido un error"),HttpStatus.BAD_REQUEST);
            }*/
            //Sucursal sucursal = sucursalService.insertarSucursal(sucursalRequest);
            return new ResponseEntity<>(BaseResponse.success("OK"), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(BaseResponse.error(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{idSucursal}")
    public ResponseEntity<BaseResponse> actualizarSucursal(@PathVariable Integer idSucursal, @RequestBody Sucursal sucursalUpdate) {
        try {
            if(sucursalService.obtenerSucursal(idSucursal) == null) {
                return new ResponseEntity<>(BaseResponse.errorNotFound(),HttpStatus.NOT_FOUND);
            }
            sucursalUpdate.setIdSucursal(idSucursal);
            Sucursal sucursal = sucursalService.actualizarSucursal(sucursalUpdate);
            return new ResponseEntity<>(BaseResponse.success(sucursal), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(BaseResponse.error(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/dar-baja/{idSucursal}")
    public ResponseEntity<BaseResponse> darBajaSucursal(@PathVariable Integer idSucursal){
        try {
            if(sucursalService.obtenerSucursal(idSucursal) == null) {
                return new ResponseEntity<>(BaseResponse.errorNotFound(),HttpStatus.NOT_FOUND);
            }
            sucursalService.darBajaSucursal(idSucursal);
            return new ResponseEntity<>(BaseResponse.success(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(BaseResponse.error(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}