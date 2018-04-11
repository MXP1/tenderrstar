package xpmxp1.tenderstar;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.io.IOException;
import java.util.List;
import xpmxp1.database.DAO.UserDAO;
import xpmxp1.database.TenderstarDB;
import xpmxp1.tenderstar.app_objects.User;

@RunWith(JUnit4.class)
public class DatabaseTest {
    private UserDAO userDAO;
    private TenderstarDB db;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        db = Room.inMemoryDatabaseBuilder(context, TenderstarDB.class).build();
        userDAO = db.userDAO();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void simpleInsertTest() throws Exception {
        User user = new User("Sebastian", "asdf");
        long i = userDAO.insertUser(user);
        List<User> users = userDAO.getAllUsers();
        Assert.assertEquals("Sebastian", users.get(0).getBenutzername());
    }
}

