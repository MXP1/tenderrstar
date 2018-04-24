package xpmxp1.tenderstar.app_objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by sebastian on 4/21/18.
 */

@Entity(tableName = "StoreType")
public class StoreType
{
    @PrimaryKey
    @ColumnInfo(name = "StoreTypeID")
    private int id;
    @ColumnInfo(name = "Type")
    private String type;

    @Ignore
    private static int nextId = 0;
    @Ignore
    private static int getNextId() {
        return ++nextId;
    }

    public StoreType(String type) {
        this.id = getNextId();
        this.type = type;
    }

    public int getId() {
        return id;
    }

    //DO NOT USE THIS SETTER!!!
    public void setId(int id) {
        //this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
