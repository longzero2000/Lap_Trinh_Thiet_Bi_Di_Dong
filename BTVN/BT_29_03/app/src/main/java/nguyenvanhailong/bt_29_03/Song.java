package nguyenvanhailong.bt_29_03;

public class Song {
    private String Img;
    private String mTitle;
    private String mArtist;


    public Song() {

    }

    public Song(String Img, String title, String artist) {
        this.Img = Img;
        this.mTitle = title;
        this.mArtist = artist;
    }

    public String getImg() {
        return Img;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getArtist() {
        return mArtist;
    }

    public void setImg(String Img) {
        this.Img = Img;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public void setArtist(String artist) {
        this.mArtist = artist;
    }
}