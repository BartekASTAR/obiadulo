package com.example.uloscaner;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.util.Map;


public class MainActivity extends AppCompatActivity {

    Button btnScan;
    String type,received;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnScan = findViewById(R.id.btnScan);
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scanCode();
            }
        });

    }

    private void scanCode() {
        ScanOptions options = new ScanOptions();
        options.setPrompt("Volume up to flash on");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barLaucher.launch(options);
    }

    //QRcode scaner
    ActivityResultLauncher<ScanOptions> barLaucher = registerForActivityResult(new ScanContract(), result->
    {
       if (result.getContents()!=null){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        findInDatabse(result.getContents(),builder);
        builder.setNegativeButton("End", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("Next", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                scanCode();
            }
        });
        }
    });

    //Database connection
    private void findInDatabse(String uid,AlertDialog.Builder builder) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                //Parameters
                String[] field = new String[1];
                field[0] = "id";
                //Data
                String[] data = new String[1];
                data[0] = uid;
                PutData putData = new PutData("http://51.83.186.20/getorder.php", "POST", field, data);
                if (putData.startPut()) {
                    if (putData.onComplete()) {
                        String result = putData.getResult();
                        String res = result.substring(0,1);
                        if (res.equals("{")){
                            Gson gson = new Gson();
                            Map<String,String> jsonMap = gson.fromJson(result,Map.class);
                            type = jsonMap.get("type");
                            received = jsonMap.get("received");
                            String receivedMsg = "";
                            switch (received){
                                case "0":
                                    receivedMsg = "Wydaj zamówienie";
                                    break;
                                case "1":
                                    receivedMsg = "!! ODEBRANO !!";
                                    break;
                            }
                            builder.setTitle(receivedMsg);
                            builder.setMessage("Typ: " + type).show();
                        } else if (result.equals("Id is wrong")) {
                            builder.setTitle("!! Nie zamówiono obiadu !!");
                            builder.setMessage("Użytkownik nie zamówił obiadu. Obiad nie znajduje się w bazie danych.").show();
                        } else {
                            Toast.makeText(getApplicationContext(), result,Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }

}