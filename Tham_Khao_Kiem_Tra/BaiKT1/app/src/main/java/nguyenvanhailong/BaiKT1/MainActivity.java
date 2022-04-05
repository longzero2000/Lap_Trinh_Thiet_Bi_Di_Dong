package nguyenvanhailong.BaiKT1;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnXacNhan = (Button) findViewById(R.id.btnOK);
        btnXacNhan.setOnClickListener(XuLyDangNhap);
    }

    View.OnClickListener XuLyDangNhap = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText username = (EditText) findViewById(R.id.edtUserName);
            EditText password = (EditText) findViewById(R.id.edtPass);
            TextView attempts = (TextView) findViewById(R.id.attempts);

            String x = username.getText().toString();
            String y = password.getText().toString();
            String user ="maicuongtho";
            String pass ="Cntt60ntu!";
            int at = 0;


            if ((x.equals(user)) && (y.equals(pass))) {
                Toast.makeText(MainActivity.this, "Username and Password is correct", Toast.LENGTH_SHORT).show();
                attempts.setText((String.valueOf(R.id.textView3)));

            } else {
                at++;
                Toast.makeText(MainActivity.this, "Username and Password is wrong!", Toast.LENGTH_SHORT).show();
            }
        }
    };


}