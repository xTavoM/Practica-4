package com.sistema.tiquetes.model;

import java.util.Date;

public class SolicitudCambio extends Tiquete {
    private Date fechaRequerida;
    private Date fechaEjecucion;

    public SolicitudCambio(String codigo, String descripcion, Creador usuarioCreador, Date fechaRequerida) {
        super(codigo, descripcion, usuarioCreador);
        this.fechaRequerida = fechaRequerida;
        this.fechaEjecucion = null; // Initialize as null
    }

    public void ejecutarCambio() {
        this.fechaEjecucion = new Date(); // Set the current date as the execution date
    }

    @Override
    public String toString() {
        return "SolicitudCambio{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaRequerida=" + fechaRequerida +
                ", fechaEjecucion=" + fechaEjecucion +
                '}';
    }
}