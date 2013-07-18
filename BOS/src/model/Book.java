package model;

import java.util.Date;

public class Book {

	int collectionId;
	boolean status;
		
	public void setDescription(int isbn, String title, String author, Date year){
		Descriptions description = new Descriptions(isbn, title, author, year);
	}
	
	public int getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
