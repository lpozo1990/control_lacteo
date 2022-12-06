package com.lacteo.control_lacteo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lacteo.control_lacteo.Entities.Vale;

@Repository
@Transactional
public interface ValeRepository extends JpaRepository<Vale, Integer> {
    
}
