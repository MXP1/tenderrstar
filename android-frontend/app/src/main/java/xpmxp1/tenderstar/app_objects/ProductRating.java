package xpmxp1.tenderstar.app_objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

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
        onDelete = CASCADE)},
        indices = {@Index("CustomerID"), @Index("ProductID")})
public class ProductRating {
    @ColumnInfo(name = "ProductID")
    private long productId;
    @ColumnInfo(name = "CustomerID")
    private long customerId;
    @ColumnInfo(name = "Rating")
    private int rating;
    @ColumnInfo(name = "Comment")
    private String comment;

    public ProductRating(long productId, long customerId, int rating, String comment) {
        this.productId = productId;
        this.customerId = customerId;
        this.rating = rating;
        this.comment = comment;
    }

    public long getProductId() {
        return productId;
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
