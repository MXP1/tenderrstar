package xpmxp1.database.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import xpmxp1.tenderstar.app_objects.Customer;
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

    //Query with Parameters
    //@Query("SELECT * FROM user WHERE age > :minAge")
    //public User[] loadAllUsersOlderThan(int minAge);
}
