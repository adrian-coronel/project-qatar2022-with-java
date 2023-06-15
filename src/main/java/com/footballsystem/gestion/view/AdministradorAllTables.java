package com.footballsystem.gestion.view;

import com.footballsystem.gestion.dao.AllTablesDao;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministradorAllTables {
    private static JFrame frame;
    private JTable table1;
    private JButton btnDescribe;
    public  JPanel JPanelAdmin;
    private JButton btnVerTabla;
    private JTable table2;
    private JButton btnSalir;

    //private static List<String> listAllTables = AllTablesDao.

    public AdministradorAllTables() {
        cargarAllTables();
        btnDescribe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(obtenerNameIndice() != null){
                    ResultSet describeTable = AllTablesDao.resultSetDescribeTable(obtenerNameIndice());
                    table2.setModel(DbUtils.resultSetToTableModel(describeTable));
                }
                else {JOptionPane.showMessageDialog(null,"Seleccione la fila de la tabla que desea describir");}
            }
        });
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        btnVerTabla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(obtenerNameIndice().equals("equipos")){
                    AdminEquipo.getFrameAdminEquipo().setVisible(true);
                }
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("Administrador");
        frame.setContentPane(new AdministradorAllTables().JPanelAdmin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    //Methods

    public static JFrame getFrameAdmin(){
        frame = new JFrame("Administrador");
        frame.setContentPane(new AdministradorAllTables().JPanelAdmin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        return frame;
    }

    public void cargarAllTables(){
        ResultSet rsAllTables = AllTablesDao.resultModelAllTables();
        table1.setModel(DbUtils.resultSetToTableModel(rsAllTables));
    }

    public String obtenerNameIndice(){
        List<String> listTablas = new ArrayList<>();
        int indice = table1.getSelectedRow();
        ResultSet rsNameTables = AllTablesDao.resultModelNameTables();//Modelado del AllNamesTables
        try {
            if(indice == -1){return null;}
            else {
                while (rsNameTables.next()) {
                    listTablas.add(rsNameTables.getString("TABLE_NAME"));//AllNames se agregan a listTablas
                }
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return listTablas.get(indice);//Retorna el nombre del indice selecionado
    }

}
