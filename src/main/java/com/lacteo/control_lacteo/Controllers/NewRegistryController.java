package com.lacteo.control_lacteo.Controllers;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lacteo.control_lacteo.Entities.Entrada;
import com.lacteo.control_lacteo.Entities.Registro;
import com.lacteo.control_lacteo.Entities.Vale;
import com.lacteo.control_lacteo.Service.NewRegistryService;
import com.lacteo.control_lacteo.repositories.EntradaRepository;
import com.lacteo.control_lacteo.repositories.ValeRepository;

@RestController
public class NewRegistryController {
    private NewRegistryService regService;
    private EntradaRepository entRepo;
    private ValeRepository valeRepo;

    @Autowired
    public void setChoferService(NewRegistryService regService) {
        this.regService = regService;
    }

    @Autowired
    public void setEntradaRepository(EntradaRepository entRepo) {
        this.entRepo = entRepo;
    }
    @Autowired
    public void setValeRepository(ValeRepository valeRepo) {
        this.valeRepo = valeRepo;
    }

    @PostMapping("newRegistry")
    void createRegistry(@RequestBody Registro registro) {
         this.regService.saveRegistro(registro);
    }

    @PostMapping("incrementInRegistry")
    void incrementInRegistry(@RequestBody Registro registro) {
        System.out.println(registro);
         this.regService.incrementInRegistry(registro.getMes(), registro.getYear(), registro.getCantidadDeLeche());
    }

    @PostMapping("decrementInRegistry")
    void decrementInRegistry(@RequestBody Registro registro) {
        System.out.println(registro);
         this.regService.decrementInRegistry(registro.getMes(), registro.getYear(), registro.getCantidadDeLeche());
    }



    @GetMapping("getValesForId/{id}")
    List<Object> getValesForId(@PathVariable Integer id){
        System.out.println(id);
        return this.valeRepo.getValesForId(id);
    }
    @GetMapping("getValesIds")
    List<Integer> getValesIds(){
        return this.valeRepo.getValesIds();
    }

    @PostMapping("newEntry")
    void createEntry(@RequestBody Entrada entrada) {
        System.out.println(entrada); 
        Integer n  = entrada.getVales().size();
        this.entRepo.save(entrada);
        for(int i=0; i < n; i++) {
            Vale vale = entrada.getVales().get(i);
            Vale newVale = new Vale();
            newVale.setEntrada(entrada);
            newVale.setNumero_de_vale(vale.getNumero_de_vale());
            newVale.setCodigo_proveedor(vale.getCodigo_proveedor());
            newVale.setCantidad_de_leche(vale.getCantidad_de_leche());
            System.out.println(newVale); 
            this.valeRepo.save(newVale);
        }
        System.out.println(entrada); 

    }

    @DeleteMapping("deleteEntry/{id}")
    void delete(@PathVariable Integer id) {
        this.entRepo.deleteById(id);
    }
}
