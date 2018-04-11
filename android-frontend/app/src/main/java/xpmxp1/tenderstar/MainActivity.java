package xpmxp1.tenderstar;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import xpmxp1.database.TenderstarDB;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TenderstarDB db = Room.databaseBuilder(getApplicationContext(),
                TenderstarDB.class, "tenderstar.db").build();
    }
}
