import java.util.ArrayList;
import java.util.List;

public class Song {
    String title;
    String path;
    int trackNumber;
    long duration;//in seconds
    List<Artist> artistList;
    public Song(String tile, String path, int trackNumber, long duration, List<Artist> artistList) {
        this.title = tile;
        this.path = path;
        this.trackNumber = trackNumber;
        this.duration = duration;
        this.artistList = artistList;
    }

    public Song(String title) {
        this.title = title;
        this.artistList= new ArrayList<>();
    }
    public Song() {

        this.artistList= new ArrayList<>();
    }

}
