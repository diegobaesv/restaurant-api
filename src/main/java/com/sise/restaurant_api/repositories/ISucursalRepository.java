package com.sise.restaurant_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sise.restaurant_api.entities.Sucursal;

@Repository
public interface ISucursalRepository extends JpaRepository<Sucursal, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Sucursal s SET s.estadoAuditoria = '0' WHERE s.idSucursal =  :idSucursal")
    void darBajaSucursal(@Param("idSucursal") Integer idSucursal);

}
