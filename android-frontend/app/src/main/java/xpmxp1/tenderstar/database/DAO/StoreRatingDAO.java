package xpmxp1.tenderstar.database.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

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

    @Query("DELETE FROM StoreRating")
    public void nukeTable();

    @Query("SELECT * FROM StoreRating WHERE StoreID = :storeId")
    public List<StoreRating> getRatingForStore(long storeId);
}
