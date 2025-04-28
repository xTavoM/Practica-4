package com.sistema.tiquetes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/com_sistema_tiquetes";
    private static final String USER = "root"; // tu usuario de MySQL
    private static final String PASSWORD = "Andres2006"; // tu contraseña de MySQL

    public static Connection conectar() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("¡Conexión exitosa a la base de datos!");
            return connection;
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            return null;
        }
    }
}
