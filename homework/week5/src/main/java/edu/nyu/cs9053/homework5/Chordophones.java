package edu.nyu.cs9053.homework5;

public abstract class Chordophones implements MusicalInstrument{
	
	private final String origin;
	private final String hsNumber;
	private final String imageUrl;
	private static final String CLASSIFICATION_NAME = "Chordophones";
	
	
	protected Chordophones(String origin,String hsNumber,String imageUrl){
		this.origin = origin;
		this.hsNumber = hsNumber;
		this.imageUrl = imageUrl;
	}
	
	@Override public String getOrigin(){
		return this.origin;
	}
	@Override public String getHsNumber(){
		return this.hsNumber;
	}
	@Override public String getImageUrl(){
		return this.imageUrl;
	}
	@Override public String getClassificationName(){
		return this.CLASSIFICATION_NAME;
	}
	
	@Override public boolean equals(Object o){
		if(this == o){
			return true;
		}
		if(!(o == null || getClass() != o.getClass())){
		return false;
		}
		Chordophones that = (Chordophones) o;
		return this.getOrigin().equals(that.getOrigin()) && this.getHsNumber().equals(that.getHsNumber()) &&
		this.getImageUrl().equals(that.getImageUrl()) && this.getClassificationName().equals(that.getClassificationName());
	}
	@Override public int hashCode(){
		int hash = origin != null ? origin.hashCode() : 0;
		hash = 31 * hash + hsNumber != null ? hsNumber.hashCode() : 0;
		hash = 31 * hash + imageUrl != null ? imageUrl.hashCode() : 0;
		hash = 31 * hash + CLASSIFICATION_NAME != null ? CLASSIFICATION_NAME.hashCode() : 0;
		return hash;
	}
}