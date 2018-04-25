package xpmxp1.tenderstar.app_objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by dominik on 21.03.18.
 */


@Entity(tableName = "Tag")
public class Tag {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "TagID")
    private long id;
    @ColumnInfo(name = "Name")
    public String name;


    public Tag(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
