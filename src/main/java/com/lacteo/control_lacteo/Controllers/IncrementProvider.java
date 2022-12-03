package com.lacteo.control_lacteo.Controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lacteo.control_lacteo.Service.ProvidersService;



@RestController
public class IncrementProvider {

    private ProvidersService providersService;

    @Autowired
    public void setChoferService(ProvidersService providersService) {
        this.providersService = providersService;
    }
    @PostMapping("/incrementInProvider")
    void incrementProvider(@RequestBody Map<String, String> json){
    System.out.println(json);
    String codigo = json.get("codigo");
    Integer cantidadDeLeche = Integer.parseInt(json.get("cantidadDeLeche"));
     this.providersService.incrementIfCodeIs(codigo, cantidadDeLeche);   
    }

    @PostMapping("/incrementInMunicipio")
    void incrementInMunicipio(@RequestBody Map<String, String> json){
    System.out.println(json);
    String codigo = json.get("codigo");
    Integer cantidadDeLeche = Integer.parseInt(json.get("cantidadDeLeche"));
     this.providersService.incrementLecheInmunicipio(codigo, cantidadDeLeche);   
    }
}
