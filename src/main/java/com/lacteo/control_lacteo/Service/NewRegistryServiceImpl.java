package com.lacteo.control_lacteo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacteo.control_lacteo.Entities.Registro;
import com.lacteo.control_lacteo.repositories.RegistroRepository;
@Service
public class NewRegistryServiceImpl implements NewRegistryService {
    private RegistroRepository regRepo;

    @Autowired
    public void setMunicipioRepository(RegistroRepository regRepo) {
        this.regRepo = regRepo;
    }

    @Override
    public Registro saveRegistro(Registro registro) {
        return this.regRepo.save(registro);
    }

    @Override
    public Iterable<Registro> getAllRegForYear(Integer year) {
        return this.regRepo.findAllByYear(year);
    }

	@Override
	public List<Integer> getAllYears() {
        return this.regRepo.getAllYears();
	}
}
