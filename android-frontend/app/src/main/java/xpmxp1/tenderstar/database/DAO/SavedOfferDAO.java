package xpmxp1.tenderstar.database.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import xpmxp1.tenderstar.app_objects.Product;
import xpmxp1.tenderstar.app_objects.SavedOffer;

/**
 * Created by sebastian on 4/21/18.
 */

@Dao
public interface SavedOfferDAO {
    @Insert
    public long insertSavedOffer(SavedOffer savedOffer);

    @Delete
    public void deleteSavedOffer(SavedOffer savedOffer);

    @Query("DELETE FROM SavedOffer")
    public void nukeTable();

    @Query("SELECT Product.* FROM SavedOffer INNER JOIN Customer ON Customer.CustomerID = SavedOffer.CustomerID INNER JOIN Product ON Product.ProductID = SavedOffer.ProductID WHERE SavedOffer.CustomerID = :customerId ")
    public List<Product> getSavedOffersForCustomer(long customerId);
}