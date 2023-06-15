package com.footballsystem.gestion.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Partidos implements Serializable {

    private static final long serialVersionUID = -1899148652355432331L;

    @Id
    private Long id;
    @Column
    private int id_fase;
    @Column
    private int id_sede;
    @Column
    private int id_equipo_a;
    @Column
    private int id_equipo_b;
    @Column
    private int result_eq_a;
    @Column
    private int result_eq_b;
    @Column
    private String fecha;
    @Column
    private String hora;

    public Partidos(){}
    public Partidos(int id_fase, int id_sede, int id_equipo_a, int id_equipo_b, int resul_eq_a, int resul_eq_b, String fecha, String hora) {
        this.id_fase = id_fase;
        this.id_sede = id_sede;
        this.id_equipo_a = id_equipo_a;
        this.id_equipo_b = id_equipo_b;
        this.result_eq_a = resul_eq_a;
        this.result_eq_b = resul_eq_b;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getId_fase() {
        return id_fase;
    }

    public void setId_fase(int id_fase) {
        this.id_fase = id_fase;
    }

    public int getId_sede() {
        return id_sede;
    }

    public void setId_sede(int id_sede) {
        this.id_sede = id_sede;
    }

    public int getId_equipo_a() {
        return id_equipo_a;
    }

    public void setId_equipo_a(int id_equipo_a) {
        this.id_equipo_a = id_equipo_a;
    }

    public int getId_equipo_b() {
        return id_equipo_b;
    }

    public void setId_equipo_b(int id_equipo_b) {
        this.id_equipo_b = id_equipo_b;
    }

    public int getResult_eq_a() {
        return result_eq_a;
    }

    public void setResult_eq_a(int resul_eq_a) {
        this.result_eq_a = resul_eq_a;
    }

    public int getResult_eq_b() {
        return result_eq_b;
    }

    public void setResult_eq_b(int resul_eq_b) {
        this.result_eq_b = resul_eq_b;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Partidos{" +
                "id=" + id +
                ", id_fase=" + id_fase +
                ", id_sede=" + id_sede +
                ", id_equipo_a=" + id_equipo_a +
                ", id_equipo_b=" + id_equipo_b +
                ", resul_eq_a=" + result_eq_a +
                ", resul_eq_b=" + result_eq_b +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                '}';
    }
}
