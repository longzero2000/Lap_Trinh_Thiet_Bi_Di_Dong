package com.nguyenvanhailong.cau1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btncv,btndt;
    EditText editA,editB,editH;
    TextView tvResult;
    View.OnClickListener myclick = new View.OnClickListener() {


        @Override
        public void onClick(View arg0) {
            String sa = editA.getText() + "";

            String sb = editB.getText().toString();

            String sh = editH.getText().toString();
            int a = Integer.parseInt(sa);

            int b = Integer.parseInt(sb);

            int h = Integer.parseInt(sh);
            switch (arg0.getId()) {
                case R.id.btncv:
                    tvResult.setText("" + (a + b)*2);
                    break;
                case R.id.btndt:
                    tvResult.setText("" + (a*h));
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btncv = (Button) findViewById(R.id.btncv);
        btndt = (Button) findViewById(R.id.btndt);
        editA = (EditText) findViewById(R.id.edtA);
        editB = (EditText) findViewById(R.id.edtB);
        editH = (EditText) findViewById(R.id.edtH);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btncv.setOnClickListener(myclick);
        btndt.setOnClickListener(myclick);
    }
}