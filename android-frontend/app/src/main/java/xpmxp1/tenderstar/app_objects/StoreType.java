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
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "StoreTypeID")
    private long id;
    @ColumnInfo(name = "Type")
    private String type;

    public StoreType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
