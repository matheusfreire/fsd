package model;

import java.util.Date;

public class Descriptions {
	
	int isbn;
	String title;
	String author;
	Date year;
	
	public Descriptions(int isbn, String title, String author, Date year) {
			this.isbn = isbn;
			this.title = title;
			this.author = author;
			this.year = year;
	}

	public int getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Date getYear() {
		return year;
	}
	
	
	

}
