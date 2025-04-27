package com.sistema.tiquetes.ui;

import com.sistema.tiquetes.bl.BL;
import com.sistema.tiquetes.model.Administrador;
import com.sistema.tiquetes.model.Creador;
import com.sistema.tiquetes.model.Tecnico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static BL bl = new BL();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema de Tiquetes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
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

        // Agregar componentes al frame
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

        // Acción para agregar Creador
        agregarCreadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Creador creador = new Creador(codigoField.getText(), nombreField.getText(), primerApellidoField.getText(), segundoApellidoField.getText(), correoField.getText(), telefonoField.getText(), passwordField.getText(), departamentoField.getText());
                bl.agregarCreador(creador);
                JOptionPane.showMessageDialog(frame, "Creador agregado exitosamente!");
            }
        });

        // Acción para agregar Técnico
        agregarTecnicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tecnico tecnico = new Tecnico(codigoField.getText(), nombreField.getText(), primerApellidoField.getText(), segundoApellidoField.getText(), correoField.getText(), telefonoField.getText(), passwordField.getText(), rolField.getText());
                bl.agregarTecnico(tecnico);
                JOptionPane.showMessageDialog(frame, "Técnico agregado exitosamente!");
            }
        });

        // Acción para agregar Administrador
        agregarAdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar la lógica para agregar un administrador
                JOptionPane.showMessageDialog(frame, "Administrador agregado exitosamente!");
            }
        });

        frame.setVisible(true);
    }
}