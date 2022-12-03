package com.lacteo.control_lacteo.repositories;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.lacteo.control_lacteo.Entities.Proveedor;

public interface ProviderRepository extends CrudRepository<Proveedor, Integer> {
    Iterable<Proveedor> findAllByCantidadDeLeche(Integer cantidad);
    
    @Modifying
    @Transactional
    @Query("update Municipio m  set m.cantidadDeLeche=m.cantidadDeLeche + :cantidad where m.nombre=:municipio")
    void incrementInMunicipio(@Param("municipio")String municipio, @Param("cantidad")Integer cantidad);

    @Query(value="SELECT codigo FROM proveedores", nativeQuery = true)
    Iterable<Integer> getAllCodes();

    @Modifying
    @Transactional
    @Query(value="UPDATE proveedores SET cantidad_de_leche = cantidad_de_leche + ?2 WHERE codigo = ?1 ;", nativeQuery = true)
    void incrementIfCodeIs(String codigo, Integer cantidadDeLeche);

}