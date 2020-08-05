package com.ak.texasholdem.player;

public class User {
	
	private String nickname;
	private String userName;
	private String password;
	private int id;
	private int cash;
	
	public User() {
		
	}
	
	
	public User(String nickname, String userName, String password, int cash) {
		super();
		this.nickname = nickname;
		this.userName = userName;
		this.password = password;
		this.cash = cash;
	}
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	protected String getUserName() {
		return userName;
	}

	protected void setUserName(String userName) {
		this.userName = userName;
	}

	protected String getPassword() {
		return password;
	}

	protected void setPassword(String password) {
		this.password = password;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}
	
	public int getId() {
		return id;
	}

}
