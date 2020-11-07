package model;
public class RestrictedPlaylist extends Playlist implements UserRelatedMethods{
	private final static int PLAYLIST_SIZE=5;
	private User[] playlistUsers;
	public RestrictedPlaylist (User user,String playlistName){
		super(playlistName); 
		playlistUsers = new User[PLAYLIST_SIZE];
		playlistUsers[0]=user;
	}
	public boolean userExists(User appUser){
		for(int i=0;i<playlistUsers.length;i++){
			if(playlistUsers[i] != null){
				if((appUser.getUserName()).equalsIgnoreCase(playlistUsers[i].getUserName())){
					return true;
				}		
			}	
		}
		return false;
	}
	public boolean addAUserToPlaylist(User appUser){
		if(!(userExists(appUser))){
			for(int i=0;i<playlistUsers.length;i++){
				if(playlistUsers[i]==null){
					playlistUsers[i]=appUser;
					return true;
				}
			}
		}	
		return false;
	}
	@Override
	public String getPlaylistInfo(){
		String info = "";
		info += getBasicInformation();
		info += "**  Playlist type: Restricted"+"\n";
		info += "**  Users with access: ";
		for(int i=0;i<playlistUsers.length;i++){
			if(playlistUsers[i]!=null){
				info+= playlistUsers[i].getUserName()+", ";
			}	
		}
		info += "\n"+"***********************************"+"\n";
		return info;
	}
}