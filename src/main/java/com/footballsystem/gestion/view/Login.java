package com.footballsystem.gestion.view;



import com.footballsystem.gestion.dao.AllTablesDao;
import com.footballsystem.gestion.dao.CuentasDao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {

    JPanel Main;
    private JTextField txtCuenta;
    private JPasswordField passwordField1;
    private JLabel labelCuenta;
    private JLabel labelContraseña;
    private JButton iniciarSesionButton;
    private JButton registrarseButton;


    private Integer indiceComboBox = 0;


    public Login() {
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = new String(passwordField1.getPassword());
                Boolean verificar = CuentasDao.accesoCuenta(txtCuenta.getText(),password);
                if(verificar != true){JOptionPane.showMessageDialog(null,"Ocurrio un error, intente nuevamente");}
                else{
                    JOptionPane.showMessageDialog(null,"Acceso confirmado");
                    if(CuentasDao.rolDeCuenta(txtCuenta.getText(),password).equals("Administrador")){AdministradorAllTables.getFrameAdmin().setVisible(true);}
                }
            }
        });
        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Formulario.getFrameForm().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new Login().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }




}
