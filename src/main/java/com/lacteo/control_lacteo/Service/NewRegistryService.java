package com.lacteo.control_lacteo.Service;

import java.util.List;

import com.lacteo.control_lacteo.Entities.Registro;

public interface NewRegistryService {
    Registro saveRegistro(Registro registro);
    Iterable<Registro> getAllRegForYear(Integer year);
    List<Integer> getAllYears();
}
