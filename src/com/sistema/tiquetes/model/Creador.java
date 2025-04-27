package com.sistema.tiquetes.model;

public class Creador extends Usuario {
    private String departamento;

    public Creador(String codigo, String nombre, String primerApellido, String segundoApellido, String correoElectronico, String telefono, String password, String departamento) {
        super(codigo, nombre, primerApellido, segundoApellido, correoElectronico, telefono, password);
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return super.toString() + ", departamento=" + departamento + '}';
    }
}
