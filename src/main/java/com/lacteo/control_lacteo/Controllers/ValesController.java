package com.lacteo.control_lacteo.Controllers;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
        model.addAttribute("years",  this.regService.getAllYears());
        System.out.println(this.regService.getAllRegForYear(2022));
        model.addAttribute("registros",  this.regService.getAllRegForYear(2022));
        model.addAttribute("Registro", new Registro());
        return "vales";
    }

    @GetMapping("/filterByYear/{year}")
    String getFromCurrentYear(@PathVariable Integer year, Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", username);
        model.addAttribute("years",  this.regService.getAllYears());
        model.addAttribute("selectedYear",  year);
        model.addAttribute("registros",  this.regService.getAllRegForYear(year));
        model.addAttribute("Registro", new Registro());
        return "vales";
    }

}
