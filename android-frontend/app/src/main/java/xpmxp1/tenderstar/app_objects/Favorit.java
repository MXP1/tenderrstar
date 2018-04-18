package xpmxp1.tenderstar.app_objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by sebastian on 4/18/18.
 */

@Entity(tableName = "Favorit",
        primaryKeys = {"CustomerID", "StoreID"},
        foreignKeys = {@ForeignKey(entity = Customer.class,
        parentColumns = "CustomerID",
        childColumns = "CustomerID",
        onDelete = CASCADE),
        @ForeignKey(entity = Store.class,
        parentColumns = "StoreID",
        childColumns = "StoreID",
        onDelete = CASCADE)})
public class Favorit {
    @ColumnInfo(name = "CustomerID")
    private int customerId;
    @ColumnInfo(name = "StoreID")
    private int storeId;
}
