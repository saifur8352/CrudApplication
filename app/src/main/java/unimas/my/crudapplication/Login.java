package unimas.my.crudapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public
class Login extends AppCompatActivity {
    ImageButton loginButton, newSignupButton;
    TextInputEditText luserEmail, luserPassword;

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton=findViewById(R.id.login_button);
        newSignupButton=findViewById(R.id.go_signup);
        luserEmail=findViewById(R.id.user_email);
        luserPassword=findViewById(R.id.user_password);


        newSignupButton.setOnClickListener(new View.OnClickListener(){
            public
            void onClick(View view) {
                openNewActivity();
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener(){
            public
            void onClick(View view) {
                final String fullname, email, password;
                email= String.valueOf(luserEmail.getText());
                password= String.valueOf(luserPassword.getText());

                if(!email.equals("") && !password.equals("")) {
                    //Start ProgressBar first (Set visibility VISIBLE)
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];
                            field[0] = "email";
                            field[1] = "password";
                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = email;
                            data[1] = password;
                            PutData putData = new PutData("http://192.168.0.105/CrudProject/login.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if(result.equals("Login Success"))
                                    {
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                        Intent intent= new Intent(getApplicationContext(), MainActivity.class);
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
        Intent intent= new Intent(this, SignUp.class);
        startActivity(intent);
    }
}
