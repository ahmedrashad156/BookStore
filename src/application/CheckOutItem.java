package application;

public class CheckOutItem {
	private String title;
	private String isbn;
	private String copies;
	private int price;
	
	public CheckOutItem(String title, String isbn, String copies, int price) {
		this.title = title;
		this.isbn = isbn;
		this.copies = copies;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getCopies() {
		return copies;
	}

	public void setCopies(String copies) {
		this.copies = copies;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
