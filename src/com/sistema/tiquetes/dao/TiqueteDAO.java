package com.sistema.tiquetes.dao;

import com.sistema.tiquetes.dao.Conexion; // IMPORTANTE: importar tu clase ConexionDB
import com.sistema.tiquetes.model.Tiquete;
import com.sistema.tiquetes.model.Incidente;
import com.sistema.tiquetes.model.SolicitudCambio;
import com.sistema.tiquetes.model.SolicitudServicio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TiqueteDAO {
    private Connection connection;

    // NUEVO: Instanciar la conexión automáticamente
    public TiqueteDAO() {
        this.connection = Conexion.conectar();
    }

    public void agregarTiquete(Tiquete tiquete) throws SQLException {
        String sql = "INSERT INTO tiquetes (codigo, descripcion, estado, tipo, usuarioCreadorCodigo, usuarioTecnicoCodigo) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, tiquete.getCodigo());
            stmt.setString(2, tiquete.getDescripcion());
            stmt.setString(3, tiquete.getEstado());
            stmt.setString(4, tiquete instanceof Incidente ? "Incidente" : (tiquete instanceof SolicitudCambio ? "SolicitudCambio" : "SolicitudServicio"));
            stmt.setString(5, tiquete.getUsuarioCreador().getCodigo());
            stmt.setString(6, tiquete.getUsuarioTecnicoAsignado() != null ? tiquete.getUsuarioTecnicoAsignado().getCodigo() : null);
            stmt.executeUpdate();
        }
    }

    public List<Tiquete> obtenerTiquetes() throws SQLException {
        List<Tiquete> tiquetes = new ArrayList<>();
        String sql = "SELECT * FROM tiquetes";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Tiquete tiquete = null;
                String tipo = rs.getString("tipo");
                if ("Incidente".equals(tipo)) {
                    tiquete = new Incidente(
                            rs.getString("codigo"),
                            rs.getString("descripcion"),
                            null, // usuarioCreador
                            null  // usuarioTecnicoAsignado
                    );
                }
                // Podrías agregar también para SolicitudCambio y SolicitudServicio
                tiquetes.add(tiquete);
            }
        } catch (Exception e) {
            System.out.println("Error conectando a la base de datos: " + e.getMessage());
        }
        return tiquetes;
    }
}
