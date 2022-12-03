package com.lacteo.control_lacteo.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "registros")
@IdClass(RegistroID.class)
public class Registro {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Id
    private String mes;
    @Id
    private Integer year;
    
    private Integer cantidadDeLeche;

}
