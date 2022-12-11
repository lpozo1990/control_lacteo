package com.lacteo.control_lacteo.Controllers;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lacteo.control_lacteo.Entities.Entrada;
import com.lacteo.control_lacteo.Entities.Proveedor;
import com.lacteo.control_lacteo.Entities.Registro;
import com.lacteo.control_lacteo.Entities.Vale;
import com.lacteo.control_lacteo.Service.NewRegistryService;
import com.lacteo.control_lacteo.repositories.EntradaRepository;
import com.lacteo.control_lacteo.repositories.MunicipioRepository;
import com.lacteo.control_lacteo.repositories.ProviderRepository;
import com.lacteo.control_lacteo.repositories.RegistroRepository;
import com.lacteo.control_lacteo.repositories.ValeRepository;

@RestController
public class NewRegistryController {

	@Autowired
	private NewRegistryService regService;
	@Autowired
	private ProviderRepository provRepo;
	@Autowired
	private EntradaRepository entRepo;
	@Autowired
	private ValeRepository valeRepo;
	@Autowired
	private RegistroRepository registroRepo;


	@PostMapping("newRegistry")
	void createRegistry(@RequestBody Registro registro) {
		this.regService.saveRegistro(registro);
	}

	@PostMapping("incrementInRegistry")
	void incrementInRegistry(@RequestBody Registro registro) {
		System.out.println(registro);
		List<Registro> registros = this.registroRepo.findByMesAndYear(registro.getMes(), registro.getYear());
		if(registros.isEmpty()) {
			Registro nuevoReg = new Registro();
			nuevoReg.setMes(registro.getMes());
			nuevoReg.setYear(registro.getYear());
			nuevoReg.setCantidadDeLeche(registro.getCantidadDeLeche());
			this.registroRepo.save(nuevoReg);
		} else {			
			this.regService.incrementInRegistry(registro.getMes(), registro.getYear(), registro.getCantidadDeLeche());
		}
	}
	@GetMapping("getProviders")
	Iterable<Proveedor> getProviders(){
		return this.provRepo.findAll();
	}
	@PostMapping("decrementInRegistry")
    void decrementInRegistry(@RequestBody Registro registro) {
		 long cantidad = this.entRepo.count();
		 if(cantidad == 1) {
			 List<Registro> result = this.registroRepo.findByMesAndYear(registro.getMes(), registro.getYear());
			 Registro reg = result.get(0);
			 this.registroRepo.delete(reg);
		 }
			List<Registro> registros = this.registroRepo.findByMesAndYear(registro.getMes(), registro.getYear());
			if(registros.isEmpty()) {
				Registro nuevoReg = new Registro();
				nuevoReg.setMes(registro.getMes());
				nuevoReg.setYear(registro.getYear());
				nuevoReg.setCantidadDeLeche(registro.getCantidadDeLeche());
				this.registroRepo.save(nuevoReg);
			} else {				
				System.out.println(cantidad);
				this.regService.decrementInRegistry(registro.getMes(), registro.getYear(), registro.getCantidadDeLeche());
			}
    }

	@GetMapping("getValesForId/{id}")
	List<Object> getValesForId(@PathVariable Integer id) {
		System.out.println(id);
		return this.valeRepo.getValesForId(id);
	}

	@GetMapping("getForEntradaId/{id}")
	List<Integer> getValesIds(@PathVariable Integer id) {
		Entrada ent = this.entRepo.findById(id).get();
		List<Integer> ids =new ArrayList<Integer>();
		ent.getVales().forEach((vale) -> {
			ids.add(vale.getId());
		});
		
		return ids;
	}

	@PostMapping("newEntry")
	void createEntry(@RequestBody Entrada entrada) {
		System.out.println(entrada.getVales());
		Integer n = entrada.getVales().size();
		this.entRepo.save(entrada);
		for (int i = 0; i < n; i++) {
			Vale vale = entrada.getVales().get(i);
			Vale newVale = new Vale();
			newVale.setEntrada(entrada);
			newVale.setNumero_de_vale(vale.getNumero_de_vale());
			newVale.setCodigoProveedor(vale.getCodigoProveedor());
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
