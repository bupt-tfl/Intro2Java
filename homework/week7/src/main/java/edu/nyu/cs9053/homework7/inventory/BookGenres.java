package edu.nyu.cs9053.homework7.inventory;

public class BookGenres<T extends Book> implements Item{
	private final Double price;
	private final T book;
	
	public BookGenres(double price,T book){
		this.price = price;
		this.book = book;
	}
	
	@Override public Double getPrice(){
		return this.price;
	}
	public T getBook(){
		return book;
	}

}
