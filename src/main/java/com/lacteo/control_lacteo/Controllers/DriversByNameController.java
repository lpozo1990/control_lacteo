package com.lacteo.control_lacteo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lacteo.control_lacteo.Service.ChoferService;

@RestController
public class DriversByNameController {
    private ChoferService choferService;

    @Autowired
    public void setChoferService(ChoferService choferService) {
        this.choferService = choferService;
    }
    
    @GetMapping("/driversByName")
    Object[] listAllByName(){
     return this.choferService.listAllChofersNames();   
    }
}
