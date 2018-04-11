package xpmxp1.database_helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Rene Hasenburger on 11.04.2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "tenderstart.db";
    private static final int DB_VERSION = 3;
    private final Context ctx;

    private static final String DELETE_USER = "DROP TABLE IF EXISTS USER;";
    private static final String CREATE_USER =
                    "CREATE TABLE USER(" +
                    "  ID INT NOT NULL AUTOINCREMENT," +
                    "  BENUTZERNAME TEXT NOT NULL," +
                    "  PASSWORT TEXT NOT NULL," +
                    "  PRIMARY KEY (ID)" +
                    ");";

    public DatabaseHelper(Context ctx) {
        super(ctx, DB_NAME, null, DB_VERSION);
        this.ctx = ctx;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_USER);
        }
        catch (Exception ex) {
            Log.e("Exception", "Error while creating user table in DB: " + ex.getMessage());
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETE_USER);
        onCreate(db);
    }
}
