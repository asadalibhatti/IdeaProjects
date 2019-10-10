import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class SimpleTextInterface {

	public static MP3 playerMP3;

	public static void main(String[] args) throws InterruptedException {
		Library l = new Library();
		l.loadMp3State();
//		List<Artist> artistList = new ArrayList<>();
//		artistList.add(new Artist("farhan"));
//		l.addSong(new Song("1", "C:\\1.mp3", 001, 30, artistList));
//
//		artistList = new ArrayList<>();
//		artistList.add(new Artist("sultan"));
//		artistList.add(new Artist("farhan"));
//		l.addSong(new Song("2", "C:\\2.mp3", 001, 30, artistList));
//		//l.viewAllSongs();
//
//		artistList = new ArrayList<>();
//		artistList.add(new Artist("arif lohar"));
//		//l.viewAllSongs();
//		l.addSong(new Song("3", "C:\\3.mp3", 001, 30, artistList), "Jugni");

		int n = -1;
		while ((n != 0)) {


			System.out.println("1 to View a list of all the songs in the library and see information about each song");
			System.out.println("2 to View a list of all the artists in the library");
			System.out.println("3 to View a list of all the albums in the library.");
			System.out.println("4 to Edit any information in the library.");
			System.out.println("5 to View a list of all the songs by a particular artist.");
			System.out.println("6 to View a list of all the songs on a particular album");
			System.out.println("7 to Add songs to and remove them from the library.");
			System.out.println("8 to Add artists to and remove them from songs.");
			System.out.println("9 to Add songs to and remove them from albums.");
			System.out.println("0 to STOP Program .... .");

			Scanner input = new Scanner(System.in);  // Create a Scanner object
			System.out.println("Enter Your Choice : ");

			n = input.nextInt();  // Read user input
			if (n == 1) {

				l.viewAllSongs();
				List<Song> songList = l.getAllSongs();
				l.playit(songList);
			}
			else if (n == 2) {
				l.viewAllArtists();
			} else if (n == 3) {
				l.viewAllAlbums();
			} else if (n == 4) {
				System.out.println("Enter  1 to edit song name, \n2 to adit path  : ");
				 input = new Scanner(System.in);
				String name1 = input.nextLine();  // Read user input
				if(name1.equals("1")) {
					System.out.println("Enter  Old Name of song : ");
					 name1 = input.nextLine();  // Read user input
					//Song s = l.getSongWithTitle(name1);

					System.out.println("Enter new  Name of song : ");
					String name = input.nextLine();  // Read user input
					if(!l.alreadyPresent(name,name)){
						l.editSongName(name1, name);
					}
					else
						System.out.println("Not edited , already present with same name");

				}
				else if(name1.equals("2")) {
					System.out.println("Enter  Old Name of song : ");
					input = new Scanner(System.in);
					name1 = input.nextLine();  // Read user input
					Song s = l.getSongWithTitle(name1);

					System.out.println("Enter new  path of song : ");
					String name = input.nextLine();  // Read user input
					if(!l.alreadyPresent(name,name)){
						l.editSongPath(name1, name);
					}
					else
						System.out.println("Not edited , already present with same name");

				}
			} else if (n == 5) {
				System.out.println("Enter Name of Artist : ");
				input = new Scanner(System.in);
				String name = input.nextLine();  // Read user input
				l.viewSongByArtist(new Artist(name));
				List<Song> songList = l.getSongWithArtistName(name);




				//
				l.playit(songList);









			}
			else if (n == 6) {
				System.out.println("Enter Name of Album : ");
				input = new Scanner(System.in);
				String name = input.nextLine();  // Read user input
				l.viewSongFromAlbum(new Album(name));
				List<Song> songList = l.getSongFromAlbum(name);

				l.playit(songList);


			} else if (n == 7) {
				System.out.println("Enter 1 to add song\n Enter 2 to remove song");
				//input = new Scanner(System.in);
				//System.out.println("Enter Your Choice : ");
				input = new Scanner(System.in);
				String title = input.nextLine();
				if (title.equals("1")) {
					System.out.println("Enter Song Name:");
					title = input.nextLine();
					Song s = new Song(title);
					System.out.println("Enter Song path:");
					title = input.nextLine();
					s.path = title;


					System.out.println("Enter Artist Name");
					title = input.nextLine();
					s.artistList.add(new Artist(title));
					System.out.println("Enter album Name");
					title = input.nextLine();


					l.addSong(s, title);
				} else if (title.equals("2")) {
					System.out.println("Enter Song Name:");
					input = new Scanner(System.in);
					title = input.nextLine();
					Song s = new Song(title);


					l.removeSong(s);
				}


			} else if (n == 8) {
				System.out.println("Enter 1 to add Artist\n Enter 2 to remove Artist");
				input = new Scanner(System.in);
				//System.out.println("Enter Your Choice : ");
				String title = input.nextLine();
				if (title.equals("1")) {
					System.out.println("Enter artist Name:");
					title = input.nextLine();
					Artist s = new Artist(title);


					l.addArtist(s);
				} else if (title.equals("2")) {
					System.out.println("Enter artist Name:");
					title = input.nextLine();
					Artist s = new Artist(title);


					l.removeArtist(s);


				}


			} else if (n == 9) {
				System.out.println("Enter 1 to add song\n Enter 2 to remove song");

				input = new Scanner(System.in);
				//System.out.println("Enter Your Choice : ");
				String title = input.nextLine();
				if (title.equals("1")) {
					System.out.println("Enter Song Name:");
					title = input.nextLine();
					Song s = new Song(title);
					System.out.println("Enter Song path:");
					title = input.nextLine();
					s.path = title;


					System.out.println("Enter Artist Name");
					title = input.nextLine();
					s.artistList.add(new Artist(title));
					System.out.println("Enter album Name");
					title = input.nextLine();


					l.addSong(s, title);
				} else if (title.equals("2")) {
					System.out.println("Enter Song Name:");
					title = input.nextLine();
					Song s = new Song(title);


					l.removeSong(s);
				} else
					System.out.println("Invalid input, plz enter again");
			}


			//		System.out.println(
//
//
//		List<Artist> artistList= new ArrayList<>();
//		artistList.add(new Artist("farhan"));
//		l.addSong(new Song("1","C:\\1.mp3",001,30,artistList));
//
//		artistList= new ArrayList<>();
//		artistList.add(new Artist("sultan"));
//		artistList.add(new Artist("farhan"));
//		l.addSong(new Song("2","C:\\2.mp3",001,30,artistList));
//		//l.viewAllSongs();
//
//		artistList= new ArrayList<>();
//		artistList.add(new Artist("arif lohar"));
//		//l.viewAllSongs();
//		l.addSong(new Song("3","C:\\3.mp3",001,30,artistList),"Jugni");
//		l.viewAllSongs();
			//l.removeSong(new Song("3","C:\\3.mp3",001,30,artistList));
			//l.viewAllSongs();
			//l.viewSongByArtist(new Artist("arif lohar"));
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
		//now save the state to file
	l.saveCurrentSateToFile();

	}
}