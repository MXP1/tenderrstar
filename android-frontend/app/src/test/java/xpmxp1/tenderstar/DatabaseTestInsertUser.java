package xpmxp1.tenderstar;

import android.content.Context;

import android.test.AndroidTestCase;
import android.test.mock.MockContext;
import xpmxp1.database.BaseDataSource;

import xpmxp1.tenderstar.app_objects.User;

public class DatabaseTestInsertUser extends AndroidTestCase
{
    private Context ctx;

    public void setUp() throws Exception {
        super.setUp();
        ctx = new MockContext();
        setContext(ctx);
        assertNotNull(ctx);
        insertUserTest();
    }

    public void insertUserTest()
    {
        String benutzername = "Sebastian";
        String passwort = "asdf";

        User user = new User(benutzername, passwort);
        BaseDataSource ds = new BaseDataSource(ctx);
        ds.open();

        assertTrue(ds.insertUser(user));

        ds.close();
    }
}
