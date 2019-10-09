import java.util.ArrayList;
import java.util.List;

public class Library {
    private static float trackingId;
    List<Artist> artistList;
    private List<Album> albumList;

    public Library() {
        this.artistList = new ArrayList<Artist>();
        this.albumList = new ArrayList<Album>();
    }

    public Library(List<Artist> artistList, List<Album> albumList) {
        this.artistList = artistList;
        this.albumList = albumList;
    }

    void addArtist(Song s) {//add artist of song to artistList if already not added

        int size = s.artistList.size();
        boolean found;
        for (int i = 0; i < size; i++) {
            found = false;
            for (Artist a : artistList) {
                if (s.artistList.get(i).getName().equals(a.getName())) {
                    found = true;
                    break;
                }
            }

            if (!found) {//artist not found. adding to artist list
                artistList.add(s.artistList.get(i));
            }
        }
    }

    boolean alreadyPresent(Song s) {//will check song path,title already present or not
        List<Song> songList = getAllSongs();
        for (Song s1 : songList) {
            if (s1.path.equals(s.path) || s1.title.equals(s.title)) {
                return true;
            }
        }
        return false;

    }

    boolean albumPresent(String a) {
        for (Album albm : albumList) {
            if (albm.title.equals(a)) {
                return true;
            }
        }
        return false;
    }

    void addAlbum(String aName) {
        Album a = new Album(aName);
        albumList.add(a);
    }

    Album findAlbum(String aName) {
        for (Album a : albumList) {
            if (a.title.equals(aName)) {
                return a;
            }
        }
        return null;
    }

    void addSong(Song s) {//defaulut album
        if (!alreadyPresent(s)) {

            //add artist if not already present  into artitstList
            addArtist(s);

            if (!albumPresent("Default")) {
                addAlbum("Default");
            }
            Album a = findAlbum("Default");
            a.addSong(s);
            trackingId++;
        } else
            System.out.println(s.title + " : song not added ,this title or path already present");
    }

    void addSong(Song s, String albumTitle) {
        if (!alreadyPresent(s)) {

            //add artist if not already present  into artitstList
            addArtist(s);

            if (!albumPresent(albumTitle)) {
                addAlbum(albumTitle);
            }
            Album a = findAlbum(albumTitle);
            a.addSong(s);
            trackingId++;
        } else
            System.out.println(s.title + " : song not added ,this title or path already present");
    }

    Song getSongWithTitle(String title) {
        for (Album albm : albumList) {

            for (Song s : albm.getSongList()) {
                if (s.title.equals(title)) {
                    return s;
                }
            }

        }
        System.out.println("Song not found with title : " + title);
        return null;
    }

    Song getSongWithPath(String path) {
        for (Album albm : albumList) {

            for (Song s : albm.getSongList()) {
                if (s.path.equals(path)) {
                    return s;
                }
            }

        }
        System.out.println("Song not found with path : " + path);
        return null;
    }

    //pasing artist list for more than one artist of a song
    List<Song> getSongWithArtistName(String artisName) {
        for (Artist a : artistList
        ) {
            List<Song> songList = new ArrayList<>();
            if (a.getName().equals(artisName)) {
                //artist found now searching all songs
                List<Song> allSongList = getAllSongs();
                //now filter this song list
                for (Song s : allSongList) {
                    for (int i = 0; i < s.artistList.size(); i++) {
                        if (s.artistList.get(i).equals(artisName)) {
                            songList.add(s);
                        }
                    }

                }

                return songList;

            }

        }

        System.out.println("Song with artist not found : ");
        return null;
    }

    void viewSongByArtist(Artist a) {
        System.out.println("\n\nShowing All Songs of "+ a.getName());
        List<Song> albumSongsList = new ArrayList<>();
        for (Album albm : albumList) {

            albumSongsList = albm.getSongList();
            if (albumSongsList.size() == 0) {
                System.out.println("NO songs to show in this album");
            }
            for (Song s : albumSongsList) {
                for (int j = 0; j < s.artistList.size(); j++) {
                    if (s.artistList.get(j).getName().equals(a.getName())) {


                        System.out.print(s.title + "  __ ");
                        for (int i = 0; i < s.artistList.size(); i++) {
                            System.out.print(s.artistList.get(i).getName());
                            if (i + 1 < s.artistList.size()) {
                                System.out.print(" & ");

                            }
                        }
                        System.out.println("__" + s.path+"__"+albm.title);
                    }
                }


            }
        }
    }

    void addArtistToSong(Song s1,Artist a){
        Song s=getSongWithTitle(s1.title);
        artistList.add(a);
        s.artistList.add(a);
        System.out.println("Artist added to song "+ s1.title);
    }
    List<Song> getSongFromAlbum(String albumTitle) {
        for (Album albm : albumList) {
            if (albm.title.equals(albumTitle)) {
                return albm.getSongList();
            }
        }
        System.out.println("Album not found ");
        return null;
    }

    List<Song> getAllSongs() {
        List<Song> allSongsList = new ArrayList<>();
        for (Album albm : albumList) {

            allSongsList.addAll(albm.getSongList());
        }
        return allSongsList;

    }

    void viewAllAlbums() {
        System.out.println("\n\nShowing All Albums: ");

        for (Album a : albumList) {
            System.out.println(a.title);
        }
    }

    void viewAllSongs() {
        System.out.println("\n\nShowing All Songs:");
        List<Song> albumSongsList = new ArrayList<>();
        for (Album albm : albumList) {
            System.out.println("Album : " + albm.title);
            albumSongsList = albm.getSongList();
            if (albumSongsList.size() == 0) {
                System.out.println("NO songs to show in this album");
            }
            for (Song s : albumSongsList) {
                System.out.print(s.title + "  __ ");
                for (int i = 0; i < s.artistList.size(); i++) {
                    System.out.print(s.artistList.get(i).getName());
                    if (i + 1 < s.artistList.size()) {
                        System.out.print(" & ");

                    }
                }
                System.out.println("__" + s.path);
            }
        }


    }

    //do remaining removes with path,title,artist
    void removeSong(Song s) {

        for (Album albm : albumList) {

            for (Song s1 : albm.getSongList()) {
                if (s1.title.equals(s.title)) {
                    albm.removeSong(s1);
                    System.out.println(s1.title+" : song removed from Album "+ albm.title);
                    return;
                }
            }
        }
    }

    void removeArtist(Artist a) {
        //removing artist will remove all its songs
        List<Song> removeSongList = new ArrayList<>();
        for (Album albm : albumList) {
            List<Song> albumSongsList = albm.getSongList();

            for (Song s1 : albumSongsList) {
                //System.out.print(s.title + "  __ ");
                for (int i = 0; i < s1.artistList.size(); i++) {
                    // System.out.print(s.artistList.get(i).getName());
                    if (s1.artistList.get(i).getName().equals(a.getName())) {
                        removeSongList.add(s1);
                    }

                }
            }
        }
        int size = removeSongList.size();
        for (int i = 0; i < size; i++) {
            removeSong(removeSongList.get(i));
        }
        //getSongWithArtistName(a.getName()).removeAll(getSongWithArtistName(a.getName()));
        //a=artistList.get(2);
        for (Artist a1 : artistList) {
            if (a1.getName().equals(a.getName())) {
                artistList.remove(a1);
                return;
            }
        }


    }

    void viewAllArtists() {
        System.out.println("\n\nShowing All Artist of Library:");
        for (Artist a : artistList) {
            System.out.println(a.getName());
        }
    }

    void addArtist(Artist a) {
        artistList.add(a);
    }
    //void editSongName(old,new)
}
