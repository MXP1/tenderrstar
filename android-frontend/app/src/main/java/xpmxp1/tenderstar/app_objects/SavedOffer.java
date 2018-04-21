package xpmxp1.tenderstar.app_objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
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
        onDelete = CASCADE)})
public class SavedOffer {
    @ColumnInfo(name = "CustomerID")
    private int customerId;
    @ColumnInfo(name = "ProductID")
    private int productId;

    //TODO?
    public SavedOffer() {}

    public int getCustomerId() {
        return customerId;
    }

    //Do not use this Setter!!!
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    //Do not use this Setter!!!
    public void setProductId(int productId) {
        this.productId = productId;
    }
}
