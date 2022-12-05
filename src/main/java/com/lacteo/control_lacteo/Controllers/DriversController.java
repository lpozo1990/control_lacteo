package com.lacteo.control_lacteo.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lacteo.control_lacteo.Entities.Chofer;
import com.lacteo.control_lacteo.Service.ChoferService;
import com.lacteo.control_lacteo.repositories.ChoferRepository;

@Controller
public class DriversController {
    private ChoferService choferService;

    @Autowired
    public void setChoferService(ChoferService choferService) {
        this.choferService = choferService;
    }

    private ChoferRepository choferRepo;

    @Autowired
    public void setChoferRepository(ChoferRepository choferRepo) {
        this.choferRepo = choferRepo;
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

    @RequestMapping(value = "actualizarChofer/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String savedriver(@PathVariable Integer id, @RequestBody MultiValueMap<String, String> formData) {
        choferRepo.updateChofer(id, formData.getFirst("nombre"), formData.getFirst("apellidos"));
        return "redirect:/";
    }
}
