package com.lacteo.control_lacteo.Controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.lacteo.control_lacteo.Entities.Chofer;
import com.lacteo.control_lacteo.Service.ChoferService;

@Controller
public class DriversController {
    private ChoferService choferService;

    @Autowired
    public void setChoferService(ChoferService choferService) {
        this.choferService = choferService;
    }
    @RequestMapping("/")
    String listAll(Model model){
     String username = SecurityContextHolder.getContext().getAuthentication().getName();
     model.addAttribute("username", username);
     model.addAttribute("Chofer", new Chofer());
     model.addAttribute("choferes", this.choferService.listAllChofers());
     return "index";   
    }

    /**
     * Delete chofer by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("chofer/eliminar/{id}")
    public String delete(@PathVariable Integer id) {
        choferService.deleteChofer(id);
        return "redirect:/";
    }
    
    @RequestMapping(value = "newChofer", method = RequestMethod.POST)
    public String savedriver(Chofer driver) {
        choferService.saveChofer(driver);
        return "redirect:/";
    }
}
