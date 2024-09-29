package com.sise.restaurant_api.payload.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SucursalRequest {
    @NotBlank(message = "El campo no debe ser nulo ni vacio.")
    private String nombre;
    @NotBlank(message = "El campo no debe ser nulo ni vacio.")
    private String direccion;
    private String imagenUrl;
    private String telefono;
    @Email
    private String correo;
    private String diasAtencion;
    private String horarioAtencion;
    @NotBlank(message = "El campo no debe ser nulo ni vacio.")
    private String latitud;
    @NotBlank(message = "El campo no debe ser nulo ni vacio.")
    private String longitud;

}