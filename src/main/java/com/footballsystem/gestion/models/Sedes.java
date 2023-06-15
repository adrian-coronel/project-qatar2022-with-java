package com.footballsystem.gestion.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity @Getter @Setter @ToString
public class Sedes implements Serializable {

    private static final long serialVersionUID = -1845688852554782331L;

    @Id
    private Long id;
    @Column
    private String sede;
    @Column
    private int estadios;
    @Column
    private int año;
    @Column
    private String estadio_inaugural;
    @Column
    private String estadio_final;
    @Column
    private String link_logo;

    public Sedes(){
    }

    public Sedes(String sede, int estadios, int año, String estadio_inaugural, String estadio_final, String link_logo) {
        this.sede = sede;
        this.estadios = estadios;
        this.año = año;
        this.estadio_inaugural = estadio_inaugural;
        this.estadio_final = estadio_final;
        this.link_logo = link_logo;
    }
}
