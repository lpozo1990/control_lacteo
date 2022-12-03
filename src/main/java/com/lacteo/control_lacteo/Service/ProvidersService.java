package com.lacteo.control_lacteo.Service;

import com.lacteo.control_lacteo.Entities.Proveedor;

public interface  ProvidersService {

    Iterable<Proveedor> getByCat(Integer cantidad);
    
    Iterable<Integer> getCodes();
    

    Iterable<Proveedor> listAllProviders();

    Proveedor getProveedorById(Integer id);

    Proveedor saveProveedor(Proveedor product);

    void deleteProveedor(Integer id);

    void incrementIfCodeIs(String codigo, Integer cantidadDeLeche);

    void incrementInMunicipio(String municipio, Integer cantidadDeLeche);


}

