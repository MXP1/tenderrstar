package xpmxp1.tenderstar.app_objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by sebastian on 4/21/18.
 */

@Entity(tableName = "StoreRating",
        primaryKeys = {"StoreID", "CustomerID"},
        foreignKeys = {@ForeignKey(entity = Customer.class,
            parentColumns = "CustomerID",
            childColumns = "CustomerID",
            onDelete = CASCADE),
        @ForeignKey(entity = Store.class,
            parentColumns = "StoreID",
            childColumns = "StoreID",
            onDelete = CASCADE)},
            indices = {@Index("StoreID"), @Index("CustomerID")})
public class StoreRating {
    @ColumnInfo(name = "StoreID")
    private long storeId;
    @ColumnInfo(name = "CustomerID")
    private long customerId;
    @ColumnInfo(name = "Rating")
    private int rating;
    @ColumnInfo(name = "Comment")
    private String comment;

    public StoreRating(long storeId, long customerId, int rating, String comment) {
        this.storeId = storeId;
        this.customerId = customerId;

        setRating(rating);
        setComment(comment);
    }

    public long getStoreId() {
        return storeId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
