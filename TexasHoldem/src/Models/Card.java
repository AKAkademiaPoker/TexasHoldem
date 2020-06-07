package Models;

public class Card {
	private int ID;
	private int value;
	private String name;

	public Card(int iD, int value, String name) {
		super();
		ID = iD;
		this.value = value;
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name).append(" ").append(value);
		return builder.toString();
	}

}
