package com.sistema.tiquetes.model;

public class Incidente extends Tiquete {
    private String descripcionSolucion;

    public Incidente(String codigo, String descripcion, Creador usuarioCreador) {
        super(codigo, descripcion, usuarioCreador);
    }

    public void resolver(String descripcionSolucion) {
        this.descripcionSolucion = descripcionSolucion;
        this.estado = "Resuelto";
    }
}
