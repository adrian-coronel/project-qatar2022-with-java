package com.footballsystem.gestion.view;

import com.footballsystem.gestion.dao.AllTablesDao;
import com.footballsystem.gestion.dao.EquiposDao;
import com.footballsystem.gestion.models.Equipos;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AdminEquipo {

    private static JFrame frame;
    public JPanel Main;
    private JTable table1;
    private JTextField txtNombre;
    private JTextField txtCantJugadores;
    private JTextField txtEstado;
    private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnActualizar;
    private JButton btnListar;
    private JButton btnDescribe;
    private JTable table2;
    private JButton btnSalir;


    public AdminEquipo() {
        cargarTablaEquipos();
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Equipos equipo = new Equipos();
                equipo.setNombre(txtNombre.getText());
                equipo.setCantidad_jugadores(Integer.parseInt(txtCantJugadores.getText()));
                equipo.setEstado(txtEstado.getText());
                EquiposDao.Agregar(equipo);
                cargarTablaEquipos();
                limpiarLabels();
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarLabels();
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indice = table1.getSelectedRow();
                Equipos equipo = EquiposDao.listarEquipos().get(indice);
                equipo.setNombre(txtNombre.getText());
                equipo.setCantidad_jugadores(Integer.parseInt(txtCantJugadores.getText()));
                equipo.setEstado(txtEstado.getText());
                EquiposDao.actualizar(equipo);
                limpiarLabels();
                cargarTablaEquipos();
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String [] botones = { "Confirmar", "Cancelar"};
                int opcion = JOptionPane.showOptionDialog (null, "¿Seguro que desea eliminar la fila?", "Eliminar", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null/*icono*/, botones, botones[0]);
                if(opcion == 0){
                    int indice = table1.getSelectedRow();
                    Equipos equipo = EquiposDao.listarEquipos().get(indice);
                    EquiposDao.eliminarFila(equipo.getId());
                    cargarTablaEquipos();
                }

            }
        });
        btnDescribe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet describeTable = AllTablesDao.resultSetDescribeTable("equipos");
                table2.setModel(DbUtils.resultSetToTableModel(describeTable));
            }
        });
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("AdminEquipo");
        frame.setContentPane(new AdminEquipo().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public static JFrame getFrameAdminEquipo(){
        frame = new JFrame("AdminEquipo");
        frame.setContentPane(new AdminEquipo().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return frame;
    }


    private void cargarTablaEquipos(){
        ResultSet resultSet = EquiposDao.ResultSetEquipos();
        table1.setModel(DbUtils.resultSetToTableModel(resultSet));
    }

    public void listarLabels(){
        int indice = table1.getSelectedRow();
        Equipos equipo = EquiposDao.listarEquipos().get(indice);
        txtNombre.setText(equipo.getNombre());
        txtCantJugadores.setText(""+equipo.getCantidad_jugadores());
        txtEstado.setText(equipo.getEstado());

    }

    public void limpiarLabels(){
        txtNombre.setText(null);
        txtCantJugadores.setText(null);
        txtEstado.setText(null);
    }



}
