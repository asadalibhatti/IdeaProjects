import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class SimpleTextInterface {
	
	public static MP3 playerMP3;

	public static void main(String[] args) throws InterruptedException {

		Library l=new Library();

		List<Artist> artistList= new ArrayList<>();
		artistList.add(new Artist("farhan"));
		l.addSong(new Song("1","C:\\1.mp3",001,30,artistList));

		artistList= new ArrayList<>();
		artistList.add(new Artist("sultan"));
		artistList.add(new Artist("farhan"));
		l.addSong(new Song("2","C:\\2.mp3",001,30,artistList));
		//l.viewAllSongs();

		artistList= new ArrayList<>();
		artistList.add(new Artist("arif lohar"));
		//l.viewAllSongs();
		l.addSong(new Song("3","C:\\3.mp3",001,30,artistList),"Jugni");
		l.viewAllSongs();
		l.removeSong(new Song("3","C:\\3.mp3",001,30,artistList));
		l.viewAllSongs();
		//l.viewSongByArtist(new Artist("farhan"));
//		l.viewAllArtists();
//
//		l.addArtistToSong(new Song("3","C:\\3.mp3",001,30,artistList),new Artist("malangi"));
//		l.viewAllArtists();
//		l.viewAllSongs();





		//		 MP3 playerMP3 = new MP3("C:\\Users\\Asad Ali Bhatti\\IdeaProjects\\p2\\src\\1.mp3");//specify a path for the mp3 file here
//		//playerMP3.getAlbum()
//		playerMP3.play();
//		sleep(1,4);
//		//playerMP3.stop();
		
	}	
}
