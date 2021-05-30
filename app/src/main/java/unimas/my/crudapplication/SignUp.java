package unimas.my.crudapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public
class SignUp extends AppCompatActivity {
    ImageButton signupButton, oldLogin;
    TextInputEditText userName, newEmail, newPassword;

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signupButton = findViewById(R.id.newsignup_button);
        oldLogin = findViewById(R.id.old_login);
        userName = findViewById(R.id.user_name);
        newEmail = findViewById(R.id.new_email);
        newPassword = findViewById(R.id.new_password);

        oldLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public
            void onClick(View v) {
                openNewActivity();
            }
        });
        signupButton.setOnClickListener(new View.OnClickListener(){
            public
            void onClick(View view) {
                final String fullname, email, password;
                fullname= String.valueOf(userName.getText());
                email= String.valueOf(newEmail.getText());
                password= String.valueOf(newPassword.getText());

                if(!fullname.equals("") && !email.equals("") && !password.equals("")) {
                //Start ProgressBar first (Set visibility VISIBLE)
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //Starting Write and Read data with URL
                        //Creating array for parameters
                        String[] field = new String[3];
                        field[0] = "fullname";
                        field[1] = "email";
                        field[2] = "password";
                        //Creating array for data
                        String[] data = new String[3];
                        data[0] = fullname;
                        data[1] = email;
                        data[2] = password;
                        PutData putData = new PutData("http://192.168.0.105/CrudProject/signup.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                if(result.equals("Sign Up Success"))
                                {
                                    Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    Intent intent= new Intent(getApplicationContext(), Login.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        }
                        //End Write and Read data with URL
                    }
                });
              }
                else{
                    Toast.makeText(getApplicationContext(),"All Fields are Required",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void openNewActivity(){
        Intent intent= new Intent(this, Login.class);
        startActivity(intent);
    }
}