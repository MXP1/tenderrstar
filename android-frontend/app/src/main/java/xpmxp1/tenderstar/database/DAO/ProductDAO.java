package xpmxp1.tenderstar.database.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import xpmxp1.tenderstar.app_objects.Product;

@Dao
public interface ProductDAO {
    @Insert
    public long insertProduct(Product product);

    @Update
    public void updateProduct(Product product);

    @Delete
    public void deleteProduct(Product product);

    @Query("SELECT * FROM Product")
    public List<Product> getAllProducts();

    @Query("SELECT * FROM Product WHERE StoreID = :storeId")
    public List<Product> getAllProductsForStore(long storeId);

    @Query("SELECT Product.* FROM PRODUCT INNER JOIN Store ON Product.StoreID = Store.StoreID WHERE Store.StoreName = :storeName")
    public List<Product> getAllProductsForStoreName(String storeName);

    @Query("DELETE FROM Product")
    public void nukeTable();
}
