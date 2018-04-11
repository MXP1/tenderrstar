package xpmxp1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import xpmxp1.tenderstar.app_objects.User;

/**
 * Created by Rene Hasenburger on 11.04.2018.
 */

public class BaseDataSource {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public BaseDataSource(Context ctx) {
        dbHelper = new DatabaseHelper(ctx);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public boolean insertUser(User user)
    {
        return false;
    }
}
