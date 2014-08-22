package springWeb;

public class User {
	
	private String name;
	private String nick;
	private String email;
	
	
	User() {}
	
	User(String name, String nick, String email) {
		
		this.name = name;
		this.nick = nick;
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNick() {
		return nick;
	}


	public void setNick(String nick) {
		this.nick = nick;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	

	public boolean equals(Object o) {
		
		if(!(o instanceof User))
			return false;
		
		User user2 = (User)o;
		if(this.name != "")
			return user2.getName().equals(this.name);
		else if(this.nick != "")
			return user2.getNick().equals(this.nick);
		
		return false;
	}
}
