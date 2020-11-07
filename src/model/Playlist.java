package model;
public abstract class Playlist{ 
	private String playlistName;
	private Duration playlistDuration;
	private Genres playlistGenre;
	private Song[] playlistSongs;
	
	public Playlist(String playlistName){
		this.playlistName=playlistName;
		playlistSongs = new Song[30];
		playlistGenre=Genres.values()[6];
		playlistDuration=new Duration(0,0);
	}
	public String getPlaylistName(){
		return playlistName;
	}
	public void setPlaylistName(String playlistName){
		this.playlistName=playlistName;
	}
	public boolean checkGenreExistence(int genreIndicator) {
		for(int i=0;i<playlistSongs.length;i++){
			if((playlistSongs[i]!= null)&&(genreIndicator==(playlistSongs[i].getGenreIndicator())-1)){
				return true;
			}
		}
		return false;
	}
	public String putGenres(){
		String info = "";
		for(int i=0;i<6;i++){
			if(checkGenreExistence(i)){
				info += Genres.values()[i]+",";
			}
			else{
				info+= " ";
			}
		}	
		return info;
	}
	public void changeDuration(){
		int seconds = 0;
		int minutes = 0;
		int aux=0;
		for(int i=0;i<playlistSongs.length;i++){
			if(playlistSongs[i]!=null){
				seconds += playlistSongs[i].getSecondDuration();
				minutes += playlistSongs[i].getMinuteDuration();
			}	
		}
		aux = seconds%60;
		minutes += seconds/60;
		seconds = aux;
		playlistDuration.setMinute(minutes);
		playlistDuration.setSecond(seconds);
	}
	public String getBasicInformation(){
		changeDuration();
		String info="";
		info += "**************  Playlist **************"+"\n";
		info += "**  Title: "+getPlaylistName()+"\n";
		info += "**  Duration: "+playlistDuration.getDurationInfo()+"\n";
		info += "**  Genre: ";
		if(playlistSongs[0]!=null){
			info += putGenres()+"\n";	
		}
		else {
			info += playlistGenre.toString()+"\n";
		}
		return info;
	}
	public boolean songExists(Song poolSong){
		for(int i=0;i<playlistSongs.length;i++){
			if(playlistSongs[i]!=null){
				if((poolSong.getTitle()).equalsIgnoreCase(playlistSongs[i].getTitle())){
					return true;
				}		
			}			
		}
		return false;	
	}
	public boolean addASongToPlaylist(Song poolSong){
		if(!(songExists(poolSong))){
			for(int i=0;i<playlistSongs.length;i++){
				if(playlistSongs[i]==null){
					playlistSongs[i]=poolSong;
					return true;
				}	
			}
		}	
		return false;
	}
	public abstract String getPlaylistInfo();
}