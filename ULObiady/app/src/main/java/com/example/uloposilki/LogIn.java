package com.example.uloposilki;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;


public class LogIn extends AppCompatActivity {

    TextInputEditText inpNameLogin, inpSurnameLogin, inpClasaLogin, inpPasswordLogin;
    Button btnLogin;
    TextView tvToSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        inpNameLogin = findViewById(R.id.nameLogin);
        inpSurnameLogin = findViewById(R.id.surnameLogin);
        inpClasaLogin = findViewById(R.id.clasaLogin);
        inpPasswordLogin = findViewById(R.id.passwordLogin);
        btnLogin = findViewById(R.id.btnLogin);
        tvToSignup = findViewById(R.id.tvToSignup);

        tvToSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name,surname,clasa,password;
                name = String.valueOf(inpNameLogin.getText());
                surname = String.valueOf(inpSurnameLogin.getText());
                clasa = String.valueOf(inpClasaLogin.getText());
                password = String.valueOf(inpPasswordLogin.getText());

                //Database connection
                if (!name.equals("") && !surname.equals("") && !clasa.equals("") && !password.equals("")) {
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Parameters
                            String[] field = new String[4];
                            field[0] = "name";
                            field[1] = "surname";
                            field[2] = "class";
                            field[3] = "password";
                            //Data
                            String[] data = new String[4];
                            data[0] = name;
                            data[1] = surname;
                            data[2] = clasa;
                            data[3] = password;
                            PutData putData = new PutData("http://51.83.186.20/login.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    String res = result.substring(0,2);
                                    String uid = result.substring(2,38);
                                    if (res.equals("LS")){
                                        Toast.makeText(getApplicationContext(), "Zalogowano poprawnie",Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), Main.class);
                                        intent.putExtra("uid", uid);
                                        intent.putExtra("name", name);
                                        intent.putExtra("surname", surname);
                                        intent.putExtra("clasa", clasa);
                                        startActivity(intent);

                                        finish();
                                    }else {
                                        Toast.makeText(getApplicationContext(), result,Toast.LENGTH_SHORT).show();

                                    }
                                }
                            }

                        }

                    });
                } else {
                    Toast.makeText(getApplicationContext(), "Uzupełnij wszytkie pola",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}