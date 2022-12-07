package com.lacteo.control_lacteo.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.vladmihalcea.hibernate.type.json.JsonType;

import org.hibernate.annotations.TypeDef;

import lombok.Data;


@Data
@Entity
@Table(name = "Vales")
@TypeDef(name = "json", typeClass = JsonType.class)
public class Vale implements Serializable {
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
