package com.sistema.tiquetes.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Tiquete {
    protected String codigo;
    protected String descripcion;
    protected Creador usuarioCreador;
    protected Tecnico usuarioTecnicoAsignado;
    protected String estado;
    protected Date fechaSolucion;
    protected List<String> notas;

    public Tiquete(String codigo, String descripcion, Creador usuarioCreador) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.usuarioCreador = usuarioCreador;
        this.estado = "Creado";
        this.notas = new ArrayList<>();
    }

    // Métodos get
    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Creador getUsuarioCreador() {
        return usuarioCreador;
    }

    public Tecnico getUsuarioTecnicoAsignado() {
        return usuarioTecnicoAsignado;
    }

    public String getEstado() {
        return estado;
    }

    public Date getFechaSolucion() {
        return fechaSolucion;
    }

    public List<String> getNotas() {
        return notas;
    }

    public void agregarNota(String nota) {
        notas.add(nota);
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void asignarTecnico(Tecnico tecnico) {
        this.usuarioTecnicoAsignado = tecnico;
    }

    @Override
    public String toString() {
        return "Tiquete{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", notas=" + notas +
                '}';
    }
}