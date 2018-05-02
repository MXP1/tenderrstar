package xpmxp1.tenderstar.database.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import xpmxp1.tenderstar.app_objects.ProductCategory;

/**
 * Created by Rene Hasenburger on 02.05.2018.
 */

@Dao
public interface ProductCategoryDAO {
    @Insert
    public long insertCategory(ProductCategory category);

    @Update
    public void updateCategory(ProductCategory category);

    @Delete
    public void deleteCategory(ProductCategory category);

    @Query("DELETE FROM Category")
    public void nukeTable();

    @Query("SELECT Name FROM Category WHERE ID = :categoryId")
    public String getCategoryForProduct(long categoryId);
}
