package com.lacteo.control_lacteo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lacteo.control_lacteo.Entities.Vale;
@Repository
public interface ValeRepository extends JpaRepository<Vale, Integer> {
    
@Query(value="SELECT numero_de_vale, codigo_proveedor, cantidad_de_leche  FROM vales LEFT JOIN entradas ON vales.entrada_id = entradas.id WHERE entrada_id=?1", nativeQuery = true)
List<Object> getValesForId(Integer id);

@Query(value="SELECT id FROM vales", nativeQuery = true)
List<Integer> getValesIds();

@Modifying
@Transactional
@Query(value="UPDATE vales SET cantidad_de_leche=?1, numero_de_vale=?2 , codigo_proveedor=?3  WHERE id = ?4", nativeQuery= true)
void updateOne(Integer cantidad_de_leche, String numero_de_vale ,String codigo_proveedor, Integer id );
}
