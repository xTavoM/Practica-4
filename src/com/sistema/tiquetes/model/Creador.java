package com.sistema.tiquetes.model;

public class Creador extends Usuario {
    private String departamento;

    public Creador(String codigo, String nombre, String primerApellido, String segundoApellido, String correo, String telefono, String password, String departamento) {
        super(codigo, nombre, primerApellido, segundoApellido, correo, telefono, password);
        this.departamento = departamento;
    }

    // Getters and Setters
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Creador{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", departamento='" + departamento + '\'' +
                '}';
    }
}
