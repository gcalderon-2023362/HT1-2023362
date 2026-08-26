package org.gc.system.repository;

import java.sql.CallableStatement;
import java.sql.SQLException;
import org.gc.system.config.ConexionDB;
import org.gc.system.model.User;

public class UserRepository implements UserInterface {

    private CallableStatement callSP;
    private ConexionDB conexionDB = ConexionDB.getInstanciaConexionDB();

    @Override
    public void create(User user) {

        try {

            callSP = conexionDB.getConnection()
                    .prepareCall("{call sp_create_users(?,?,?,?,?)}");

            callSP.setString(1, user.getName());
            callSP.setString(2, user.getLastname());
            callSP.setString(3, user.getEmail());
            callSP.setString(4, user.getUser());
            callSP.setString(5, user.getPassword());

            callSP.execute();

            System.out.println("Usuario creado correctamente.");

            callSP.close();

        } catch (SQLException e) {

            System.out.println("ERROR AL CREAR EL USUARIO");
            System.out.println("Mensaje de MySQL: " + e.getMessage());
            e.printStackTrace();
        }
    }
}