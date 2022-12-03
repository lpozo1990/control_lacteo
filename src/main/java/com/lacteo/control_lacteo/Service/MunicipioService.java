package com.lacteo.control_lacteo.Service;

import com.lacteo.control_lacteo.Entities.Municipio;

public interface MunicipioService {
        
    Iterable<Municipio> listAllMunicipios();

   Municipio getMunicipioById(Integer id);
   
   Municipio findByNombre(String nombre);

   Municipio saveMunicipio(Municipio municipio);

    void deleteMunicipio(Integer id);
}


