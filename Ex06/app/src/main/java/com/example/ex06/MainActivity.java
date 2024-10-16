package com.example.ex06;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtHoTen, edtCMND, edtBoSung;
    Button btnGui;
    RadioGroup idgroup;
    CheckBox chkDocBao, chkDocSach, chkCoding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtHoTen = findViewById(R.id.edtHoTen);
        edtCMND = findViewById(R.id.edtCMND);
        edtBoSung = findViewById(R.id.edtBoSung);
        btnGui = findViewById(R.id.btnGui);
        idgroup = findViewById(R.id.idgroup);
        chkDocBao = findViewById(R.id.chkDocBao);
        chkDocSach = findViewById(R.id.chkDocSach);
        chkCoding = findViewById(R.id.chkCoding);

        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoTen = edtHoTen.getText().toString();
                if (hoTen.length() < 3) {
                    Toast.makeText(MainActivity.this, "Ho ten phai >= 3 ky tu", Toast.LENGTH_LONG).show();
                    edtHoTen.requestFocus();
                    edtHoTen.selectAll();
                    return;
                }

                String CMND = edtCMND.getText().toString();
                if (CMND.length() != 9) {
                    Toast.makeText(MainActivity.this, "CMND phai dung 9 so", Toast.LENGTH_LONG).show();
                    edtCMND.requestFocus();
                    edtCMND.selectAll();
                    return;
                }

                int idSelect = idgroup.getCheckedRadioButtonId();
                RadioButton radSelect = findViewById(idSelect);
                String bangCap = radSelect.getText().toString();
                String soThich = "";
                if (chkDocSach.isChecked()) {
                    soThich += chkDocSach.getText().toString() + "-";
                }
                if (chkDocBao.isChecked()) {
                    soThich += chkDocBao.getText().toString() + "-";
                }
                if (chkCoding.isChecked()) {
                    soThich += chkCoding.getText().toString();
                }

                String boSung = edtBoSung.getText().toString();
                String tongHop = hoTen + "\n"+CMND+"\n"+bangCap+"\n"+soThich+"\n";
                tongHop += "------------THONG TIN BO SUNG------------\n"
                tongHop +=boSung+"\n";
                tongHop += "-----------------------------------------";


            }
        });
    }
}