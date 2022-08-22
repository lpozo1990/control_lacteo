package com.lacteo.control_lacteo.Controllers;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
     model.addAttribute("choferes", this.choferService.listAllChofers());
     System.out.println("im here");
     return "index";   
    }

    String newDriver(){
     return "";   
    }
}
