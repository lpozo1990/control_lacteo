package com.lacteo.control_lacteo.Controllers;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Locale;

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
        DateFormatSymbols spanish_dfs = new DateFormatSymbols(Locale.forLanguageTag("es-ES"));
        String[] months = spanish_dfs.getMonths();
        int startIndex = 0, endIndex = 12;
        // get the slice of the array
        String[] sliceArray = slice(months, startIndex, endIndex);
        System.out.println(Arrays.toString(sliceArray));
        model.addAttribute("meses", sliceArray);
        model.addAttribute("years",  this.regService.getAllYears());
        System.out.println(this.regService.getAllRegForYear(2022));
        model.addAttribute("registros",  this.regService.getAllRegForYear(2022));
        model.addAttribute("Registro", new Registro());
        return "vales";
    }

    public static String[] slice(String[] array, int startIndex, int endIndex) {
        // Get the slice of the Array
        String[] slicedArray = Arrays.copyOfRange(array, startIndex, endIndex);
        // return the slice
        return slicedArray;
    }
}
