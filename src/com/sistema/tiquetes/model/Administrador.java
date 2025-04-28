package com.sistema.tiquetes.model;

public class Administrador extends Usuario {
    private boolean estado; // true for active, false for inactive

    public Administrador(String codigo, String nombre, String primerApellido, String segundoApellido, String correo, String telefono, String password, boolean estado) {
        super(codigo, nombre, primerApellido, segundoApellido, correo, telefono, password);
        this.estado = estado;
    }

    // Getters and Setters
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isActivo() {
        return estado; // true means active
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", estado=" + estado +
                '}';
    }
}