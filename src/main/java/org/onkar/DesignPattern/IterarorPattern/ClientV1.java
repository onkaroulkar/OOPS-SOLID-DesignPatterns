package org.onkar.DesignPattern.IterarorPattern;

public class ClientV1 {

	public static void main(String[] args) {
		BookCollection book1 = new BookCollection();
		book1.addBook(new Book("Java Book"));
		book1.addBook(new Book(" Python Book"));
	}

}
