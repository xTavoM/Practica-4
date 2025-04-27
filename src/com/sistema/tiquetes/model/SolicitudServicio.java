package com.sistema.tiquetes.model;

public class SolicitudServicio extends Tiquete {
    private int prioridad;

    public SolicitudServicio(String codigo, String descripcion, Creador usuarioCreador, int prioridad) {
        super(codigo, descripcion, usuarioCreador);
        this.prioridad = prioridad;
    }
}