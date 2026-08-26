package org.gc.system.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static ConexionDB instanciaConexionDB;
    private Connection connection;

    private ConexionDB() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://"
                    + Enviroment.LOCATION_SERVICE
                    + "/"
                    + Enviroment.DATA_BASE,
                    Enviroment.USER,
                    Enviroment.PASSWORD
            );

            System.out.println("Conexion a MySQL realizada correctamente.");

        } catch (ClassNotFoundException e) {

            System.out.println("ERROR: No se encontro el driver de MySQL.");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("ERROR DE CONEXION CON MYSQL.");
            e.printStackTrace();

        } catch (Exception e) {

            System.out.println("ERROR GENERAL:");
            e.printStackTrace();
        }
    }

    public static ConexionDB getInstanciaConexionDB() {

        if (instanciaConexionDB == null) {
            instanciaConexionDB = new ConexionDB();
        }

        return instanciaConexionDB;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}