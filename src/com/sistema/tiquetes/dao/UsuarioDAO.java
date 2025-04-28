package com.sistema.tiquetes.dao;

import com.sistema.tiquetes.dao.Conexion;
import com.sistema.tiquetes.model.Usuario;
import com.sistema.tiquetes.model.Administrador;
import com.sistema.tiquetes.model.Creador;
import com.sistema.tiquetes.model.Tecnico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Connection connection;

    // NUEVO: conectar automáticamente en el constructor
    public UsuarioDAO() {
        this.connection = Conexion.conectar();
    }

    // Crear un nuevo usuario
    public void agregarUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (codigo, nombre, primerApellido, segundoApellido, correo, telefono, password, tipo, estado, departamento, rol) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getCodigo());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getPrimerApellido());
            stmt.setString(4, usuario.getSegundoApellido());
            stmt.setString(5, usuario.getCorreo());
            stmt.setString(6, usuario.getTelefono());
            stmt.setString(7, usuario.getPassword());

            if (usuario instanceof Administrador) {
                stmt.setString(8, "Administrador");
                stmt.setBoolean(9, ((Administrador) usuario).isEstado());
                stmt.setNull(10, Types.VARCHAR); // corregido, departamento es VARCHAR
                stmt.setNull(11, Types.VARCHAR); // corregido, rol es VARCHAR
            } else if (usuario instanceof Creador) {
                stmt.setString(8, "Creador");
                stmt.setNull(9, Types.BOOLEAN);
                stmt.setString(10, ((Creador) usuario).getDepartamento());
                stmt.setNull(11, Types.VARCHAR);
            } else if (usuario instanceof Tecnico) {
                stmt.setString(8, "Tecnico");
                stmt.setNull(9, Types.BOOLEAN);
                stmt.setNull(10, Types.VARCHAR);
                stmt.setString(11, ((Tecnico) usuario).getRol());
            }

            stmt.executeUpdate();
        }
    }

    // Listar todos los usuarios
    public List<Usuario> obtenerUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String tipo = rs.getString("tipo");
                Usuario usuario = null;
                if ("Administrador".equals(tipo)) {
                    usuario = new Administrador(
                            rs.getString("codigo"),
                            rs.getString("nombre"),
                            rs.getString("primerApellido"),
                            rs.getString("segundoApellido"),
                            rs.getString("correo"),
                            rs.getString("telefono"),
                            rs.getString("password"),
                            rs.getBoolean("estado")
                    );
                } else if ("Creador".equals(tipo)) {
                    usuario = new Creador(
                            rs.getString("codigo"),
                            rs.getString("nombre"),
                            rs.getString("primerApellido"),
                            rs.getString("segundoApellido"),
                            rs.getString("correo"),
                            rs.getString("telefono"),
                            rs.getString("password"),
                            rs.getString("departamento")
                    );
                } else if ("Tecnico".equals(tipo)) {
                    usuario = new Tecnico(
                            rs.getString("codigo"),
                            rs.getString("nombre"),
                            rs.getString("primerApellido"),
                            rs.getString("segundoApellido"),
                            rs.getString("correo"),
                            rs.getString("telefono"),
                            rs.getString("password"),
                            rs.getString("rol")
                    );
                }
                if (usuario != null) {
                    usuarios.add(usuario);
                }
            }
        }
        return usuarios;
    }

    // Modificar un usuario existente
    public void actualizarUsuario(Usuario usuario) throws SQLException {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }

        String sql = "UPDATE usuarios SET nombre=?, primerApellido=?, segundoApellido=?, correo=?, telefono=?, password=?, estado=?, departamento=?, rol=? WHERE codigo=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getPrimerApellido());
            stmt.setString(3, usuario.getSegundoApellido());
            stmt.setString(4, usuario.getCorreo());
            stmt.setString(5, usuario.getTelefono());
            stmt.setString(6, usuario.getPassword());

            if (usuario instanceof Administrador) {
                stmt.setBoolean(7, ((Administrador) usuario).isEstado());
                stmt.setNull(8, Types.VARCHAR);
                stmt.setNull(9, Types.VARCHAR);
            } else if (usuario instanceof Creador) {
                stmt.setNull(7, Types.BOOLEAN);
                stmt.setString(8, ((Creador) usuario).getDepartamento());
                stmt.setNull(9, Types.VARCHAR);
            } else if (usuario instanceof Tecnico) {
                stmt.setNull(7, Types.BOOLEAN);
                stmt.setNull(8, Types.VARCHAR);
                stmt.setString(9, ((Tecnico) usuario).getRol());
            }

            stmt.setString(10, usuario.getCodigo());
            stmt.executeUpdate();
        }
    }

    // Eliminar un usuario
    public void eliminarUsuario(String codigo) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE codigo=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            stmt.executeUpdate();
        }
    }
}
