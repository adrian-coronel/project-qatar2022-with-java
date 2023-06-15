package com.footballsystem.gestion.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity @Getter @Setter @ToString
public class Entrenadores implements Serializable {

    private static final long serialVersionUID = -184556752554782331L;

    @Id
    private Long id;
    @Column
    private int id_equipo;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private int edad;
    @Column
    private String dni;
    @Column
    private String pais_natal;

    public Entrenadores(){}

    public Entrenadores(int id_equipo, String nombre, String apellido, int edad, String dni, String pais_natal) {
        this.id_equipo = id_equipo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
        this.pais_natal = pais_natal;
    }
}
