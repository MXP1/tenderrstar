package xpmxp1.tenderstar;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.util.Log;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.io.IOException;
import java.util.List;

import xpmxp1.database.DAO.CustomerDAO;
import xpmxp1.database.TenderstarDB;
import xpmxp1.tenderstar.app_objects.Customer;

@RunWith(JUnit4.class)
public class DatabaseTest {
    private CustomerDAO customerDAO;
    private TenderstarDB db;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        db = Room.inMemoryDatabaseBuilder(context, TenderstarDB.class).build();
        customerDAO = db.customerDAO();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void insertCustomerTest() throws Exception {
        Customer kunde1 = new Customer("Rene", "abcd", "asdf@asdf.at");
        Customer kunde2 = new Customer("Sebastian", "abcd", "asdf@asdf.at");

        long i = customerDAO.insertCustomer(kunde1);
        assertNotEquals(i, -1);

        i = customerDAO.insertCustomer(kunde2);
        assertNotEquals(i, -1);


        List<Customer> customers = customerDAO.getAllCustomers();

        for(Customer c : customers) {
            Log.d("DatabaseTest", "ID: " + c.getId());
            Log.d("DatabaseTest", "Username: " + c.getUsername());
            Log.d("DatabaseTest", "Password: " + c.getPassword());
            Log.d("DatabaseTest", "E-Mail: " + c.getEmail());
        }
    }

}

