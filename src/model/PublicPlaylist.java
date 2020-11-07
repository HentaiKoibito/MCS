package model;
public class PublicPlaylist extends Playlist{
	private double playlistRating;
	private int ratesAdded;
	public PublicPlaylist (String playlistName){
		super(playlistName);
		this.playlistRating = playlistRating;
		playlistRating=0;
		ratesAdded=0;
	}
	public void changeRating(double userRating){
		playlistRating+=userRating;
		ratesAdded++;
	}
	@Override
	public String getPlaylistInfo(){
		String info = "";
		info += getBasicInformation();
		info += "**  Playlist type: Public"+"\n";
		info += "**  Rating: "+(playlistRating/ratesAdded)+"\n";
		info += "***********************************"+"\n";
		return info;
	}
}
