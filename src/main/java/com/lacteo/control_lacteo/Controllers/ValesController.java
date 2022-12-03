package com.lacteo.control_lacteo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.lacteo.control_lacteo.Entities.Registro;
import com.lacteo.control_lacteo.Service.NewRegistryService;

//function to get slice of a primitive array in Java   

@Controller
public class ValesController {

    private NewRegistryService regService;

    @Autowired
    public void setChoferService(NewRegistryService regService) {
        this.regService = regService;
    }

    @GetMapping("/vales")
    String GetVales(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", username);
        Integer defaultyear = this.regService.getAllYears().size() > 0 ? this.regService.getAllYears().get(0) : 2022;
        model.addAttribute("years",  this.regService.getAllYears());
        System.out.println(this.regService.getAllRegForYear(defaultyear));
        model.addAttribute("registros",  this.regService.getAllRegForYear(defaultyear));
        model.addAttribute("Registro", new Registro());
        return "vales";
    }


}
