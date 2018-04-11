package xpmxp1.database_helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Rene Hasenburger on 11.04.2018.
 */

public class DataSource {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public DataSource(Context ctx) {
        dbHelper = new DatabaseHelper(ctx);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }
}
