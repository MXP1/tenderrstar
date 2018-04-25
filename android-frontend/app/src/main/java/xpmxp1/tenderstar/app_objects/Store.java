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
    @ColumnInfo(name = "StoreTypeID")
    private int storeTypeID;
    @ColumnInfo(name = "LocationID")
    private int locationID;
    @ColumnInfo(name = "OpenHours")
    private String openHours;

    public Store(String username, String password, String storeName, int storeTypeID, int locationID, String openHours) {
        this.username = username;
        this.password = password;
        this.storeName = storeName;
        this.storeTypeID = storeTypeID;
        this.locationID = locationID;
        this.openHours = openHours;
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

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }


    public String getOpenHours() {
        return openHours;
    }

    public void setOpenHours(String openHours) {
        this.openHours = openHours;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Ignore
    public List<Product> products;
}
