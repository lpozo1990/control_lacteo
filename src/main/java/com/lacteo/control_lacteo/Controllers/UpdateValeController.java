package com.lacteo.control_lacteo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lacteo.control_lacteo.Entities.Vale;
import com.lacteo.control_lacteo.repositories.ValeRepository;

@RestController
public class UpdateValeController {

    private ValeRepository valeRepo;

    @Autowired
    public void setValeRepository(ValeRepository valeRepo) {
        this.valeRepo = valeRepo;
    }
    @PostMapping("/updateVale")
    void updateOne(@RequestBody Vale vale){
        System.out.println(vale);
        this.valeRepo.updateOne(vale.getCantidad_de_leche(), vale.getNumero_de_vale(), vale.getCodigoProveedor(), vale.getId());
    }
}
