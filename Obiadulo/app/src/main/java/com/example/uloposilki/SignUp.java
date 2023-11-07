 package com.example.uloposilki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.io.FileNotFoundException;

 public class SignUp extends AppCompatActivity {


     TextInputEditText inpNameSignup, inpSurnameSignup, inpClasaSignup, inpPasswordSignup;
     Button btnSignup;
     TextView tvToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        inpNameSignup = findViewById(R.id.nameSignup);
        inpSurnameSignup = findViewById(R.id.surnameSignup);
        inpClasaSignup = findViewById(R.id.clasaSignup);
        inpPasswordSignup = findViewById(R.id.passwordSignup);
        btnSignup = findViewById(R.id.btnSignup);
        tvToLogin = findViewById(R.id.tvToLogin);

        tvToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LogIn.class);
                startActivity(intent);
                finish();
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name,surname,clasa,password;
                name = String.valueOf(inpNameSignup.getText());
                surname = String.valueOf(inpSurnameSignup.getText());
                clasa = String.valueOf(inpClasaSignup.getText());
                password = String.valueOf(inpPasswordSignup.getText());

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
                            PutData putData = new PutData("http://51.83.186.20/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if (result.equals("Sign Up Success")){
                                        Toast.makeText(getApplicationContext(), "Zarejestrowano poprawnie",Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), LogIn.class);
                                        startActivity(intent);
                                        finish();
                                    }else {
                                        Toast.makeText(getApplicationContext(), "Błąd zapytania\nKlasa to tylko 2 znaki",Toast.LENGTH_SHORT).show();

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