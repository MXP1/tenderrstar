package xpmxp1.database.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import xpmxp1.tenderstar.app_objects.Customer;

/**
 * Created by Rene Hasenburger on 18.04.2018.
 */

@Dao
public interface CustomerDAO {
    @Insert
    public long insertCustomer(Customer customer);

    @Update
    public void updateCustomer(Customer customer);

    @Delete
    public void deleteCustomer(Customer customer);

    @Query("SELECT * FROM Customer")
    public List<Customer> getAllCustomers();

    //Query with Parameters
    //@Query("SELECT * FROM user WHERE age > :minAge")
    //public User[] loadAllUsersOlderThan(int minAge);
}
