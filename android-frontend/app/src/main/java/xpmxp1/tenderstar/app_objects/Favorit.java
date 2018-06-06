package xpmxp1.tenderstar.app_objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "Favorit",
        primaryKeys = {"CustomerID", "StoreID"},
        foreignKeys = {@ForeignKey(entity = Customer.class,
        parentColumns = "CustomerID",
        childColumns = "CustomerID",
        onDelete = CASCADE),
        @ForeignKey(entity = Store.class,
        parentColumns = "StoreID",
        childColumns = "StoreID",
        onDelete = CASCADE)},
        indices = {@Index("StoreID"), @Index("CustomerID")})
public class Favorit {
    @ColumnInfo(name = "CustomerID")
    private long customerId;
    @ColumnInfo(name = "StoreID")
    private long storeId;

    public Favorit(long customerId, long storeId) {
        this.customerId = customerId;
        this.storeId = storeId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public long getStoreId() {
        return storeId;
    }

}
