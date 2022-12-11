package com.lacteo.control_lacteo.Entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.ToString;


@Data
@Entity
@ToString(exclude = {"vales"})
@Table(name = "Entradas")
public class Entrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy="entrada",fetch = FetchType.LAZY,  orphanRemoval = true)
    private List<Vale> vales;

    private String nombreDelChofer;
    
    private Date fecha;
    
    private String ruta;
    private Integer cantidadLeche;
    
}
