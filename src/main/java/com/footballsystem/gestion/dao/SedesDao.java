package com.footballsystem.gestion.dao;

import com.footballsystem.gestion.bo.Connections;
import com.footballsystem.gestion.models.Jugadores;
import com.footballsystem.gestion.models.Sedes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SedesDao {

    private static Connection connMySql = Connections.conectarMySql();


    public static List<Sedes> listarSedes() {
        List<Sedes> listado = new ArrayList<>(); //Creo mi ArrayList de jugador
        try {
            String sql = "SELECT * FROM `SEDE`";
            Statement statement = connMySql.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Sedes sede = new Sedes();
                sede.setId(rs.getLong(1));
                sede.setSede(rs.getString(2));
                sede.setEstadios(rs.getInt(3));
                sede.setAño(rs.getInt(4));
                sede.setEstadio_inaugural(rs.getString(5));
                sede.setEstadio_final(rs.getString(6));
                sede.setLink_logo(rs.getString(7));
                listado.add(sede);
            }
            statement.close();
            connMySql.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }


}
