package com.sise.restaurant_api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.restaurant_api.entities.Sucursal;
import com.sise.restaurant_api.repositories.ISucursalRepository;
import com.sise.restaurant_api.services.ISucursalService;

@Service
public class SucursalServiceImpl implements ISucursalService {

    @Autowired
    private ISucursalRepository sucursalRepository;

    @Override
    public List<Sucursal> listarSucursales() throws Exception {
        return sucursalRepository.findAll();
    }

    @Override
    public Sucursal obtenerSucursal(Integer idSucursal) throws Exception {
        return sucursalRepository.findById(idSucursal).orElse(null);
    }

    @Override
    public Sucursal insertarSucursal(Sucursal sucursal) throws Exception {
        return sucursalRepository.save(sucursal);
    }

    @Override
    public Sucursal actualizarSucursal(Sucursal sucursal) throws Exception {
        return sucursalRepository.save(sucursal);
    }

    @Override
    public void darBajaSucursal(Integer idSucursal) throws Exception {
        sucursalRepository.darBajaSucursal(idSucursal);
    }
    
}
