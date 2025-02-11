package org.onkar.DesignPattern.IterarorPattern;

import java.util.ArrayList;
import java.util.List;

public class BookCollection {
	public List<Book> bookList = new ArrayList<>();
	
	public void addBook(Book book) {
		bookList.add(book);
	}
}
