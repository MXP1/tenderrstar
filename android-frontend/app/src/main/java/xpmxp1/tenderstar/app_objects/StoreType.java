package xpmxp1.tenderstar.app_objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by sebastian on 4/21/18.
 */

@Entity(tableName = "StoreType")
public class StoreType
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "StoreTypeID")
    private int id;
    @ColumnInfo(name = "Type")
    private String type;

    public StoreType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    //DO NOT USE THIS SETTER!!!
    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
