package org.gc.system.model;

/**
 *
 * @author informatica
 */
public class User {

    private String id_user;
    private String email;
    private String name;
    private String lastname;
    private String password;
    private String user;

    public User() {
    }

    public User(String id_user, String email, String name, String lastname,
            String password, String user) {
        this.id_user = id_user;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.user = user;
    }

    /*
     * Constructor utilizado para crear un nuevo usuario.
     * El orden coincide con UserService.
     */
    public User(String password, String email, String name,
            String lastname, String user) {

        this.password = password;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.user = user;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}