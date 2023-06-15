package com.footballsystem.gestion.dao;


import com.footballsystem.gestion.bo.Connections;
import com.footballsystem.gestion.models.Entrenadores;
import com.footballsystem.gestion.models.Equipos;
import com.footballsystem.gestion.models.Jugadores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JugadoresDao {

    private static Connection connMySql = Connections.conectarMySql();


    public static List<Jugadores> listarTablaJugadores() {
        List<Jugadores> listado = new ArrayList<>(); //Creo mi ArrayList de jugador
        try {
            String sql = "SELECT * FROM `JUGADORES`";
            Statement statement = connMySql.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Jugadores jugador = new Jugadores();
                jugador.setId(rs.getLong(1));
                jugador.setId_equipo(rs.getString(2));
                jugador.setId_entrenador(rs.getString(3));
                jugador.setNombre(rs.getString(4));
                jugador.setApellido(rs.getString(5));
                jugador.setNum_camiseta(rs.getInt(6));
                jugador.setEdad(rs.getInt(7));
                jugador.setDni(rs.getString(8));
                jugador.setPais_natal(rs.getString(9));
                jugador.setPosicion(rs.getString(10));
                jugador.setEstado(rs.getString(11).charAt(0));
                listado.add(jugador);
            }
            statement.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }


    public static List<Jugadores> listarViewJugadores() {
        List<Jugadores> listado = new ArrayList<>(); //Creo mi ArrayList de jugador
        try {
            String sql = "SELECT JUGADOR,EQUIPO,ENTRENADOR,NUM_CAMISETA,EDAD,DNI,PAIS_NATAL,POSICION FROM `view_jugadores` ";
            Statement statement = connMySql.createStatement(); //El statement Permite hacer transacciones
            ResultSet rs = statement.executeQuery(sql); //El resulSet Ayuda a hacer consultas
            while (rs.next()) {
                Jugadores jugador = new Jugadores();
                jugador.setNombre(rs.getString("JUGADOR"));
                jugador.setId_equipo(rs.getString("EQUIPO"));
                jugador.setId_entrenador(rs.getString("ENTRENADOR"));
                jugador.setNum_camiseta(rs.getInt("num_camiseta"));
                jugador.setEdad(rs.getInt("edad"));
                jugador.setDni(rs.getString("dni"));
                jugador.setPais_natal(rs.getString("pais_natal"));
                jugador.setPosicion("posicion");
                listado.add(jugador);
            }
            statement.close();
            connMySql.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public static ResultSet resulSetViewJugadores() {
        ResultSet rs = null;
        try {
            String sql = "SELECT JUGADOR,EQUIPO,ENTRENADOR,NUM_CAMISETA,EDAD,DNI,PAIS_NATAL,POSICION FROM `view_jugadores`;";
            Statement statement = connMySql.createStatement();
            rs = statement.executeQuery(sql);
            //statement.close();
            //connMySql.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public static List<Equipos> listaEquipos(){
        return EquiposDao.listarEquipos();
    }

    public static Equipos searchEquipoXIndex(Integer id){
        return EquiposDao.searchEquipoXId(id);
    }

    public static List<Entrenadores> listaEntrenadores(){
        return EntrenadoresDao.listarEntrenadores();
    }

}
