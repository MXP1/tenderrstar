package xpmxp1.tenderstar.app_objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by sebastian on 4/21/18.
 */

@Entity(tableName = "SavedOffers",
        primaryKeys = {"CustomerID", "ProductID"},
        foreignKeys = {@ForeignKey(entity = Customer.class,
        parentColumns = "CustomerID",
        childColumns = "CustomerID",
        onDelete = CASCADE),
        @ForeignKey(entity = Product.class,
        parentColumns = "ProductID",
        childColumns = "ProductID",
        onDelete = CASCADE)},
        indices = {@Index("CustomerID"), @Index("ProductID")})
public class SavedOffer {
    @ColumnInfo(name = "CustomerID")
    private long customerId;
    @ColumnInfo(name = "ProductID")
    private long productId;

    public SavedOffer(long customerId, long productId) {
        this.customerId = customerId;
        this.productId = productId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public long getProductId() {
        return productId;
    }
}
