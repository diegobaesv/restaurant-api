package com.sise.restaurant_api.services;

import com.sise.restaurant_api.entities.Sucursal;
import java.util.List;

public interface ISucursalService {
    List<Sucursal> listarSucursales() throws Exception;
    Sucursal obtenerSucursal(Integer idSucursal) throws Exception;
    Sucursal insertarSucursal(Sucursal sucursal) throws Exception;
    Sucursal actualizarSucursal(Sucursal sucursal) throws Exception;
    void darBajaSucursal(Integer idSucursal) throws Exception;
}