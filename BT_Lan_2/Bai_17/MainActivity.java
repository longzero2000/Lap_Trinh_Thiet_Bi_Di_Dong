package cntt61.mssv60136035;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView LvName;
    ArrayList<String> arrayCourse;
    TextView tv;
    Button btAdd;
    EditText addName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        LvName =(ListView) findViewById(R.id.ListViewName);
        btAdd = (Button) findViewById(R.id.btAdd);
        addName =(EditText) findViewById(R.id.addName);
        arrayCourse =new ArrayList<>();

        ArrayAdapter adapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrayCourse
        );
        //
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = addName.getText().toString();
                arrayCourse.add(Name);
                adapter.notifyDataSetChanged();
            }
        });


        LvName.setAdapter(adapter);
        //
        LvName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tv.setText("position: "+i+ ";value=" +arrayCourse.get(i));
            }
        });

    }


}