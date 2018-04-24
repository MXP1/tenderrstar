package xpmxp1.tenderstar.database.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import xpmxp1.tenderstar.app_objects.StoreRating;

/**
 * Created by sebastian on 4/21/18.
 */


@Dao
public interface StoreRatingDAO {
    @Insert
    public long insertStoreRating(StoreRating storeRating);

    @Update
    public void updateStoreRating(StoreRating storeRating);

    @Delete
    public void deleteStoreRating(StoreRating storeRating);
}
