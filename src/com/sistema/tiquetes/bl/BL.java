package com.sistema.tiquetes.bl;

import com.sistema.tiquetes.model.Administrador;
import com.sistema.tiquetes.model.Creador;
import com.sistema.tiquetes.model.Tecnico;

import java.util.ArrayList;
import java.util.List;

public class BL {
    private List<Creador> creadores = new ArrayList<>();
    private List<Tecnico> tecnicos = new ArrayList<>();
    private List<Administrador> administradores = new ArrayList<>();

    public void agregarCreador(Creador creador) {
        creadores.add(creador);
    }

    public void agregarTecnico(Tecnico tecnico) {
        tecnicos.add(tecnico);
    }

    public void agregarAdministrador(Administrador administrador) {
        administradores.add(administrador);
    }

    // Additional methods for listing, modifying, and deleting users can be added here
}