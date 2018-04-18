package xpmxp1.database.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import xpmxp1.tenderstar.app_objects.Store;

/**
 * Created by sebastian on 4/18/18.
 */

@Dao
public interface StoreDAO {
    @Insert
    public long insertStore(Store store);

    @Update
    public void updateStore(Store store);

    @Delete
    public void deleteStore(Store store);

    @Query("SELECT * FROM Store")
    public List<Store> getAllStores();

    //Query with Parameters
    //@Query("SELECT * FROM user WHERE age > :minAge")
    //public User[] loadAllUsersOlderThan(int minAge);
}
