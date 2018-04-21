package xpmxp1.tenderstar.app_objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by sebastian on 4/21/18.
 */


@Entity(tableName = "ProductRatin",
        primaryKeys = {"ProductID", "CustomerID"},
        foreignKeys = {@ForeignKey(entity = Customer.class,
        parentColumns = "CustomerID",
        childColumns = "CustomerID",
        onDelete = CASCADE),
@ForeignKey(entity = Product.class,
        parentColumns = "ProductID",
        childColumns = "ProductID",
        onDelete = CASCADE)})
public class ProductRating {
    @ColumnInfo(name = "ProductID")
    private int productId;
    @ColumnInfo(name = "CustomerID")
    private int customerId;
    @ColumnInfo(name = "Rating")
    private int rating;
    @ColumnInfo(name = "Comment")
    private String comment;

    public ProductRating(int rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
