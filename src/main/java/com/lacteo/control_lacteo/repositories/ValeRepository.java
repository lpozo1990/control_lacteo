package com.lacteo.control_lacteo.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.lacteo.control_lacteo.Entities.Vale;

public interface ValeRepository extends JpaRepository<Vale, Integer> {
    
@Query(value="SELECT numero_de_vale, codigo_proveedor, cantidad_de_leche  FROM vales LEFT JOIN entradas ON vales.entrada_id = entradas.id WHERE entrada_id=?1", nativeQuery = true)
List<Object> getValesForId(Integer id);
}
