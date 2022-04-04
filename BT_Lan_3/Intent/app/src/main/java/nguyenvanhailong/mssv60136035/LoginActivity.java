package nguyenvanhailong.mssv60136035;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnXacNhan = (Button) findViewById(R.id.btnOK);
        btnXacNhan.setOnClickListener(XuLyDangNhap);
    }

    View.OnClickListener XuLyDangNhap = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText username = (EditText) findViewById(R.id.edtUserName);
            EditText password = (EditText) findViewById(R.id.edtPass);
            EditText email = (EditText) findViewById(R.id.edtEmail);

            String x = username.getText().toString();
            String y = password.getText().toString();
            String z = email.getText().toString();
            String user ="longfull2000";
            String pass ="123456";
            String mail="nguyenvanhailong2000@gmail.com";


            if ((x.equals(user)) && (y.equals(pass)) && (z.equals(mail))) {

                Toast.makeText(LoginActivity.this, "Đăng nhập thành công..", Toast.LENGTH_SHORT).show();
                Intent iHome = new Intent(LoginActivity.this, HomeActivity.class);
                iHome.putExtra("tenNguoiDung",x);
                startActivity(iHome);
            } else {
                Toast.makeText(LoginActivity.this, "Bạn đã nhập sai thông tin, hãy nhập lại !", Toast.LENGTH_SHORT).show();
            }
        }
    };


}
