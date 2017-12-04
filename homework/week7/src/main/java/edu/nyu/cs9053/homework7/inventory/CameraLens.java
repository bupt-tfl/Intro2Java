package edu.nyu.cs9053.homework7.inventory;

public class CameraLens <T extends Camera> implements Item{
	private final Double price;
	private final T camera;
	
	public CameraLens(Double price, T camera){
		this.price = price;
		this.camera = camera;
	}
	@Override public Double getPrice(){
		return this.price;
	}
	
	public T getCamera(){
		return camera;
	}

}