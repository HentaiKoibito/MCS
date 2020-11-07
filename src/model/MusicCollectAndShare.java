package model;
public class MusicCollectAndShare  {
	private User[] users;
	private Song[] poolSongs;
	private Playlist[] playlistCollection;
	
	public MusicCollectAndShare(){
		users = new User[10];
		poolSongs = new Song[30];
		playlistCollection = new Playlist[20];
	}
	public boolean createUser(String username,String password,int age){
		for(int i=0;i<users.length;i++){
			if(users[i]==null){
				users[i]=new User(username,password,age);
				return true;
			}
		}
		return false;
	}
	public String getAllInfoOfUsers(){
		String info="";
		for(int i=0;i<users.length;i++){
			if(users[i]!=null){
					info += users[i].getUserInformation();
			}	
		}
		return info;
	}
	public String getAllInfoOfSongs(){
		String info="";
		for(int i=0;i<poolSongs.length;i++){
			if(poolSongs[i]!=null){
				info += poolSongs[i].getSongInformation();
			}
		}
		return info;
	}
	public String getAllInfoOfPlaylists(){
		String info="";
		for(int i=0;i<playlistCollection.length;i++){
			if(playlistCollection[i]!=null){
				info += playlistCollection[i].getPlaylistInfo();
			}
		}
		return info;
	}	
	public boolean createPlaylist(String playlistName,User playlistUser){
		for(int i=0;i<playlistCollection.length;i++){
			if(playlistCollection[i]==null){
				playlistCollection[i]=new PrivatePlaylist(playlistName,playlistUser);
				return true;
			}	
		}
		return false;
	}
	public boolean createPlaylist(User playlistUser,String playlistName){
		for(int i=0;i<playlistCollection.length;i++){
			if(playlistCollection[i]==null){
				playlistCollection[i]=new RestrictedPlaylist(playlistUser,playlistName);
				return true;
			}	
		}
		return false;
	}
	public boolean createPlaylist(String playlistName){
		for(int i=0;i<playlistCollection.length;i++){
			if(playlistCollection[i]==null){
				playlistCollection[i]=new PublicPlaylist(playlistName);
				return true;
			}	
		}
		return false;
	}
	public boolean createSong(String name,String password,String title,String authorName,String releaseDate,int genre,Duration songDuration){
			for(int i=0;i<poolSongs.length;i++){
				if(poolSongs[i]==null){
					poolSongs[i]=new Song(title,authorName,releaseDate,genre,songDuration);
					users[findUser(name,password)].songsAddedCounter();
					return true;
				}
			}	
		return false;
	}
	public int findUser(String name,String password){
		int index=-1;
		for(int i=0;i<users.length;i++){
			if(users[i]!=null){
				if((name.equalsIgnoreCase(users[i].getUserName()))&&(password.equalsIgnoreCase(users[i].getPassword()))){
					index=i;
				}
			}
		}
		return index;	
	}
	public int findSong(String title){
		int index=-1;
		for(int i=0;i<poolSongs.length;i++){
			if(poolSongs[i]!=null){
				if((title.equalsIgnoreCase(poolSongs[i].getTitle()))){
					index=i;
				}
			}
		}
		return index;	
	}
	public int findPlaylist(String playlistName){
		int index=-1;
		for(int i=0;i<playlistCollection.length;i++){
			if(playlistCollection[i]!=null){
				if((playlistName.equalsIgnoreCase(playlistCollection[i].getPlaylistName()))){
					index=i;
				}
			}
		}
		return index;
	}
	public int playlistInstanceOf(int index){
		if(playlistCollection[index] instanceof PrivatePlaylist){
			return 1;
		}
		else if(playlistCollection[index] instanceof RestrictedPlaylist){
			return 2;
		}
		return 3;
	}
	public boolean castAndAddAUserToPlaylist(int index,User appUser){
		boolean aux=false;
		if(playlistInstanceOf(index)==2){
			RestrictedPlaylist rP = (RestrictedPlaylist) playlistCollection[index];
			aux=rP.addAUserToPlaylist(appUser);
			playlistCollection[index]= rP;
		}
		return aux;
	}
	public boolean giveASongToAPlaylist(int index,Song appSong){
		boolean aux=false;
		aux=playlistCollection[index].addASongToPlaylist(appSong);
		return aux;
	}
	public void giveARateToAPublicPlaylist(int index,double userRating){
		if(playlistInstanceOf(index)==3){
			PublicPlaylist pP= (PublicPlaylist) playlistCollection[index];
			pP.changeRating(userRating);
			playlistCollection[index]=pP;
		}
	}
	public User giveAUserWithIndex(int index){
		return users[index];
	}
	public Song giveASongWithIndex(int index){
		return poolSongs[index];
	}
}