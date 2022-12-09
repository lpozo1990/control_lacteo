package com.lacteo.control_lacteo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lacteo.control_lacteo.Entities.Chofer;
import com.lacteo.control_lacteo.repositories.ChoferRepository;

@RestController
public class GetDriversNamesController {
	@Autowired
	private ChoferRepository choferRepo;

	@GetMapping("/getDriversNames")
	List<Chofer> getAllNames(){
		return this.choferRepo.findAll();
	}
}
