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

    @Update
    public void updateSavedOffer(SavedOffer savedOffer);

    @Delete
    public void deleteSavedOffer(SavedOffer savedOffer);

    //TODO:TEST!!!
    @Query("SELECT Product.* FROM SavedOffers INNER JOIN Customer ON Customer.CustomerID = SavedOffers.CustomerID INNER JOIN Product ON Product.ProductID = SavedOffers.ProductID WHERE SavedOffers.CustomerID = :customerId ")
    public List<Product> getSavedOffersForCustomer(int customerId);
}