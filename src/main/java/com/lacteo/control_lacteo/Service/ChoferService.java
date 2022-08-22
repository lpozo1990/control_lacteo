package com.lacteo.control_lacteo.Service;

import com.lacteo.control_lacteo.Entities.Chofer;

public interface ChoferService {
    
    Iterable<Chofer> listAllChofers();

    Chofer getChoferById(Integer id);

    Chofer saveChofer(Chofer product);

    void deleteChofer(Integer id);

}

