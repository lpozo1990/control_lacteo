package com.lacteo.control_lacteo.Entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class RegistroID implements Serializable {
    private String mes;
    private Integer year;
}
