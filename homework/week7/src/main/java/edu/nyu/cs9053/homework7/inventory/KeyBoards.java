package edu.nyu.cs9053.homework7.inventory;

public class KeyBoards<T extends Computer> implements Item{
	private final double price;
	private final T computer;
	public KeyBoards(double price, T computer){
		this.price = price;
		this.computer = computer;
	}
	@Override public Double getPrice(){
		return this.price;
	}
	public T getComputer(){
		return computer;
	}
}
