public class Sanxian extends Chordophones{	
	
	private final String name;
	private final int age;
	
	public Sanxian(String origin,String hsNumber,String imageUrl,String classificationName,String name, int age){
		super(origin,hsNumber,imageUrl,classificationName);
		this.name = name;
		this.age = age;
	}
	
	public String getName(){
		return this.name;
	}
	public int getAge(){
		return this.age;
	}
	
	@Override public boolean equals(Object o){
		if(this == o){
			return true;
		}
		if(!(o == null || getClass() != o.getClass())){
			return false;
		}
		Sanxian that = (Sanxian) o;
		return this.getOrigin() == that.getOrigin() && this.getHsNumber() == that.getHsNumber() &&
			   this.getImageUrl() == that.getImageUrl() && this.getClassificationName() == that.getClassificationName() &&
			   this.name == that.getName() && this.age == that.getAge();
	}
	@Override public int hashCode(){
		int hash = name != null ? name.hashCode() : 0;
		hash += 31 * (age != -1 ? name.hashCode() : 0);
		hash += 31 * (origin != null ? origin.hashCode() : 0);
		hash += 31 * (hsNumber != null ? hsNumber.hashCode() : 0);
		hash += 31 * (imageUrl != null ? imageUrl.hashCode() : 0);
		hash += 31 * (classificationName != null ? classificationName.hashCode() : 0);
		return hash;
	}
}