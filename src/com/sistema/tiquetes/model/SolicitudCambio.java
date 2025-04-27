package com.sistema.tiquetes.model;

import java.util.Date;

public class SolicitudCambio extends Tiquete {
    private Date fechaRequerida;

    public SolicitudCambio(String codigo, String descripcion, Creador usuarioCreador, Date fechaRequerida) {
        super(codigo, descripcion, usuarioCreador);
        this.fechaRequerida = fechaRequerida;
    }
}