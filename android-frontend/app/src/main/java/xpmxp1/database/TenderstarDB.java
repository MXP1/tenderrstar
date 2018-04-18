package xpmxp1.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import xpmxp1.database.DAO.CustomerDAO;
import xpmxp1.tenderstar.app_objects.Customer;

@Database(entities = {Customer.class}, version = 1, exportSchema = false)
public abstract class TenderstarDB extends RoomDatabase {
    public abstract CustomerDAO customerDAO();
}
