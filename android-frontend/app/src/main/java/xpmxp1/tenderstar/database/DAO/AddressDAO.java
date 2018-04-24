package xpmxp1.tenderstar.database.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import xpmxp1.tenderstar.app_objects.Address;


/**
 * Created by sebastian on 4/18/18.
 */

@Dao
public interface AddressDAO {
    @Insert
    public long insertAddress(Address address);

    @Update
    public void updateAddress(Address address);

    @Delete
    public void deleteAddress(Address address);

    @Query("SELECT * FROM Address")
    public List<Address> getAllAddresses();

    //Query with Parameters
    //@Query("SELECT * FROM user WHERE age > :minAge")
    //public User[] loadAllUsersOlderThan(int minAge);
}