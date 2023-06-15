package com.footballsystem.gestion.test;

import com.footballsystem.gestion.bo.Connections;
import com.footballsystem.gestion.dao.*;
import com.footballsystem.gestion.models.Cuentas;
import com.footballsystem.gestion.models.Entrenadores;
import com.footballsystem.gestion.view.AdministradorAllTables;
import com.footballsystem.gestion.view.Formulario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {

        //SELECT * FROM `view_entrenadores`

        //listarViewEntrenadores().forEach(System.out::println);

        //JugadoresDao.listarViewJugadores().forEach(System.out::println);
        //JugadoresDao.listaEquipos();

        System.out.println(EquiposDao.searchEquipoXId(1));
        //JugadoresDao.listarTablaJugadores().forEach(System.out::println);

    }


}
