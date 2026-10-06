package com.mycompany.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Database {
    
    protected Connection conexion;
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost/pruebas";
    
    private final String USER = "root";
    private final String PASS = "";
    
    
    public Connection Conectar() {
        try {
            Class.forName(JDBC_DRIVER); // ya no se lanza la excepción
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }

    public void Cerrar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    /*
    public void Conectar() throws ClassNotFoundException {
        try {
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);
            Class.forName(JDBC_DRIVER);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Cerrar() throws SQLException{
        if (conexion != null) {
            if (!conexion.isClosed()) {
                conexion.close();
            }
        }
    }
    */
}
/*

*/