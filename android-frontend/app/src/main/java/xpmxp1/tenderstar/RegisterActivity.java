package xpmxp1.tenderstar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;


public class RegisterActivity extends AppCompatActivity {

    private EditText Email;
    private EditText Password;
    private EditText PasswordRepeat;
    private Button Register;
    private Button Back;
    private TextView PasswordError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Email = (EditText)findViewById(R.id.txtEmail);
        Password = (EditText)findViewById(R.id.txtPassword);
        PasswordRepeat = (EditText)findViewById(R.id.txtPasswordRepeat);
        Register = (Button)findViewById(R.id.btnRegister);
        Back = (Button)findViewById(R.id.btnBack);
        PasswordError = (TextView) findViewById(R.id.viewPasswordError);

        Register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(validateRegPassword(Password.getText().toString(), PasswordRepeat.getText().toString()))
                {
                    if(Database.getInstance().registerCustomer(Email.getText().toString(), Password.getText().toString()))
                    {
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                        return;
                    }

                    PasswordError.setText("Username already exists");
                    PasswordError.setVisibility(View.VISIBLE);
                }
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, Start.class);
                startActivity(intent);
            }
        });
    }

    private boolean validateRegPassword(String passwordOne, String passwordTwo){
        if(passwordOne.equals(passwordTwo) ){
            PasswordError.setVisibility(View.INVISIBLE);
            return true;
        }

        PasswordError.setVisibility(View.VISIBLE);
        PasswordError.setText("Passwords do not match");
        return false;
    }

}
