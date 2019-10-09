import java.util.List;

public class Song {
    String title;
    String path;
    float trackNumber;
    long duration;//in seconds
    List<Artist> artistList;
    public Song(String tile, String path, float trackNumber, long duration, List<Artist> artistList) {
        this.title = tile;
        this.path = path;
        this.trackNumber = trackNumber;
        this.duration = duration;
        this.artistList = artistList;
    }
}
