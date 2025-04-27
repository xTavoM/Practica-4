package com.sistema.tiquetes.model;

public abstract class Usuario {
    protected String codigo;
    protected String nombre;
    protected String primerApellido;
    protected String segundoApellido;
    protected String correoElectronico;
    protected String telefono;
    protected String password;

    public Usuario(String codigo, String nombre, String primerApellido, String segundoApellido, String correoElectronico, String telefono, String password) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}