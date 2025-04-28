package com.sistema.tiquetes.model;

public class Tecnico extends Usuario {
    private String rol;

    public Tecnico(String codigo, String nombre, String primerApellido, String segundoApellido, String correo, String telefono, String password, String rol) {
        super(codigo, nombre, primerApellido, segundoApellido, correo, telefono, password);
        this.rol = rol;
    }

    // Getters and Setters
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}