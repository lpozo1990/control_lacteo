package com.lacteo.control_lacteo.Controllers;

import java.text.DateFormatSymbols;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ValesController {
    
    @GetMapping("/vales")
    String GetVales(Model model) {
        DateFormatSymbols spanish_dfs = new DateFormatSymbols(Locale.forLanguageTag("es-ES"));
        String[] months =  spanish_dfs.getMonths();
        model.addAttribute("meses", months);
        return "vales";
    }
}
