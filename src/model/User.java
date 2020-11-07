package model;
public class User {
	private String userName;
	private String password;
	private int age;
	private int songsAdded;
	private int categoryIndicator;
	private Category category;
	
	public User(String userName,String password,int age){
		this.userName = userName;
		this.password = password;
		this.age = age;
		categoryIndicator=1;
		category=Category.values()[categoryIndicator-1];
	}
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age=age;
	}
	public void setCategory(int categoryIndicator){
		category=Category.values()[categoryIndicator-1];
	}
	public void songsAddedCounter(){
		songsAdded++;
	}
	public void changeCategory(){
		int levelCategory=0;
		if(songsAdded<3){
			levelCategory=1;
		}
		else if(songsAdded<10){
			levelCategory=2;
		}
		else if(songsAdded<30){
			levelCategory=3;
		}
		else{
			levelCategory=4;
		}
		setCategory(levelCategory);
	}
	public String getUserInformation(){
		changeCategory();
		String info = "";
		info += "*************  User **************"+"\n";
		info += "**  userName: "+getUserName()+"\n";
		info += "**  Age: "+getAge()+"\n";
		info += "**  Category: "+category.toString()+"\n";
		info += "***********************************"+"\n";
		return info;
	}
	
}