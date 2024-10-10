package com.example.nhietdo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends Activity {
    EditText edtC, edtF;
    Button btncf, btnfc, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtC = findViewById(R.id.edtC);
        edtF = findViewById(R.id.edtF);
        btncf = findViewById(R.id.btncf);
        btnfc = findViewById(R.id.btnfc);
        btnClear = findViewById(R.id.btnClear);

        edtC.setText("0");
        edtF.setText("0");

        btnfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DecimalFormat dcf=new DecimalFormat("#.00");
                String doC = edtC.getText()+"";
                int C=Integer.parseInt(doC);
                edtF.setText(""+dcf.format(C*1.8+32));
            }
        });
        btncf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf=new DecimalFormat("#.00");
                String doF = edtF.getText()+"";
                int F=Integer.parseInt(doF);
                edtC.setText(""+dcf.format((F-32)/1.8));
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtC.setText("0");
                edtF.setText("0");
            }
        });
    }
}