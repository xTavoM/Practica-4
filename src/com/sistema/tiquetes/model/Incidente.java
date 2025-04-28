package com.sistema.tiquetes.model;

import java.util.Date;

public class Incidente extends Tiquete {
    private String descripcionSolucion;
    private Tecnico usuarioTecnicoAsignado;
    private Date fechaSolucion;

    public Incidente(String codigo, String descripcion, Creador usuarioCreador, Tecnico usuarioTecnicoAsignado) {
        super(codigo, descripcion, usuarioCreador);
        this.usuarioTecnicoAsignado = usuarioTecnicoAsignado;
    }

    public void resolver(String descripcionSolucion) {
        this.descripcionSolucion = descripcionSolucion;
        this.estado = "Resuelto";
        this.fechaSolucion = new Date(); // Set the current date as the solution date
    }

    @Override
    public String toString() {
        return "Incidente{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", descripcionSolucion='" + descripcionSolucion + '\'' +
                ", fechaSolucion=" + fechaSolucion +
                '}';
    }
}
