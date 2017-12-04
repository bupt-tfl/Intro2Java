public class Bassoon extends Aerophones{
	
	private final String name;
	private final int age;
	
	public Bassoon(String name, int age){
		super("obscure","422.112","https://en.wikipedia.org/wiki/Soprano","Aerophones");
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
		Bassoon that = (Bassoon) o;
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