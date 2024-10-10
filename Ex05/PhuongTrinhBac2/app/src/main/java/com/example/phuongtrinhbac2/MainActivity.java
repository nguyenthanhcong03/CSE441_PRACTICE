package com.example.phuongtrinhbac2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends Activity {
    Button btnTieptuc,btnGiaiPT,btnThoat;
    EditText edtA,edtB,edtC;
    TextView txtKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTieptuc= findViewById(R.id.btnTiepTuc);
        btnGiaiPT= findViewById(R.id.btnGiaiPT);
        btnThoat=findViewById(R.id.btnThoat);
        edtA= findViewById(R.id.edtA);
        edtB= findViewById(R.id.edtB);
        edtC= findViewById(R.id.edtC);
        txtKQ= findViewById(R.id.txtKQ);
        btnGiaiPT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sa=edtA.getText()+"";
                String sb=edtB.getText()+"";
                String sc=edtC.getText()+"";
                int a=Integer.parseInt(sa);
                int b=Integer.parseInt(sb);
                int c=Integer.parseInt(sc);
                String kq="";
                DecimalFormat dcf=new DecimalFormat("0.00");
                if(a==0)
                {
                    if(b==0)
                    {
                        if(c==0)
                            kq="PT vô số nghiệm";
                        else
                            kq="PT vô nghiệm";
                    }
                    else
                    {
                        kq="Pt có 1 No, x="+dcf.format(-c/b);
                    }
                }
                else
                {
                    double delta=b*b-4*a*c;
                    if(delta<0)
                    {
                        kq="PT vô nghiệm";
                    }
                    else if(delta==0)
                    {
                        kq="Pt có No kép x1=x2="+dcf.format(-b/(2*a));
                    }
                    else
                    {
                        kq="Pt có 2 No: x1="+dcf.format((-b+Math.sqrt(delta))/(2*a))+"; x2="+dcf.format((-
                                b-Math.sqrt(delta))/(2*a));
                    }
                }
                txtKQ.setText(kq);
            }
        });
        btnTieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtA.setText("");
                edtB.setText("");
                edtC.setText("");
                edtA.requestFocus();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}