import java.util.ArrayList;
import java.util.List;

public class Album {
     String title;
    //songList should have songs in order of trackNumbmers
    private List<Song> songList;

    public Album(String title) {
        this.title = title;
        this.songList =new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }
    void addSong(Song s){
        songList.add(s);
        System.out.println(s.title + " : Song added in album "+ title);
    }
    Song getSongWithTitle(String title){
        for(Song s: songList){
            if(s.title.equals(title)){
                return s;
            }
        }

        return null;
    }

    List<Song> getSongWithArtist(String artisName){
        List<Song> tempSongList=new ArrayList<>();
        for(Song s: songList){
            if(s.title.equals(title)){
                tempSongList.add(s);
            }
        }

        return tempSongList;
    }
    List<Song> getAllSongs(){
       return songList;
    }
    void removeSong(Song s){
        songList.remove(s);
    }



}
