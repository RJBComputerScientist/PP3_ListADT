package videoGame;

public class VideoGame {
	
	String title;
	char rating;
	float price;
	
	public VideoGame() {
		
	}
	
	public VideoGame(String title, char rating, float price) {
		this.title = title;
		this.rating = rating;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public char getRating() {
		return rating;
	}

	public void setRating(char rating) {
		this.rating = rating;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public String toString() {
		return "title: " + String.format("%-20s",title) + "   rating: " + rating + "   price: " + price;
	}
	

}
