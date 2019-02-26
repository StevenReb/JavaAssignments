

import java.io.Serializable;

public class TShirt implements Serializable {
	
	// Private variables
	private String text;
	private String size;
	private boolean gift;
	
	// Constructor
	public TShirt () {
		this.text = "";
		this.size = "";
		this.gift = false;
	}

	// Getters and Setters for all variables
	public String getText() {
		return this.text;
	};

	public void setText(String text) {
		this.text = text;
		System.out.println(text);
	};
	
	public String getSize() {
		return this.size;
	};
	
	public void setSize(String size) {
		this.size = size;
		System.out.println(size);
	};

	public boolean isGift() {
		return this.gift;
	};
	
	public void setGift(boolean gift) {
		this.gift = gift;
		System.out.println(gift);
	};

}
