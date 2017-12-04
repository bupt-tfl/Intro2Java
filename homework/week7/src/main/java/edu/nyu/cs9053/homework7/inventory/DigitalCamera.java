package edu.nyu.cs9053.homework7.inventory;

public abstract class DigitalCamera extends Camera{
	private final Integer zoom;
	
	public DigitalCamera(double price, Integer zoom){
		super(price);
		this.zoom = zoom;
	}
}