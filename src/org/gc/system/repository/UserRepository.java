package org.gc.system.repository;

import org.gc.system.model.User;
import org.gc.system.config.ConexionDB;
import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 *
 *
 *
 * @author informatica
 *
 */
public class UserRepository implements UserInterface {

    //CallableStatement
    private CallableStatement callSP;
    //conexionDB
    private ConexionDB conexionDB = ConexionDB.getInstanciaConexionDB();

    @Override
    public void create(User user) {
        try {
            callSP = conexionDB.getConnection().prepareCall("{call sp_create_users(?,?,?,?,?)}");
            callSP.setString(1, user.getName());
            callSP.setString(2, user.getLastname());
            callSP.setString(3, user.getEmail());
            callSP.setString(4, user.getUser());
            callSP.setString(5, user.getPassword());
            callSP.execute();
            callSP.close();//Liberar los recursos utilizados
        } catch (SQLException e) {

            System.out.println("ERROR AL CREAR EL USUARIO");
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }
}
