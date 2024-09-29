package com.sise.restaurant_api.payload.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SucursalRequest {
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String direccion;
    
    @URL
    private String imagenUrl;
    
    @Size(min = 9, max=11)
    @Pattern(regexp = "[0-9]*",message = "debe ser numérico")
    private String telefono;
    
    @Email
    private String correo;
    
    @Size(min = 3)
    private String diasAtencion;
    
    @Size(min = 3)
    private String horarioAtencion;
    
    @NotBlank
    @Size(min = 3)
    @Pattern(regexp = "^-?\\d+(\\.\\d+)?$", message = "debe ser una coordenada")
    private String latitud;
    
    @NotBlank
    @Size(min = 3)
    @Pattern(regexp = "^-?\\d+(\\.\\d+)?$", message = "debe ser una coordenada")
    private String longitud;

}