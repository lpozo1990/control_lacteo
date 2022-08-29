package com.lacteo.control_lacteo.repositories;
import org.springframework.data.jpa.repository.*;

import com.lacteo.control_lacteo.Entities.Proveedor;

public interface ProviderRepository extends JpaRepository<Proveedor, Integer> {
    Iterable<Proveedor> findAllByCantidadDeLeche(Integer cantidad);

}