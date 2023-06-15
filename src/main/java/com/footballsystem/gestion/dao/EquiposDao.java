package com.footballsystem.gestion.dao;

import com.footballsystem.gestion.bo.Connections;
import com.footballsystem.gestion.models.Equipos;
import com.footballsystem.gestion.models.Jugadores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EquiposDao {

    private static Connection connMySql = Connections.conectarMySql();


    public static List<Equipos> listarEquipos() {
        List<Equipos> listado = new ArrayList<>(); //Creo mi ArrayList de jugador
        try {
            String sql = "SELECT * FROM `EQUIPOS`";
            Statement statement = connMySql.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Equipos equipo = new Equipos();
                equipo.setId(rs.getLong(1));
                equipo.setNombre(rs.getString(2));
                equipo.setCantidad_jugadores(rs.getInt(3));
                equipo.setEstado(rs.getString(4));
                listado.add(equipo);
            }
            //statement.close();
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

    public static Equipos searchEquipoXId(Integer id) {
        Equipos equipo = new Equipos();
        try {
            String sql = "SELECT ID,NOMBRE,CANTIDAD_JUGADORES,ESTADO FROM `EQUIPOS` WHERE ID = "+id+";";
            Statement statement = connMySql.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
                equipo.setId(rs.getLong("ID"));
                equipo.setNombre(rs.getString("NOMBRE"));
                equipo.setCantidad_jugadores(rs.getInt("CANTIDAD_JUGADORES"));
                equipo.setEstado(rs.getString("ESTADO"));
            }
        } catch (Exception e) {
            try {
                connMySql.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println(e.getMessage());
        }
        return equipo;
    }


    public static ResultSet ResultSetEquipos() {
        ResultSet resultSet = null;
        try {
            String sql = "SELECT nombre,cantidad_jugadores,estado FROM `EQUIPOS`";
            Statement statement = connMySql.createStatement();
            resultSet = statement.executeQuery(sql);  //Crea una tabla en memoria según la consulta
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultSet; //Retorma modelo tabla
    }

    public static ResultSet ResultSetUltimoEquipos() {
        ResultSet resultSet = null;
        try {
            String sql = "SELECT * FROM equipos ORDER BY id DESC LIMIT 1;";
            Statement statement = connMySql.createStatement();
            resultSet = statement.executeQuery(sql);  //Crea una tabla en memoria según la consulta
            //statement.close();
        } catch (Exception e) {
            /*try {
                connMySql.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }*/
            System.out.println(e.getMessage());
        }
        return resultSet;
    }


    public static void Agregar(Equipos equipos){
        String sql = "INSERT INTO `equipos` (`id`, `nombre`, `cantidad_jugadores`, `estado`) " +
                "VALUES (NULL,'"+equipos.getNombre()+"','"+equipos.getCantidad_jugadores()+"','"+ equipos.getEstado()+"');";
        try {
            Statement statement = connMySql.createStatement();
            statement.execute(sql);
            statement.close();
        }catch (Exception e){
            try {
                connMySql.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println(e.getMessage());
        }
    }

    public static void actualizar(Equipos equipo){
        try{
            String sql = "UPDATE `equipos` SET " +
                    "`nombre` = '"+equipo.getNombre()+"', " +
                    "`cantidad_jugadores` = '"+equipo.getCantidad_jugadores()+"', " +
                    "`estado` = '"+equipo.getEstado()+"' " +
                    "WHERE `equipos`.`id` = "+equipo.getId()+"; ";
            Statement statement = connMySql.createStatement();
            statement.execute(sql);
        }catch (Exception e){
            try {
                connMySql.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.getMessage();
        }
    }

    public static void eliminarFila(Long id){
        try{
            String sql = "DELETE FROM `equipos` WHERE `equipos`.`id` = "+id+" ;";
            Statement statement = connMySql.createStatement();
            statement.execute(sql);
        }catch (Exception e){
            try {
                connMySql.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.getMessage();
        }
    }
}
//DELETE FROM `equipos` WHERE `equipos`.`id` = 5;

// BUSCAR --> PROCEDIMIENTOS ALMACENADOS
