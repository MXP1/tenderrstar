package xpmxp1.tenderstar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;

import xpmxp1.tenderstar.app_objects.Customer;

public class LoginActivity extends AppCompatActivity {

    private EditText Email;
    private EditText Password;
    private TextView Attempts;
    private Button Login;
    private Button Back;
    private int counter = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = (EditText)findViewById(R.id.txtEmail);
        Password = (EditText)findViewById(R.id.txtPassword);
        Attempts = (TextView) findViewById(R.id.viewAttempts);
        Login = (Button)findViewById(R.id.btnLogin);
        Back = (Button)findViewById(R.id.btnBack);

        Attempts.setText("Attempts remaining: 4");

        Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                    validateLogin(Email.getText().toString(), Password.getText().toString());
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Start.class);
                startActivity(intent);
            }
        });
    }

    private void validateLogin(String userEmail, String userPassword) {
        Customer customer = Database.getInstance().loginCustomer(userEmail, userPassword);
        if(customer != null){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else{
            counter --;
            Attempts.setVisibility(View.VISIBLE);
            Attempts.setText("Wrong Combination! Attempts remaining: " + String.valueOf(counter));
            if(counter == 0){
                Attempts.setText("Too many invalid login attempts!");
                Login.setEnabled(false);
            }
        }
    }
}
