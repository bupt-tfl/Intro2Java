package edu.nyu.cs9053.homework7.inventory;

public abstract class Book implements Item{
	private final Double price;
	private final String title;
	
	public Book(double price, String title){
		this.price = price;
		this.title = title;
	}
	@Override public Double getPrice(){
		return this.price;
	}
	public String getTitle(){
		return this.title;
	}
}