package xpmxp1.tenderstar.app_objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

/**
 * Created by dominik on 21.03.18.
 */

@Entity(tableName = "Store")
public class Store {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "StoreID")
    private long id;
    @ColumnInfo(name = "Username")
    private String username;
    @ColumnInfo(name = "Password")
    private String password;
    @ColumnInfo(name = "StoreName")
    private String storeName;
    @ColumnInfo(name = "Link")
    private String link;
    @ColumnInfo(name = "StoreTypeID")
    private int storeTypeID;
    @ColumnInfo(name = "OpeningHours")
    private OpeningHours openingHours;
    @ColumnInfo(name = "Address")
    private String address;
    @ColumnInfo(name = "PostalCode")
    private String postalCode;

    public Store(String username, String password, String storeName, String link, int storeTypeID, OpeningHours openingHours, String address, String postalCode) {
        this.username = username;
        this.password = password;
        this.storeName = storeName;
        this.link = link;
        this.storeTypeID = storeTypeID;
        this.openingHours = openingHours;
        this.address = address;
        this.postalCode = postalCode;
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

    public int getStoreTypeID() {
        return storeTypeID;
    }

    public void setStoreTypeID(int storeTypeID) {
        this.storeTypeID = storeTypeID;
    }


    public OpeningHours getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(OpeningHours openingHours) {
        this.openingHours = openingHours;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Ignore
    public List<Product> products;
}
