package com.example.uloposilki;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class Main extends AppCompatActivity {

    ImageView ivQRcode;
    TextView tvName,tvSurname,tvClasa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivQRcode = findViewById(R.id.ivQrcode);

        Intent intent = getIntent();
        String uid = intent.getStringExtra("uid");
        String name = intent.getStringExtra("name");
        String surname = intent.getStringExtra("surname");
        String clasa = intent.getStringExtra("clasa");

        tvName = findViewById(R.id.nameMain);
        tvSurname = findViewById(R.id.surnameMain);
        tvClasa = findViewById(R.id.clasaMain);

        tvName.setText("Imię: " + name);
        tvSurname.setText("Nazwisko: " + surname);
        tvClasa.setText("Klasa: " + clasa);

        generateQrCode(uid);

    }

    //Creating QRcode
    private void generateQrCode(String uid){
        MultiFormatWriter writer = new MultiFormatWriter();
        try {
            BitMatrix matrix = writer.encode(uid, BarcodeFormat.QR_CODE, 500,500);
            BarcodeEncoder encoder = new BarcodeEncoder();
            Bitmap bitmap = encoder.createBitmap(matrix);
            ivQRcode.setImageBitmap(bitmap);
        }catch (WriterException e) {
            e.printStackTrace();
        }
    }

}