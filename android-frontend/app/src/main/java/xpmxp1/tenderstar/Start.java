package xpmxp1.tenderstar;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        final Button signUp = findViewById(R.id.bSignUp);
        signUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Start.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        final Button login = findViewById(R.id.bLogin);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Start.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
