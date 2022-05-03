package com.nguyenvanhailong.temperature_conversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText NumberC = (EditText) findViewById(R.id.editC);
        final EditText NumberF = (EditText) findViewById(R.id.editF);
        Button C = (Button) findViewById(R.id.CtoF);
        Button F = (Button) findViewById(R.id.FtoC);
        Button clear = (Button) findViewById(R.id.clear);
        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double f = Double.valueOf(NumberC.getText().toString());
                Double c = (f*9)/5+32;
                NumberF.setText(String.valueOf(c));
            }
        });
        F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double c = Double.valueOf(NumberF.getText().toString());
                Double f = (c-32)*5/9;
                NumberC.setText(String.valueOf(f));
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberF.setText("");
                NumberC.setText("");
            }
        });
    }
}
