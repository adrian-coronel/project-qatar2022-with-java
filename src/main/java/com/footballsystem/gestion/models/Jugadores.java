package com.footballsystem.gestion.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity @Getter @Setter @ToString
public class Jugadores implements Serializable {

    private static final long serialVersionUID = -1845648652554782331L;


    @Id
    private Long id;
    @Column
    private String id_equipo;
    @Column
    private String id_entrenador;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private int num_camiseta;
    @Column
    private int edad;
    @Column
    private String dni;
    @Column
    private String pais_natal;
    @Column
    private String posicion;
    @Column
    private char estado;


    public Jugadores() {
    }

    public Jugadores(String id_equipo, String id_entrenador, String nombre, String apellido, int num_camiseta, int edad, String dni, String pais_natal, String posicion, char estado) {
        this.id_equipo = id_equipo;
        this.id_entrenador = id_entrenador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.num_camiseta = num_camiseta;
        this.edad = edad;
        this.dni = dni;
        this.pais_natal = pais_natal;
        this.posicion = posicion;
        this.estado = estado;
    }

}
