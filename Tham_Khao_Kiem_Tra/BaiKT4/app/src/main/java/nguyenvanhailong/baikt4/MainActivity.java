package nguyenvanhailong.baikt4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    int[] images = {R.drawable.pet, R.drawable.pet, R.drawable.pet, R.drawable.rabbit, R.drawable.pet, R.drawable.pet};

    String[] name = {"Octopus", "Pig", "Sheep", "Rabbit", "Snake", "Spider"};

    String[] info = {"8 tentacled monster", "Delicious in rolls", "Great for jumpers", "Nice in a stew", "Great for shoes", "Poison"};

    ListView lView;

    ListAdapter lAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}