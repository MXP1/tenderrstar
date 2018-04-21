package xpmxp1.database.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import xpmxp1.tenderstar.app_objects.ProductRating;

/**
 * Created by sebastian on 4/21/18.
 */

@Dao
public interface ProductRatingDAO {
    @Insert
    public long insertProductRating(ProductRating productRating);

    @Update
    public void updateProductRating(ProductRating productRating);

    @Delete
    public void deleteProductRating(ProductRating productRating);
}
