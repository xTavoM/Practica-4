package com.sistema.tiquetes.ui;

import com.sistema.tiquetes.bl.BL;
import com.sistema.tiquetes.model.Administrador;
import com.sistema.tiquetes.model.Creador;
import com.sistema.tiquetes.model.Tecnico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Main {
    private static BL bl = new BL(); // Eliminamos 'final' si no es necesario

    private static JFrame LoginFrame;
    private static JFrame MainFrame;


    public static void main(String[] args) {
        // Crear el marco de inicio de sesión
        Login();

    }

    public static void MainFrame() {
        JFrame frame = new JFrame("Sistema de Tiquetes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(0, 2));

        // Campos de entrada
        JTextField codigoField = new JTextField();
        JTextField nombreField = new JTextField();
        JTextField primerApellidoField = new JTextField();
        JTextField segundoApellidoField = new JTextField();
        JTextField correoField = new JTextField();
        JTextField telefonoField = new JTextField();
        JTextField passwordField = new JTextField();
        JTextField departamentoField = new JTextField();
        JTextField rolField = new JTextField();

        // Botones
        JButton agregarCreadorButton = new JButton("Agregar Creador");
        JButton agregarTecnicoButton = new JButton("Agregar Técnico");
        JButton agregarAdminButton = new JButton("Agregar Administrador");
        JButton modificarUsuarioButton = new JButton("Modificar Usuario");
        JButton eliminarUsuarioButton = new JButton("Eliminar Usuario");

        // Agregar componentes al marco
        frame.add(new JLabel("Código:"));
        frame.add(codigoField);
        frame.add(new JLabel("Nombre:"));
        frame.add(nombreField);
        frame.add(new JLabel("Primer Apellido:"));
        frame.add(primerApellidoField);
        frame.add(new JLabel("Segundo Apellido:"));
        frame.add(segundoApellidoField);
        frame.add(new JLabel("Correo Electrónico:"));
        frame.add(correoField);
        frame.add(new JLabel("Teléfono:"));
        frame.add(telefonoField);
        frame.add(new JLabel("Contraseña:"));
        frame.add(passwordField);
        frame.add(new JLabel("Departamento (Creador):"));
        frame.add(departamentoField);
        frame.add(new JLabel("Rol (Técnico):"));
        frame.add(rolField);
        frame.add(agregarCreadorButton);
        frame.add(agregarTecnicoButton);
        frame.add(agregarAdminButton);
        frame.add(modificarUsuarioButton);
        frame.add(eliminarUsuarioButton);

        // Acción para agregar Creador
        agregarCreadorButton.addActionListener(e -> {
            Creador creador = new Creador(codigoField.getText(), nombreField.getText(), primerApellidoField.getText(), segundoApellidoField.getText(), correoField.getText(), telefonoField.getText(), passwordField.getText(), departamentoField.getText());
            bl.agregarCreador(creador);
            JOptionPane.showMessageDialog(frame, "Creador agregado exitosamente!");
            limpiarCampos(codigoField, nombreField, primerApellidoField, segundoApellidoField, correoField, telefonoField, passwordField, departamentoField, rolField);
        });

        // Acción para agregar Técnico
        agregarTecnicoButton.addActionListener(e -> {
            Tecnico tecnico = new Tecnico(codigoField.getText(), nombreField.getText(), primerApellidoField.getText(), segundoApellidoField.getText(), correoField.getText(), telefonoField.getText(), passwordField.getText(), rolField.getText());
            bl.agregarTecnico(tecnico);
            JOptionPane.showMessageDialog(frame, "Técnico agregado exitosamente!");
            limpiarCampos(codigoField, nombreField, primerApellidoField, segundoApellidoField, correoField, telefonoField, passwordField, departamentoField, rolField);
        });

        // Acción para agregar Administrador
        agregarAdminButton.addActionListener(e -> {
            boolean estado = true; // Set to true for active
            Administrador admin = new Administrador(codigoField.getText(), nombreField.getText(), primerApellidoField.getText(), segundoApellidoField.getText(), correoField.getText(), telefonoField.getText(), passwordField.getText(), estado);
            bl.agregarAdministrador(admin);
            JOptionPane.showMessageDialog(frame, "Administrador agregado exitosamente!");
            limpiarCampos(codigoField, nombreField, primerApellidoField, segundoApellidoField, correoField, telefonoField, passwordField, departamentoField, rolField);
        });

        // Hacer visible el marco
        frame.setVisible(true);
    }

    // Método para limpiar campos
    private static void limpiarCampos(JTextField... campos) {
        for (JTextField campo : campos) {
            campo.setText("");
        }
    }

    private static void Login() {
        LoginFrame = new JFrame("Login");
        LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LoginFrame.setSize(300, 100);
        LoginFrame.setLayout(new GridLayout(0, 2));

        // Campos de entrada
        JTextField usuario = new JTextField();
        JTextField contrasena = new JTextField();

        JButton loginButton = new JButton("Login");

        LoginFrame.add(new JLabel("Usuario"));
        LoginFrame.add(usuario);

        LoginFrame.add(new JLabel("Contraseña"));
        LoginFrame.add(contrasena);

        loginButton.addActionListener(e -> {
            LoginFrame.setVisible(false);
            MainFrame();
        });

        LoginFrame.add(loginButton);

        LoginFrame.setVisible(true);
    }
}
