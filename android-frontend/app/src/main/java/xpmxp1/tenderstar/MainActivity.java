package xpmxp1.tenderstar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import xpmxp1.database.BaseDataSource;
import xpmxp1.tenderstar.app_objects.User;

public class MainActivity extends AppCompatActivity {

    private BaseDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User testUser = new User("asdf", "asdf");
        dataSource = new BaseDataSource(this);
        dataSource.open();
        dataSource.close();
    }
}
