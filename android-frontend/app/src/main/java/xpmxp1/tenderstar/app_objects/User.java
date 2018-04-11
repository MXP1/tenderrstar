package xpmxp1.tenderstar.app_objects;

/**
 * Created by Rene Hasenburger on 11.04.2018.
 */

public class User {

    private int id;
    private String benutzername;
    private String passwort;

    public User(String benutzername, String passwort) {
        this.benutzername = benutzername;
        this.passwort = passwort;
    }

    public int getId() {
        return id;
    }

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }





}
