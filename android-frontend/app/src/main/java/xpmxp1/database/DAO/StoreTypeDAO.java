package xpmxp1.database.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import xpmxp1.tenderstar.app_objects.StoreType;

/**
 * Created by sebastian on 4/21/18.
 */

@Dao
public interface StoreTypeDAO {
    @Insert
    public long insertStoreType(StoreType storeType);

    @Update
    public void updateStoreType(StoreType storeType);

    @Delete
    public void deleteStoreType(StoreType storeType);

    //@Query("SELECT * FROM StoreType")
    //public List<StoreType> getAllAddresses();

    //Query with Parameters
    //@Query("SELECT * FROM user WHERE age > :minAge")
    //public User[] loadAllUsersOlderThan(int minAge);
}
