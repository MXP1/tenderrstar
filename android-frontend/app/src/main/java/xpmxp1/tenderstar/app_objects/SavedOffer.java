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
    private int customerId;
    @ColumnInfo(name = "ProductID")
    private int productId;

    public SavedOffer(int customerId, int productId) {
        this.customerId = customerId;
        this.productId = productId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getProductId() {
        return productId;
    }
}
