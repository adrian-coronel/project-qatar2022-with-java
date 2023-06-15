package com.footballsystem.gestion.view;

import com.footballsystem.gestion.dao.CuentasDao;
import com.footballsystem.gestion.models.Cuentas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Formulario {

    private static JFrame frame;
    JPanel miForm;
    private JTextField txtNombre;
    private JPasswordField passwordField1;
    private JComboBox comboBoxRoles;
    private JTextField txtApellido;
    private JTextField txtEdad;
    private JTextField txtNombreUsuario;
    private JTextField txtEmail;
    private JTextField txtTelefono;
    private JTextField txtPais;
    private JTextField txtCiudad;
    private JTextField txtCodigoPostal;
    private JButton registrarButton;

    private static Integer indiceComboBox = 0;


    public Formulario() {
        optionsComboBox();

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = new String(passwordField1.getPassword());
                if(esNull() != true){
                    Cuentas cuenta = new Cuentas(
                            txtNombre.getText(),
                            txtApellido.getText(),
                            Integer.parseInt(txtEdad.getText()),
                            txtEmail.getText(),
                            txtNombreUsuario.getText(),
                            password,
                            txtTelefono.getText(),
                            txtPais.getText(),
                            txtCiudad.getText(),
                            txtCodigoPostal.getText(),
                            obtenerRol(),
                            "1"
                    );
                    CuentasDao.Agregar(cuenta);
                    frame.dispose();
                }
                else{JOptionPane.showMessageDialog(null,"Es necesario rellenar todas las celdas");}
            }
        });
        comboBoxRoles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indiceComboBox = comboBoxRoles.getSelectedIndex();
            }
        });
    }

    private void optionsComboBox(){
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        comboBoxModel.addElement("Usuario");
        comboBoxModel.addElement("Administrador");
        comboBoxRoles.setModel(comboBoxModel);
    }

    public static JFrame getFrameForm(){
        frame = new JFrame("Formulario");
        frame.setContentPane(new Formulario().miForm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        return frame;
    }

    public static void main(String[] args) {
        frame = new JFrame("Formulario");
        frame.setContentPane(new Formulario().miForm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static String obtenerRol(){
        if(indiceComboBox == 0){
            return "Usuario";
        }
        return "Login";
    }

    public Boolean esNull(){
        Boolean esNull = false;
        String password = new String(passwordField1.getPassword());
        List<String> lista = new ArrayList<>();
        lista.add(txtNombre.getText());
        lista.add(txtApellido.getText());
        lista.add(txtEdad.getText());
        lista.add(txtEmail.getText());
        lista.add(txtNombreUsuario.getText());
        lista.add(password);
        lista.add(txtTelefono.getText());
        lista.add(txtPais.getText());
        lista.add(txtCiudad.getText());
        lista.add(txtCodigoPostal.getText());
        for (String element:lista){
            if (element.isEmpty()){esNull = true;}
        }
        return esNull;
    }


}
