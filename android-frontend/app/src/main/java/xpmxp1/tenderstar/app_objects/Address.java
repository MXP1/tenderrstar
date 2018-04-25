package xpmxp1.tenderstar.app_objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by sebastian on 4/18/18.
 */

@Entity(tableName = "Address")
public class Address {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "AddressID")
    private long addressId;
    @ColumnInfo(name = "ZIP")
    private int zip;
    @ColumnInfo(name = "TownName")
    private String townName;
    @ColumnInfo(name = "StreetName")
    private String streetName;

    public Address(int zip, String townName, String streetName) {
        this.zip = zip;
        this.townName = townName;
        this.streetName = streetName;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}
