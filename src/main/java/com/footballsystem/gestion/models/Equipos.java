package com.footballsystem.gestion.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity @ToString @Getter @Setter
public class Equipos implements Serializable {

    private static final long serialVersionUID = -1845688852926782331L;

    @Id
    private Long id;
    @Column
    private String nombre;
    @Column
    private int cantidad_jugadores;
    @Column
    private String estado;

    public Equipos(){}

}
