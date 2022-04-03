package nguyenvanhailong.bt_29_03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class CustomListAdapter extends ArrayAdapter<Song> {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<Song> mSongs;

    public CustomListAdapter(Context context, List<Song> objects) {
        super(context, 0, objects);
        mContext = context;
        mSongs = objects;
        mLayoutInflater = LayoutInflater.from(context);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Song song = mSongs.get(position);
        convertView = mLayoutInflater.inflate(R.layout.list_item_layout, parent, false);

        //findViewBId in convertView
        ImageView ivImg = (ImageView) convertView.findViewById(R.id.tv_img);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
        TextView tvArtist = (TextView) convertView.findViewById(R.id.tv_artist);

        //set attribute
        //ivImg.setImageResource(R.drawable.mb);
        tvTitle.setText(song.getTitle());
        tvArtist.setText(song.getArtist());

        return convertView;
    }
}