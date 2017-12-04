public abstract class Chordophones extends MusicalInstruments{
	
	protected final String origin;
	protected final String hsNumber;
	protected final String imageUrl;
	protected final String classificationName;
	
	
	protected Chordophones(String origin,String hsNumber,String imageUrl,String classificationName){
		this.origin = origin;
		this.hsNumber = hsNumber;
		this.imageUrl = imageUrl;
		this.classificationName = classificationName;
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
		return this.classificationName;
	}
	
	@Override public boolean equals(Object o){
		if(this == o){
			return true;
		}
		if(!(o == null || getClass() != o.getClass())){
		return false;
		}
		Chordophones that = (Chordophones) o;
		return this.getOrigin() == that.getOrigin() && this.getOrigin() == that.getHsNumber() &&
		this.getImageUrl() == that.getImageUrl() && this.getClassificationName() == that.getClassificationName();
	}
	@Override public int hashCode(){
		int hash = origin != null ? origin.hashCode() : 0;
		hash += 31 * (hsNumber != null ? hsNumber.hashCode() : 0);
		hash += 31 * (imageUrl != null ? imageUrl.hashCode() : 0);
		hash += 31 * (classificationName != null ? classificationName.hashCode() : 0);
		return hash;
	}
}