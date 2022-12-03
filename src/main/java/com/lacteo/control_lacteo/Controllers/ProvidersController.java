package com.lacteo.control_lacteo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lacteo.control_lacteo.Entities.Municipio;
import com.lacteo.control_lacteo.Entities.Proveedor;
import com.lacteo.control_lacteo.Service.MunicipioService;
import com.lacteo.control_lacteo.Service.ProvidersService;

/**
 * ProvidersController
 */
@Controller
public class ProvidersController {
    private MunicipioService municipioService;

    @Autowired
    public void setMunicipioService(MunicipioService municipioService) {
        this.municipioService = municipioService;
    }
    private ProvidersService providersService;

    @Autowired
    public void setChoferService(ProvidersService providersService) {
        this.providersService = providersService;
    }

    @GetMapping("/proveedores")
    String GetProviders(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", username);
        model.addAttribute("proveedores", this.providersService.listAllProviders());
        System.out.println(this.providersService.listAllProviders());
        model.addAttribute("Proveedor", new Proveedor());
        return "proveedores";
    }

    /**
     * Delete proveedor by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("proveedor/eliminar/{id}")
    public String delete(@PathVariable Integer id) {
        providersService.deleteProveedor(id);
        return "redirect:/";
    }

    @RequestMapping(value = "newProvider", method = RequestMethod.POST)
    public String savedriver(Proveedor proveedor) {
        proveedor.setCantidadDeLeche(0);
        Proveedor p = providersService.saveProveedor(proveedor);
        String municipioNombre = p.getMunicipio();
        System.out.println(this.municipioService.findByNombre(municipioNombre));
        if(this.municipioService.findByNombre(municipioNombre) == null){
            Municipio municipio = new Municipio();
            municipio.setNombre((p.getMunicipio()));
            municipio.setCantidadDeLeche(0);
            municipioService.saveMunicipio(municipio);
        }

        return "redirect:/proveedores";
    }
}