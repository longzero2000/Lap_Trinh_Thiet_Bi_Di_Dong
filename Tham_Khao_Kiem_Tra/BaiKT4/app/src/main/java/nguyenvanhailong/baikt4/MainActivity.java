package nguyenvanhailong.baikt4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[] images = {R.drawable.octopus, R.drawable.pig, R.drawable.sheep, R.drawable.rabbit, R.drawable.snake, R.drawable.spider};

    String[] name = {"Octopus", "Pig", "Sheep", "Rabbit", "Snake", "Spider"};

    String[] info = {"8 tentacled monster", "Delicious in rolls", "Great for jumpers", "Nice in a stew", "Great for shoes", "Poison"};

    ListView lView;

    ListAdapter lAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lView = (ListView) findViewById(R.id.animal);

        lAdapter = new nguyenvanhailong.baikt4.ListAdapter(MainActivity.this,name,info,images);

        lView.setAdapter(lAdapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(MainActivity.this, name[i]+" "+info[i], Toast.LENGTH_SHORT).show();

            }
        });
    }
}