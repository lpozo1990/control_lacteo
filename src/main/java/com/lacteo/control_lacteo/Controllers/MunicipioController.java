package com.lacteo.control_lacteo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lacteo.control_lacteo.Entities.Municipio;
import com.lacteo.control_lacteo.Service.MunicipioService;

@Controller
public class MunicipioController {
    private MunicipioService municipioService;

    @Autowired
    public void setMunicipioService(MunicipioService municipioService) {
        this.municipioService = municipioService;
    }

    @RequestMapping("/municipios")
    String getMunicipios(Model model){
     String username = SecurityContextHolder.getContext().getAuthentication().getName();
     model.addAttribute("username", username);
     model.addAttribute("Municipio", new Municipio());
     model.addAttribute("municipios", this.municipioService.listAllMunicipios());
     return "municipios";   
    }



}
