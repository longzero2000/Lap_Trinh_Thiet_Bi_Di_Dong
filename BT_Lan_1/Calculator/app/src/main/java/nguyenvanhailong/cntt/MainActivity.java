package nguyenvanhailong.cntt;

import android.os.Bundle;

import android.view.View;

import android.view.View.OnClickListener;

import android.widget.Button;

import android.widget.EditText;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnAdd,btnSub,btnMul,btnDiv;
    EditText editA,editB;
    TextView tvResult;
    OnClickListener myclick = new OnClickListener() {


        @Override
        public void onClick(View arg0) {
            String sa = editA.getText() + "";

            String sb = editB.getText().toString();

            int a = Integer.parseInt(sa);

            int b = Integer.parseInt(sb);
            switch (arg0.getId()) {
                case R.id.btnAdd:
                    tvResult.setText("" + (a + b));
                    break;
                case R.id.btnSub:
                    tvResult.setText("" + (a - b));
                    break;
                case R.id.btnMul:
                    tvResult.setText("" + (a * b));
                    break;
                case R.id.btnDiv:
                    tvResult.setText("" + (a / b));
                    break;
            }
        }
    };


    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
    }

    private void Anhxa(){
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        editA = (EditText) findViewById(R.id.edtA);
        editB = (EditText) findViewById(R.id.edtB);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnAdd.setOnClickListener(myclick);
        btnSub.setOnClickListener(myclick);
        btnMul.setOnClickListener(myclick);
        btnDiv.setOnClickListener(myclick);

    }

}