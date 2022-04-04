package nguyenvanhailong.mssv60136035;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

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
            ImageView image = (ImageView) findViewById(R.id.imageView);

            String x = username.getText().toString();
            String y = password.getText().toString();
            String z = email.getText().toString();
            String user ="longfull2000";
            String pass ="123456";
            String mail="nguyenvanhailong2000@gmail.com";


            if ((x.equals(user)) && (y.equals(pass)) && (z.equals(mail))) {

                Toast.makeText(HomeActivity.this, "Đăng nhập thành công..", Toast.LENGTH_LONG).show();
                Intent iHome = new Intent(HomeActivity.this,HomeActivity.class);
                iHome.putExtra("tenNguoiDung",x);
                startActivity(iHome);
                image.setImageResource(R.drawable.main);
            } else {
                Toast.makeText(HomeActivity.this, "Bạn đã nhập sai thông tin, hãy nhập lại !", Toast.LENGTH_LONG).show();
            }
        }
    };


}