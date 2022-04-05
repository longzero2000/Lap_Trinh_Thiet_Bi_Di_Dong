package nguyenvanhailong.mssv60136035;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent iHome = getIntent();
        TextView tvUserName = (TextView) findViewById(R.id.txt8);
        ImageView anh = (ImageView) findViewById(R.id.imageView);

        tvUserName.setText(String.valueOf(iHome.getStringExtra("tenNguoiDung")));
        anh.setImageResource(R.drawable.main);
    }
}