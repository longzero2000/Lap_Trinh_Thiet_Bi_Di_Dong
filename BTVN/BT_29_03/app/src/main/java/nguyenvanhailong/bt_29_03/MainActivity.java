package nguyenvanhailong.bt_29_03;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private ListView lvSongs;
    private List<Song> mSongs;
    private CustomListAdapter mSongAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvSongs = (ListView) findViewById(R.id.lv_songs);

        //create song data
        mSongs = new ArrayList<>();
        mSongs.add(new Song("md","Một bước yêu vạn dặm đau","Mr.Siro" ));
        mSongs.add(new Song("kml", "Khuê mộc lang", "Hương Ly, Jombie"));
        mSongs.add(new Song("dl","Đừng lo anh đợi mà", "Mr.Siro"));

        //create adapter
        mSongAdapter = new CustomListAdapter(this, mSongs);
        //set adapter for ListView
        lvSongs.setAdapter(mSongAdapter);

    }
}