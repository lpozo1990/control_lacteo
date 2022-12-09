package com.lacteo.control_lacteo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacteo.control_lacteo.Entities.Chofer;
import com.lacteo.control_lacteo.repositories.ChoferRepository;

@Service
public class ChoferServiceImp implements ChoferService {
    private ChoferRepository choferRepository;

    @Autowired
    public void setChoferRepository(ChoferRepository choferRepository) {
        this.choferRepository = choferRepository;
    }

    @Override
    public Iterable<Chofer> listAllChofers() {
        return this.choferRepository.findAll();
    }

    @Override
    public Chofer getChoferById(Integer id) {
        return this.choferRepository.findById(id).get();
    }

    @Override
    public Chofer saveChofer(Chofer chofer) {
        return this.choferRepository.save(chofer);
    }

    @Override
    public void deleteChofer(Integer id) {
        this.choferRepository.deleteById(id); 
    }
    
	@Override
	public  Object[] listAllChofersNames() {
        return this.choferRepository.findNames();
	}
    
}
