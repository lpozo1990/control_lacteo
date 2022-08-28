package com.lacteo.control_lacteo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacteo.control_lacteo.Entities.Municipio;
import com.lacteo.control_lacteo.repositories.MunicipioRepository;

@Service
public class MunicipioServiceImpl implements MunicipioService {
    private MunicipioRepository municipioRepository;

    @Autowired
    public void setMunicipioRepository(MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
    }

    @Override
    public Iterable<Municipio> listAllMunicipios() {
        return this.municipioRepository.findAll();
    }

    @Override
    public Municipio getMunicipioById(Integer id) {
        return this.municipioRepository.findById(id).get();
    }

    @Override
    public Municipio saveMunicipio(Municipio municipio) {
        return this.municipioRepository.save(municipio);
    }

    @Override
    public void deleteMunicipio(Integer id) {
        this.municipioRepository.deleteById(id);
    }

}



