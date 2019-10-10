import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private static int trackingId;
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
    void editSongName(String oldName,String newName){
        List<Song> songList = getAllSongs();
        for (Song s1 : songList) {
            if (s1.title.equals(oldName)) {
                s1.title=newName;
            }
        }
    }
    void editSongPath(String oldName,String newName){
        List<Song> songList = getAllSongs();
        for (Song s1 : songList) {
            if (s1.title.equals(oldName)) {
                s1.path=newName;
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
    boolean alreadyPresent(String name, String path) {//will check song path,title already present or not
        List<Song> songList = getAllSongs();
        for (Song s1 : songList) {
            if (s1.path.equals(path) || s1.title.equals(name)) {
                return true;
            }
        }
        return false;

    }
    void loadMp3State() {
        try {
            File file = new File("mp3Data.txt");

            BufferedReader br = new BufferedReader(new FileReader(file));
            Song s=new Song();
            String st;int c=0;
            while ((st = br.readLine()) != null) {
                if (st.equals("eof")) {
                    break;
                }
                else if (st.equals("#")) {
                    c = 0;
                } else if (c == 0 || c == 2) {
                    c++;
                } else if (c == 1) {
                    albumList.add(new Album(st));
                    c++;
                } else if (c == 3) {
                    s.title = st;
                    c++;
                } else if (c == 4) {
                    s.path = st;
                    c++;
                } else if (c == 5) {
                    s.duration = Integer.parseInt(st);
                    c++;
                } else if (c == 6) {
                    s.trackNumber = Integer.parseInt(st);
                    c++;
                } else if (c > 6 && !st.equals("--")) {
                    if (st.equals("+")) {
                        c++;
                    } else {
                        Artist a=new Artist(st);
                        s.artistList.add(a);
                        if(!artistPresent(a.getName())){
                            artistList.add(a);
                        }

                        c++;
                    }
                } else if (st.equals("--")) {
                    addSong(s,albumList.get(albumList.size() - 1).getTitle());

                    s=new Song();
                    c = 3;
                }
            }


            System.out.println("Mp3 Loaded Succesfulty\n");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    void saveCurrentSateToFile() {
        try {

            FileWriter myWriter = new FileWriter("mp3Data.txt");
            //#albums
            for(Album a: albumList){
                myWriter.write("Album_n:\n");
                myWriter.write(a.title+"\n");
                myWriter.write("SongList:\n");
                List<Song> songList=getSongFromAlbum(a.getTitle());
                for(Song s: songList){
                    myWriter.write(s.title+"\n");
                    myWriter.write(s.path+"\n");
                    myWriter.write(s.duration+"\n");
                    myWriter.write(s.trackNumber+"\n");
                    for (int i = 0; i < s.artistList.size(); i++) {
                        myWriter.write(s.artistList.get(i).getName() );
                        if(i+1<s.artistList.size()){
                            myWriter.write("\n+\n");
                        }
                        else
                            myWriter.write('\n');
                    }

                    myWriter.write("--\n");
                }
                myWriter.write("#\n");
            }



            myWriter.write("eof\n");
        myWriter.close();
            System.out.println("Current MP3 state saved succesfully\n\n");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }// catch (IOException e) {
        // e.printStackTrace();
        //}
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
    void playit(List<Song> songList){
        System.out.println("Enter Title of Song to Play or 00 to go back : ");
        Scanner input = new Scanner(System.in);
        //System.out.println("Enter Your Choice : ");
        String title = input.nextLine();
        boolean found =false;
        if(title.equals("00")){
            return;
        }
        for (Song s : songList) {
            if (s.title.equals(title)) {
                found=true;
                MP3 playerMP3 = new MP3(s.path);
                playerMP3.play();
                while (true) {
                    System.out.println("Enter SPACE ' ' to play/stop : \n00 to go back");
                    //input = new Scanner(System.in);
                    //System.out.println("Enter Your Choice : ");
                    title = input.nextLine();
                    if (title.equals("00")) {

                        playerMP3.stop();
                        break;
                    } else if (title.equals(" ")) {
                        if (playerMP3.isPlaying())
                            playerMP3.stop();
                        else
                            playerMP3.play();
                    } else
                        System.out.println("invalid input");
                }
                break;
            }
        }
        if(!found){
            System.out.println("Song Not found");
        }

    }
    void addSong(Song s) {//defaulut album
        if (!alreadyPresent(s)) {

            //add artist if not already present  into artitstList
            addArtist(s);

            if (!albumPresent("Default")) {
                addAlbum("Default");
            }
            Album a = findAlbum("Default");
            s.trackNumber=trackingId;
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
            s.trackNumber=trackingId;
            a.addSong(s);
            trackingId++;
        } else
            System.out.println(s.title + " : song not added ,this title or path already present");
    }

    void viewSongWithTitle(String title){
        printThisSongInfo(getSongWithTitle(title));

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
        List<Song> songList = new ArrayList<>();
        for (Artist a : artistList
        ) {

            if (a.getName().equals(artisName)) {
                //artist found now searching all songs
                List<Song> allSongList = getAllSongs();
                //now filter this song list
                for (Song s : allSongList) {
                    for (int i = 0; i < s.artistList.size(); i++) {
                        if (s.artistList.get(i).getName().equals(artisName)) {
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
    boolean artistPresent(String name){
        for(Artist a1: artistList){
            if(a1.getName().equals(name))
                return true;
        }
        return false;
    }
    void viewSongByArtist(Artist a) {
        if (artistPresent(a.getName())) {
            System.out.println("\n\nShowing All Songs of " + a.getName());
            List<Song> albumSongsList = new ArrayList<>();
            for (Album albm : albumList) {

                albumSongsList = albm.getSongList();
                if (albumSongsList.size() == 0) {
                    System.out.println("NO songs to show ");
                }
                for (Song s : albumSongsList) {
                    for (int j = 0; j < s.artistList.size(); j++) {
                        if (s.artistList.get(j).getName().equals(a.getName())) {


                            printThisSongInfo(s);

                        }
                    }


                }
            }
        }
        else
            System.out.println("Artist not present");
    }
    void addArtistToSong(Song s1,Artist a){
        Song s=getSongWithTitle(s1.title);
        artistList.add(a);
        s.artistList.add(a);
        System.out.println("Artist added to song "+ s1.title);
    }
    void viewSongFromAlbum(Album a){
        List<Song> songList=getSongFromAlbum(a.title);
        for(Song s: songList){
            printThisSongInfo(s);
        }
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

    void printThisSongInfo(Song s){
        System.out.print(s.title + "  __ ");
        for (int i = 0; i < s.artistList.size(); i++) {
            System.out.print(s.artistList.get(i).getName());
            if (i + 1 < s.artistList.size()) {
                System.out.print(" & ");

            }
        }
        System.out.println(" __ " + s.path+ " __ "+s.duration+ " __ "+s.trackNumber);
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
               printThisSongInfo(s);
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
