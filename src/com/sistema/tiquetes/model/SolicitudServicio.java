package com.sistema.tiquetes.model;

import java.util.Date;

public class SolicitudServicio extends Tiquete {
    private int prioridad;
    private Date fechaEjecucion;

    public SolicitudServicio(String codigo, String descripcion, Creador usuarioCreador, int prioridad) {
        super(codigo, descripcion, usuarioCreador);
        this.prioridad = prioridad;
        this.fechaEjecucion = null; // Initialize as null
    }

    public void ejecutarServicio() {
        this.fechaEjecucion = new Date(); // Set the current date as the execution date
    }

    @Override
    public String toString() {
        return "SolicitudServicio{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", prioridad=" + prioridad +
                ", fechaEjecucion=" + fechaEjecucion +
                '}';
    }
}