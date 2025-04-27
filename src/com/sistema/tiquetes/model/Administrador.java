package com.sistema.tiquetes.model;

public class Administrador extends Usuario {
    private boolean estadoActivo;

    public Administrador(String codigo, String nombre, String primerApellido, String segundoApellido, String correoElectronico, String telefono, String password, boolean estadoActivo) {
        super(codigo, nombre, primerApellido, segundoApellido, correoElectronico, telefono, password);
        this.estadoActivo = estadoActivo;
    }

    @Override
    public String toString() {
        return super.toString() + ", estadoActivo=" + estadoActivo + '}';
    }
}
