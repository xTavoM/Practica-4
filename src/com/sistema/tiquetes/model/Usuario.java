package com.sistema.tiquetes.model;

public abstract class Usuario {
    protected String codigo;
    protected String nombre;
    protected String primerApellido;
    protected String segundoApellido;
    protected String correo; // Ensure this is declared correctly
    protected String telefono;
    protected String password; // Correct declaration of password

    public Usuario(String codigo, String nombre, String primerApellido, String segundoApellido, String correo, String telefono, String password) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.correo = correo; // Assigning to the class variable
        this.telefono = telefono; // Correctly assigning telefono
        this.password = password; // Correctly assigning password
    }

    // Getters and Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCorreo() {
        return correo; // Getter for correo
    }

    public void setCorreo(String correo) {
        this.correo = correo; // Setter for correo
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}