package com.lacteo.control_lacteo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lacteo.control_lacteo.Service.ChoferService;
import com.lacteo.control_lacteo.Service.ProvidersService;

@RestController
public class DriversByNameController {
    private ChoferService choferService;
    private ProvidersService provService;

    @Autowired
    public void setChoferService(ChoferService choferService) {
        this.choferService = choferService;
    }
    @Autowired
    public void setProvService(ProvidersService provService) {
        this.provService = provService;
    }
    
    @GetMapping("/driversByName")
    Object[] listAllByName(){
     return this.choferService.listAllChofersNames();   
    }
    @GetMapping("/providersCodes")
    Iterable<Integer> listAllByCode(){
     return this.provService.getCodes();   
    }
}
