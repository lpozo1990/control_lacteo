package com.lacteo.control_lacteo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacteo.control_lacteo.Entities.Proveedor;
import com.lacteo.control_lacteo.repositories.ProviderRepository;

@Service
public class ProvidersServiceImpl implements ProvidersService {
    private ProviderRepository providerRepository;

    @Autowired
    public void setProviderRepository(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public Iterable<Proveedor> listAllProviders() {
        return this.providerRepository.findAll();
    }

    @Override
    public Proveedor getProveedorById(Integer id) {
        return this.providerRepository.findById(id).get();
    }

    @Override
    public Proveedor saveProveedor(Proveedor proveedor) {
        return this.providerRepository.save(proveedor);
    }

    @Override
    public void deleteProveedor(Integer id) {
        this.providerRepository.deleteById(id); 
    }

    @Override
    public Iterable<Proveedor> getByCat(Integer cantidad) {
        return this.providerRepository.findAllByCantidadDeLeche(cantidad);
    }
    
    @Override
    public void incrementInMunicipio(String municipio, Integer cantidadDeLeche) {
        this.providerRepository.incrementInMunicipio(municipio, cantidadDeLeche);
    }

    @Override
    public Iterable<Integer> getCodes() {
        return this.providerRepository.getAllCodes();
    }

	@Override
	public void incrementIfCodeIs(String codigo, Integer cantidadDeLeche) {
        this.providerRepository.incrementIfCodeIs(codigo, cantidadDeLeche);
	}
	@Override
	public void incrementLecheInmunicipio(String codigo, Integer cantidadDeLeche) {
        this.providerRepository.incrementLecheInmunicipio(codigo, cantidadDeLeche);
	}

	@Override
	public void decrementLecheInmunicipio(String municipio, Integer cantidadDeLeche) {
		this.providerRepository.decrementLecheInmunicipio(municipio, cantidadDeLeche);
		
	}
	@Override
	public void decrementIfCodeIs(String municipio, Integer cantidadDeLeche) {
		this.providerRepository.decrementIfCodeIs(municipio, cantidadDeLeche);
		
	}
    
}
