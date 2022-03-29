package cntt61.mssv60136035;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends ListActivity {
    private static final String[] items =
            {"Intel", "Samsung", "Nokia",
            "Simen", "AMD", "KIC",
            "ECD"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mTextView = (TextView) findViewById(R.id.myTextView);
        // Khai báo myArrayAdapter
        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        // Gắn myArrayAdapter vào cho ListView có sẵn
        setListAdapter(myArrayAdapter);
        // Khai báo sự kiện Click cho myListView
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mTextView.setText("position: "+id+ ";value=" + myArrayAdapter.getItem(position));
            }
        });
    }
}