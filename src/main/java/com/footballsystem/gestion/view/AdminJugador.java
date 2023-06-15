package com.footballsystem.gestion.view;

import com.footballsystem.gestion.dao.EquiposDao;
import com.footballsystem.gestion.dao.JugadoresDao;
import com.footballsystem.gestion.models.Equipos;
import com.footballsystem.gestion.models.Jugadores;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.List;

public class AdminJugador {

    private static JFrame frame;
    private JComboBox comboBox1;
    public JPanel MainTableJugador;
    private JTextField textField1;
    private JComboBox comboBox2;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTable table1;
    private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnActualizar;
    private JButton btnListar;

    public AdminJugador() {
        cargarTablaJugadores();
        optionsComboBoxEquipo();
        optionsComboBoxEntrenador();
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarCombobox1();
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("AdminJugador");
        frame.setContentPane(new AdminJugador().MainTableJugador);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    //Methods
    public static JFrame getFrameJugador(){
        frame = new JFrame("AdminJugador");
        frame.setContentPane(new AdminJugador().MainTableJugador);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return frame;
    }

    private void cargarTablaJugadores(){
        ResultSet resultSet = JugadoresDao.resulSetViewJugadores();
        table1.setModel(DbUtils.resultSetToTableModel(resultSet));
    }

    private void optionsComboBoxEquipo(){
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        JugadoresDao.listaEquipos().forEach(equipo ->{
            comboBoxModel.addElement(equipo.getNombre());
        });
        comboBox1.setModel(comboBoxModel);
    }

    private void optionsComboBoxEntrenador(){
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        JugadoresDao.listaEntrenadores().forEach(entrenador ->{
            comboBoxModel.addElement(entrenador.getApellido()+", "+entrenador.getNombre());
        });
        comboBox2.setModel(comboBoxModel);
    }


    public void listarCombobox1(){
        int indice = table1.getSelectedRow(); //Indice selecionado de la tabla
        Jugadores jugador = JugadoresDao.listarTablaJugadores().get(indice); //obtengo el jugador mediante el indice
        Equipos equipo = JugadoresDao.searchEquipoXIndex(Integer.parseInt(jugador.getId_equipo())); //obtengo el equipo mediante el "fk" de TableJugadores
        comboBox1.setSelectedItem(equipo.getNombre());//Selecciona el Equipo en el ComboBox
    }


    public void modeladoTabla(){
        Object row = new Object[5];

    }

}
