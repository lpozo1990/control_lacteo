package com.lacteo.control_lacteo.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@Entity
@Table(name = "Vales")
public class Vale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="entrada_id", nullable = true)
    private Entrada entrada;
    private String numero_de_vale;
    private String codigo_proveedor;
    private Integer cantidad_de_leche;
    
}
