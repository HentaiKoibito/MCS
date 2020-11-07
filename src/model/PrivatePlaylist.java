package model;
public class PrivatePlaylist extends Playlist{
	private User privateUser;
	public PrivatePlaylist(String playlistName,User user){
		super(playlistName);
		privateUser = user;
	}
	@Override
	public String getPlaylistInfo(){
		String info = "";
		info += getBasicInformation();
		info += "**  Playlist type: Private"+"\n";
		info += "**  Owner of the playlist: "+privateUser.getUserName()+"\n";
		info += "***********************************"+"\n";
		return info;
	}
}