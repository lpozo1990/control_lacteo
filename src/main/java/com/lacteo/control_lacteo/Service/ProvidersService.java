package com.lacteo.control_lacteo.Service;

import com.lacteo.control_lacteo.Entities.Proveedor;

public interface  ProvidersService {

   
    Iterable<Proveedor> listAllProviders();

    Proveedor getProveedorById(Integer id);

    Proveedor saveProveedor(Proveedor product);

    void deleteProveedor(Integer id);


}

