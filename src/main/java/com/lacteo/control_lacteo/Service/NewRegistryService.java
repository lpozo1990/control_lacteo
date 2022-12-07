package com.lacteo.control_lacteo.Service;

import java.util.List;

import com.lacteo.control_lacteo.Entities.Registro;

public interface NewRegistryService {
    void saveRegistro(Registro registro);
    Iterable<Registro> getAllRegForYear(Integer year);
    List<Integer> getAllYears();
    void incrementInRegistry(String mes, Integer year, Integer cantidadDeLeche);
    void decrementInRegistry(String mes, Integer year, Integer cantidadDeLeche);
}
