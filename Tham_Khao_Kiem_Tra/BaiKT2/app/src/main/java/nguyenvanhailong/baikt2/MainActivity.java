package nguyenvanhailong.baikt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void calculateTip(View view){
        EditText input =  (EditText) findViewById(R.id.bill);
        String inputBill = input.getText().toString();
        if (inputBill.matches("")) {
            Toast.makeText(this, "Not enter a bill amount", Toast.LENGTH_SHORT).show();
            return;
        }
        float bill = Float.valueOf(inputBill);

        RadioButton low = (RadioButton) findViewById(R.id.tip_radio_low);
        RadioButton mid = (RadioButton) findViewById(R.id.tip_radio_mid);
        float tip;
        if (low.isChecked())
            tip = bill * 13 / 100;
        else if (mid.isChecked())
            tip = bill * 15 / 100;
        else
            tip = bill * 18 / 100;

        TextView tipView = (TextView) findViewById(R.id.display_tip);
        tipView.setText(String.format(""));
        tipView.setText(String.format("Your tip will be $%.2f.", tip));
    }
}