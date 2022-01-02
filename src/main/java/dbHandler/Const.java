package dbHandler;

public class Const {

    public static final String USER_TABLE = "music";

    private String id;

    private int MUSIC_ID;
    private String MUSIC_TRACKNAME ;
    private String MUSIC_GENRE ;
    private String MUSIC_DURATION ;
    private String MUSIC_ARTIST;

    public Const(int MUSIC_ID,String MUSIC_TRACKNAME,String MUSIC_GENRE, String MUSIC_DURATION,String MUSIC_ARTIST) {
        this.MUSIC_ID = MUSIC_ID;
        this.MUSIC_TRACKNAME = MUSIC_TRACKNAME;
        this.MUSIC_GENRE = MUSIC_GENRE;
        this.MUSIC_DURATION = MUSIC_DURATION;
        this.MUSIC_ARTIST = MUSIC_ARTIST;
    }
    public Const(){}




    public int getMUSIC_ID() {
        return MUSIC_ID;
    }

    public void setMUSIC_ID(int MUSIC_ID) {
        this.MUSIC_ID = MUSIC_ID;
    }

    public String getMUSIC_TRACKNAME() {
        return MUSIC_TRACKNAME;
    }

    public void setMUSIC_TRACKNAME(String MUSIC_TRACKNAME) {
        this.MUSIC_TRACKNAME = MUSIC_TRACKNAME;
    }

    public String getMUSIC_GENRE() {
        return MUSIC_GENRE;
    }

    public void setMUSIC_GENRE(String MUSIC_GENRE) {
        this.MUSIC_GENRE = MUSIC_GENRE;
    }

    public String getMUSIC_DURATION() {
        return MUSIC_DURATION;
    }

    public void setMUSIC_DURATION(String MUSIC_DURATION) {
        this.MUSIC_DURATION = MUSIC_DURATION;
    }

    public String getMUSIC_ARTIST() {
        return MUSIC_ARTIST;
    }

    public void setMUSIC_ARTIST(String MUSIC_ARTIST) {
        this.MUSIC_ARTIST = MUSIC_ARTIST;
    }

}
