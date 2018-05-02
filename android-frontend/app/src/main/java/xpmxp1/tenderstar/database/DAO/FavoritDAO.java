package xpmxp1.tenderstar.database.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

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

    @Query("DELETE FROM Favorit")
    public void nukeTable();
}
