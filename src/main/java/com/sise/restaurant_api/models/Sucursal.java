package com.sise.restaurant_api.models;

public class Sucursal {
    private Integer idSucursal;
    private String nombre;

    public Sucursal(Integer idSucursal, String nombre){
        this.idSucursal=idSucursal;
        this.nombre=nombre;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
}
