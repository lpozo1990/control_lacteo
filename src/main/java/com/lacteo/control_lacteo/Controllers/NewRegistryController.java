package com.lacteo.control_lacteo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lacteo.control_lacteo.Entities.Registro;
import com.lacteo.control_lacteo.Service.NewRegistryService;

@RestController
public class NewRegistryController {
    private NewRegistryService regService;

    @Autowired
    public void setChoferService(NewRegistryService regService) {
        this.regService = regService;
    }
    @PostMapping("newRegistry")
    Registro createRegistry(@RequestBody Registro registro) {
        Registro res =  this.regService.saveRegistro(registro);
        return res;    
    }
}
