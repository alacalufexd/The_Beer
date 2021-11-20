package Clases;

import java.util.Objects;

public class administrador {
    private int id;
    private String user;
    private String pass;

    public administrador()
    {
        user ="Alacalufe";
        pass ="1234567890";

    }

    public administrador(int id, String user, String pass) {
        this.id = id;
        this.user = user;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        administrador that = (administrador) o;
        return id == that.id && Objects.equals(user, that.user) && Objects.equals(pass, that.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, pass);
    }

    @Override
    public String toString() {
        return "administrador{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
