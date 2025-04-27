package com.sistema.tiquetes.model;

import java.util.Date;

public abstract class Tiquete {
    protected String codigo;
    protected String descripcion;
    protected Creador usuarioCreador;
    protected Tecnico usuarioTecnicoAsignado;
    protected String estado;
    protected Date fechaSolucion;

    public Tiquete(String codigo, String descripcion, Creador usuarioCreador) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.usuarioCreador = usuarioCreador;
        this.estado = "Creado";
    }

    public void agregarNota(String nota) {
        // Lógica para agregar nota
    }

    @Override
    public String toString() {
        return "Tiquete{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
