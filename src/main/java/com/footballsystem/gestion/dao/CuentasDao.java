package com.footballsystem.gestion.dao;

import com.footballsystem.gestion.bo.Connections;
import com.footballsystem.gestion.models.Cuentas;


import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CuentasDao {

    private static Connection connMySqlCuentas = Connections.conectarMySqlCuentas();
    //public static List<Cuentas> listaCuentas = new ArrayList<>();

    public static List<Cuentas> listarCuentas() {
        List<Cuentas> listado = new ArrayList<>(); //Creo mi ArrayList de jugador
        try {
            String sql = "SELECT * FROM `CUENTAS`";
            Statement statement = connMySqlCuentas.createStatement(); //STATEMENT PERMITE EJERCUTAR SENTENCIAS DDL Y DML EN JAVA
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Cuentas cuenta = new Cuentas();
                cuenta.setId(rs.getLong(1));
                cuenta.setNombre(rs.getString(2));
                cuenta.setApellido(rs.getString(3));
                cuenta.setEdad(rs.getInt(4));
                cuenta.setEmail(rs.getString(5));
                cuenta.setNom_usuario(rs.getString(6));
                cuenta.setContraseña(rs.getString(7));
                cuenta.setTelefono(rs.getString(8));
                cuenta.setPais(rs.getString(9));
                cuenta.setCuidad(rs.getString(10));
                cuenta.setCodigo_postal(rs.getString(11));
                cuenta.setRole(rs.getString(12));
                cuenta.setEstado(rs.getString(13));
                listado.add(cuenta);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public static void Agregar(Cuentas cuentas){
        String sql = "INSERT INTO `cuentas`(`id`, `nombre`, `apellido`, `edad`, `email`, `nom_usuario`, `contraseña`, `telefono`, `pais`, `ciudad`, `codigo_postal`, `role`, `estado`) " +
                     "VALUES (NULL, '"+cuentas.getNombre()+"', '"+cuentas.getApellido()+"', "+cuentas.getEdad()+", '"+cuentas.getEmail()+"', '"+cuentas.getNom_usuario()+"', '"+cuentas.getContraseña()+"', '"+cuentas.getTelefono()+"', '"+cuentas.getPais()+"', '"+cuentas.getCuidad()+"', '"+cuentas.getCodigo_postal()+"', '"+cuentas.getRole()+"', '"+cuentas.getEstado()+"');";
        try {
            Statement statement = connMySqlCuentas.createStatement();
            statement.execute(sql);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public static Boolean accesoCuenta(String email, String password){
        Boolean verificar = false;
        for (Cuentas element: CuentasDao.listarCuentas()) {
            if(element.getEmail().equals(email) && element.getContraseña().equals(password)){
                verificar = true;
            }
        }
        return verificar;
    }

    public static String rolDeCuenta(String email, String password){
        String role = "";
        for (Cuentas element: CuentasDao.listarCuentas()) {
            if(element.getEmail().equals(email) && element.getContraseña().equals(password)){
                role = element.getRole();
            }
        }
        return role;
    }

}
