package xpmxp1.database.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import xpmxp1.tenderstar.app_objects.SavedOffer;

/**
 * Created by sebastian on 4/21/18.
 */

@Dao
public interface SavedOfferDAO {
    @Insert
    public long insertSavedOffer(SavedOffer savedOffer);

    @Update
    public void updateSavedOffer(SavedOffer savedOffer);

    @Delete
    public void deleteSavedOffer(SavedOffer savedOffer);
}