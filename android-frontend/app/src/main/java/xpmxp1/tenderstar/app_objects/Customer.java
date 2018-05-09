package xpmxp1.tenderstar.app_objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;


@Entity (tableName = "Customer")
public class Customer {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "CustomerID")
    private long id;
    @ColumnInfo(name = "Username")
    private String username;
    @ColumnInfo(name = "Password")
    private String password;
    @ColumnInfo(name = "EMail")
    private String email;

    public Customer(String username, String password, String email) {
        setUsername(username);
        setPassword(password);
        setEmail(email);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
