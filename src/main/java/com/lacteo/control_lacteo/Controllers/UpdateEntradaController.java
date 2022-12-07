package com.lacteo.control_lacteo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lacteo.control_lacteo.Entities.Entrada;
import com.lacteo.control_lacteo.repositories.EntradaRepository;

@RestController
public class UpdateEntradaController {
    private EntradaRepository entRepo;

    @Autowired
    public void setEntradaRepository(EntradaRepository entRepo) {
        this.entRepo = entRepo;
    }

    @PostMapping("/updateEntrada")
    void updateEntrada(@RequestBody Entrada entrada) {
        System.out.println(entrada);
        this.entRepo.updateEntrada(entrada.getId(), entrada.getCantidadLeche(), entrada.getNombreDelChofer(), entrada.getFecha(), entrada.getRuta());
    }
}
