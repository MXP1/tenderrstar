package xpmxp1.database.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import xpmxp1.tenderstar.app_objects.Address;
import xpmxp1.tenderstar.app_objects.Favorit;

/**
 * Created by sebastian on 4/18/18.
 */

@Dao
public interface FavoritDAO {
    @Insert
    public long insertFavorit(Favorit favorit);

    @Update
    public void updateFavorit(Favorit favorit);

    @Delete
    public void deleteFavorit(Favorit favorit);

    //@Query("SELECT * FROM Address")
    //public List<Address> getAllAddresses();
}
