package model;
public class Song{
	private String title;
	private String authorName;
	private String releaseDate;
	private int genreIndicator;
	private Genres songGenre;
	private Duration songDuration;
	public Song(String title,String authorName,String releaseDate,int genreIndicator,Duration songDuration){
		this.title=title;
		this.authorName=authorName;
		this.releaseDate = releaseDate;
		this.genreIndicator=genreIndicator;
		songGenre = Genres.values()[genreIndicator-1];
		this.songDuration=songDuration;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public String getAuthorName(){
		return authorName;
	}
	public void setAuthorName(String authorName){
		this.authorName=authorName;
	}
	public String getReleaseDate(){
		return releaseDate;
	}
	public void setReleaseDate(String authorName){
		this.releaseDate=releaseDate;
	}
	public int getGenreIndicator(){
		return genreIndicator;
	}
	public void setGenreIndicator(int genre){
		this.genreIndicator=genreIndicator;
	}
	public int getMinuteDuration(){
		return songDuration.getMinute();
	}
	public int getSecondDuration(){
		return songDuration.getSecond();
	}
	public String getSongInformation(){
		String info = "";
		info += "**************  Song **************"+"\n";
		info += "**  Title: "+getTitle()+"\n";
		info += "**  Artist: "+getAuthorName()+"\n";
		info += "**  Duration: "+songDuration.getDurationInfo()+"\n";
		info += "**  Genre: "+songGenre.toString()+"\n";
		info += "***********************************"+"\n";
		return info;
	}
}