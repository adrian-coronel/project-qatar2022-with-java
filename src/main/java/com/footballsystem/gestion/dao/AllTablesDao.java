package com.footballsystem.gestion.dao;

import com.footballsystem.gestion.bo.Connections;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AllTablesDao {

    private static Connection connMySql = Connections.conectarMySql();


    public static List<List> listarAllTables(){
        List<List> allTable = new ArrayList<>();
        try{
            String sql = "SELECT TABLE_SCHEMA, TABLE_NAME, TABLE_ROWS, CREATE_TIME FROM INFORMATION_SCHEMA.tables WHERE TABLE_SCHEMA='project_db'; ";
            Statement statement = connMySql.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                List<String> arreglo = new ArrayList<>();
                arreglo.add(resultSet.getString("TABLE_SCHEMA"));
                arreglo.add(resultSet.getString("TABLE_NAME"));
                arreglo.add(resultSet.getString("TABLE_ROWS"));
                arreglo.add(resultSet.getString("CREATE_TIME"));
                allTable.add(arreglo);
            }
        }catch (Exception e){
            /*try {
                connMySql.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }*/
            System.out.println(e.getMessage());
        }
        return allTable;
    }


    public static ResultSet resultModelAllTables(){
        ResultSet resultSet = null;
        try{
            String sql = "SELECT TABLE_SCHEMA, TABLE_NAME, TABLE_ROWS, CREATE_TIME FROM INFORMATION_SCHEMA.tables WHERE TABLE_SCHEMA='project_db'; ";
            Statement statement = connMySql.createStatement();
            resultSet = statement.executeQuery(sql);
        }catch (Exception e){
            /*try {
                connMySql.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }*/
            System.out.println(e.getMessage());
        }
        return resultSet;
    }


    public static ResultSet resultModelNameTables(){
        ResultSet resultSet = null;
        try{
            String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.tables WHERE TABLE_SCHEMA='project_db'; ";
            Statement statement = connMySql.createStatement();
            resultSet = statement.executeQuery(sql); //Esto es una inyección SQL
        }catch (Exception e){
            /*try {
                connMySql.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }*/
            System.out.println(e.getMessage());
        }
        return resultSet;
    }


    public static ResultSet resultSetDescribeTable(String nameTable){
        ResultSet resultSet = null;
        try{
            String sql = "DESCRIBE "+nameTable+";";
            Statement statement = connMySql.createStatement();
            resultSet = statement.executeQuery(sql);
        }catch (Exception e){
            /*try {
                connMySql.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }*/
            System.out.println(e.getMessage());
        }
        return resultSet;
    }

    



}
