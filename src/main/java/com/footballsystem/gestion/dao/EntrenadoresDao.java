package com.footballsystem.gestion.dao;

import com.footballsystem.gestion.bo.Connections;
import com.footballsystem.gestion.models.Entrenadores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EntrenadoresDao {

    private static Connection connMySql = Connections.conectarMySql();


    public static List<Entrenadores> listarEntrenadores() {
        List<Entrenadores> listado = new ArrayList<>(); //Creo mi ArrayList de jugador
        try {
            String sql = "SELECT * FROM `ENTRENADORES`";
            Statement statement = connMySql.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Entrenadores entrendador = new Entrenadores();
                entrendador.setId(rs.getLong(1));
                entrendador.setId_equipo(rs.getInt(2));
                entrendador.setNombre(rs.getString(3));
                entrendador.setApellido(rs.getString(4));
                entrendador.setEdad(rs.getInt(5));
                entrendador.setDni(rs.getString(6));
                entrendador.setPais_natal(rs.getString(7));
                listado.add(entrendador);
            }
            statement.close();
            rs.close();
        } catch (Exception e) {
            try {
                connMySql.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println(e.getMessage());
        }
        return listado;
    }


}
