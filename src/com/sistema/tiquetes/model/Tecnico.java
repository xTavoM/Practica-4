package com.sistema.tiquetes.model;

public class Tecnico extends Usuario {
    private String rol;

    public Tecnico(String codigo, String nombre, String primerApellido, String segundoApellido, String correoElectronico, String telefono, String password, String rol) {
        super(codigo, nombre, primerApellido, segundoApellido, correoElectronico, telefono, password);
        this.rol = rol;
    }

    @Override
    public String toString() {
        return super.toString() + ", rol=" + rol + '}';
    }
}
