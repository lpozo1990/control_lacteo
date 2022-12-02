package com.lacteo.control_lacteo.Service;

import java.util.List;

import com.lacteo.control_lacteo.Entities.Chofer;

public interface ChoferService {
    
    Iterable<Chofer> listAllChofers();
    Object[] listAllChofersNames();

    Chofer getChoferById(Integer id);

    Chofer saveChofer(Chofer product);

    void deleteChofer(Integer id);

}

