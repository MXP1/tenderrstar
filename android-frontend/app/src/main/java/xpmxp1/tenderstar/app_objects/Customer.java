package xpmxp1.tenderstar.app_objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;


@Entity (tableName = "Customer")
public class Customer {
    @PrimaryKey
    @ColumnInfo(name = "CustomerID")
    private int id;
    @ColumnInfo(name = "Username")
    private String username;
    @ColumnInfo(name = "Password")
    private String password;
    @ColumnInfo(name = "EMail")
    private String email;

    @Ignore
    private static int nextId = 0;
    @Ignore
    private static int getNextId() {
        return ++nextId;
    }

    public Customer(String username, String password, String email) {
        this.id = getNextId();
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    //DO NOT USE THIS SETTER!!!
    public void setId(int id) {
        //this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
