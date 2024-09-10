package com.sise.restaurant_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sise.restaurant_api.entities.Sucursal;

@Repository
public interface ISucursalRepository extends JpaRepository<Sucursal, Integer> {
    
}
