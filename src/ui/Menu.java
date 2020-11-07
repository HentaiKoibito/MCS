package ui;
import model.*;
import java.util.Scanner;
public class Menu{
	private final static int CREATE_A_USER = 1;
	private final static int SHOW_USERS = 2;
	private final static int CREATE_A_SONG = 3;
	private final static int SHOW_SONGS=4;
	private final static int CREATE_A_PLAYLIST=5;
	private final static int ADD_A_USER_TO_A_PLAYLIST=6;
	private final static int ADD_A_SONG_TO_A_PLAYLIST=7;
	private final static int ADD_A_RATE_TO_A_PUBLIC_PLAYLIST = 8;
	private final static int SHOW_PLAYLISTS=9;
	private final static int EXIT=10;
	private MusicCollectAndShare mcs;
	private static Scanner sc = new Scanner(System.in);
	
	public Menu(){
		mcs=new MusicCollectAndShare();
	}
	public void showBeginningImage(){
		String image = "";
		image += "((((((((((((((((((((((((((((((((((((((((((((((((("+"\n";
		image += "((((((((((((((((/(((((((((((((((((((((((((((((((("+"\n";
		image += "(((/  .(((((((*  .((((((*        (((((/      /((("+"\n";
		image += "(((/   .((((((.  .(((((   ,((((((((((*  .((((((("+"\n";
		image += "(((/    /((((/   .((((/  ,(((((((((((.  /(((((((("+"\n";
		image += "(((/     ((((*   .((((*  ,(((((((((((/   (((((((("+"\n";
		image += "(((/  *  *(((     ((((*  ,((((((((((((,  .((((((("+"\n";
		image += "(((/  /.  ((*     ((((*  *(((((((((((((,   (((((("+"\n";
		image += "(((/  //  ,(  .   ((((*  *((((((((((((((/   /(((("+"\n";
		image += "(((/  *(*  ,  (   ((((*  *((((((((((((((((   /((("+"\n";
		image += "(((/  ,(/    ,(   /(((*  ,(((((((((((((((((   ((("+"\n";
		image += "(((/  .((    ((   /((((  .(((((((((((((((((.  /(("+"\n";
		image += "(((/  .((.  .((.  *((((,  *((((((((((((((((   /(("+"\n";
		image += "(((/  .((((((((.  *(((((   *((((/,/(((((((/   ((("+"\n";
		image += "(((/  .((((((((.  *((((((.        *((   .   .(((("+"\n";
		image += "(((((((((((((((/*/((((((((((///(((((((////((((((("+"\n";
		image += "((((((((((((((((((((((((((((((((((((((((((((((((("+"\n";
		image += "               ./(###((///((###(*                "+"\n";
		image += "           *#(,                   *((,           "+"\n";
		image += "        ,#/                           ((         "+"\n";
		image += "      .#*          .**/////*,.          ((       "+"\n";
		image += "     *(.      .//////////////////*       *#      "+"\n";
		image += "    .#,     *///////////////////////,     /(     "+"\n";
		image += "    /(    *///////////////////////////    .#.    "+"\n";
		image += "  ,/////,*/////////////////////////////,*////*.  "+"\n";
		image += "  /////////////////////////*,...,/////////////,  "+"\n";
		image += "  //////*,,,********,,.............,,,,,//////,  "+"\n";
		image += "  //////*.........//*........//*.......,//////,  "+"\n";
		image += "  //////*.........,,.........,,........,//////,  "+"\n";
		image += "   //////*..............................,//////, "+"\n";
		image += "   *///*  ........,/.........**.......  .*///,   "+"\n";
		image += "            .......,/*.....,/*.......            "+"\n";
		image += "               ........,,,,.......               "+"\n";
		image += "                    .........                    "+"\n";
		image += "\n";
		image += "*************************************************"+"\n";
		System.out.println(image);
	}
	public void showMenu(){
		System.out.println("______________________________________________________________");
		System.out.println("Enter 1 to create a user");
		System.out.println("Enter 2 to show app users");
		System.out.println("Enter 3 to create a song");
		System.out.println("Enter 4 to show the songs in the pool");
		System.out.println("Enter 5 to create a playlist");
		System.out.println("Enter 6 to add a user to the playlist");
		System.out.println("Enter 7 to add a song to the playlist");
		System.out.println("Enter 8 to rate a public playlist");
		System.out.println("Enter 9 to show the playlists");
		System.out.println("Enter 10 to exit");
		System.out.println("______________________________________________________________");	
	}
	public void addAUser(){
		boolean aux = false;
		String password;
		String confirmPassword;
		System.out.println("Enter a username, remember your username is only the first word: ");
		String username=sc.next();
		System.out.println("Enter the user's age: ");
		int age = sc.nextInt();
		sc.nextLine();
		do{
		System.out.println("Enter a password: ");
		password=sc.nextLine();
		System.out.println("Confirm the password: ");
		confirmPassword=sc.nextLine();
		}
		while(!(password.equals(confirmPassword)));
		aux= mcs.createUser(username,password,age);
		System.out.println("The user ");
		checkRegister(aux);
	}
	public void checkRegister(boolean aux){
		if(aux){
			System.out.println("	was added successfully");
		}
		else{
			System.out.println("	could not be added, possibly due to an error");
		}
	}
	public void addASong(){
		int index = -1;
		System.out.println("Enter which user is going to add a song: ");
		String username = sc.nextLine();
		System.out.println("Enter password: ");
		String password = sc.nextLine();
		index = mcs.findUser(username,password);
		if(index != -1){
			createASong(username,password);
		}
		else {
			System.out.println("The song could not be added, invalid user or password ");
		}
	}
	public void createASong(String username,String password){
		boolean aux = false;
		System.out.println("Enter the name of the song: ");
		String songName = sc.nextLine();
		System.out.println("Enter the name of the artist or band of the song: ");
		String authorName = sc.nextLine();
		System.out.println("Enter the release date of the song in a DD/MM/YYYY format");
		String releaseDate = sc.nextLine();
		System.out.println("Enter the genre of the song, use 1 for rock, 2 for hiphop, 3 for classical music, 4 for reggae, 5 for salsa and 6 for metal: ");
		int genreIndicator = sc.nextInt();
		sc.nextLine();
		Duration songDuration=readTheDuration();
		aux = mcs.createSong(username,password,songName,authorName,releaseDate,genreIndicator,songDuration);
		System.out.println("The song ");
		checkRegister(aux);
	}
	public Duration readTheDuration(){
		System.out.println("Enter the duration of the song in a MM:SS format: ");
		String songDuration = sc.nextLine();
		int position = songDuration.indexOf(":");
		int minute = Integer.parseInt(songDuration.substring(0,position));
		songDuration = songDuration.substring(position+1);
		int second = Integer.parseInt(songDuration);
		Duration songLength = new Duration(minute,second);
		return songLength;
	}
	public void createAPlaylist(){
		int index=-1;
		boolean aux = false;
		System.out.println("Enter the name of the playlist");
		String playlistName = sc.nextLine();
		System.out.println("Enter the name of the user that is going to create the playlist ");
		String playlistUserName=sc.nextLine();
		System.out.println("Enter password");
		String password=sc.nextLine();
		index = mcs.findUser(playlistUserName,password);
		if(index != -1){
			System.out.println("Indicate what type of playlist you are going to create. Enter 1 for a private playlist, 2 for a restricted one, and 3 for a public one:");
			int choice=readOption();
			aux=addAPlaylist(choice,playlistName,index);
			System.out.println("The playlist ");
			checkRegister(aux);
		}
		else{
			System.out.println("The song could not be added, invalid user or password ");
		}
	
	}
	public boolean addAPlaylist(int choice,String playlistName,int index){
		User appUser = mcs.giveAUserWithIndex(index);
		boolean aux = false;
		switch(choice){
			case 1:
				aux=mcs.createPlaylist(playlistName,appUser);
				break;
			case 2:
				aux=mcs.createPlaylist(appUser,playlistName);
				break;
			case 3:
				aux=mcs.createPlaylist(playlistName);
				break;
			default:
				System.out.println("Please enter a valid option");
				break;
		}
		return aux;
	}
	public void userIntoAPlaylist(){
		int userIndex = -1;
		boolean aux = false;
		System.out.println("Enter the name of the user that you want to add: ");
		String playlistUserName=sc.nextLine();
		System.out.println("Enter the password");
		String password=sc.nextLine();
		userIndex = mcs.findUser(playlistUserName,password);
		if(userIndex != -1){
			System.out.println("Enter the name of the playlist in which the user will be added");
			String playlistName = sc.nextLine();
			int playlistIndex = mcs.findPlaylist(playlistName);
			if(playlistIndex != -1){
				if(mcs.playlistInstanceOf(playlistIndex)==2){
					aux = mcs.castAndAddAUserToPlaylist(playlistIndex,mcs.giveAUserWithIndex(userIndex));
					System.out.println("The user ");
					checkRegister(aux);
				}	
			}
			else {
				System.out.println("The playlist entered does not exist, is private or public");
			}
		}
		else{
			System.out.println("The user could not be added, invalid user or password ");
		}
	}
	public void songIntoAPlaylist(){
		int songIndex = -1;
		boolean aux = false;
		System.out.println("Enter the name of the song that you want to add: ");
		String songName = sc.nextLine();
		songIndex = mcs.findSong(songName);
		if(songIndex != -1){
			System.out.println("Enter the name of the playlist in which the song will be added");
			String playlistName = sc.nextLine();
			int playlistIndex = mcs.findPlaylist(playlistName);
			if(playlistIndex != -1){
				aux = mcs.giveASongToAPlaylist(playlistIndex,mcs.giveASongWithIndex(songIndex));
				System.out.println("The song ");
				checkRegister(aux);
			}
			else {
				System.out.println("The playlist entered does not exist or is private");
			}
		}
		else{
			System.out.println("The song could not be added, does not exist or the name is incorrect ");
		}
	}
	public void addARateToAPublicPlaylist(){
		System.out.println("Enter the name of the playlist you want to rate. Remember that it must be a Public Playlist");
		String playlistName = sc.nextLine();
		int playlistIndex = mcs.findPlaylist(playlistName);
		if(playlistIndex != -1 && mcs.playlistInstanceOf(playlistIndex) == 3){
			System.out.println("Enter what rating do you give to the playlist");
			double rating = sc.nextDouble();
			mcs.giveARateToAPublicPlaylist(playlistIndex,rating);
		}
		else{
			System.out.println("The playlist does not exist or is not public");
		}
	}
	public void doOperation(int choice){
		switch(choice){
			case CREATE_A_USER:
				addAUser();
				break;
			case SHOW_USERS:
				System.out.println(mcs.getAllInfoOfUsers());
				break;
			case CREATE_A_SONG:
				addASong();
				break;
			case SHOW_SONGS:
				System.out.println(mcs.getAllInfoOfSongs());
				break;
			case CREATE_A_PLAYLIST:
				createAPlaylist();
				break;
			case ADD_A_USER_TO_A_PLAYLIST:
				userIntoAPlaylist();
				break;
			case ADD_A_SONG_TO_A_PLAYLIST:
				songIntoAPlaylist();
				break;
			case ADD_A_RATE_TO_A_PUBLIC_PLAYLIST:
				addARateToAPublicPlaylist();
				break;
			case SHOW_PLAYLISTS:
				System.out.println(mcs.getAllInfoOfPlaylists());
				break;
			case EXIT:
				break;
			default:
				System.out.println("Please enter a valid option");
		}
	}
	public int readOption(){
		int choice = sc.nextInt();
		sc.nextLine();
		return choice;
	}
	public void startProgram(){
		int option=0;
		showBeginningImage();
		do{
			showMenu();
			option=readOption();
			doOperation(option);
		}while(option!=EXIT);
	}
}