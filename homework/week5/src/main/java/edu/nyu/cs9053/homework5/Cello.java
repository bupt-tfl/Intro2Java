package edu.nyu.cs9053.homework5;

public class Cello extends Chordophones implements MusicalInstrument{
	
	private final String name;
	private final int age;
	
	public Cello(String origin,String hsNumber,String imageUrl,String name, int age){
		super(origin,hsNumber,imageUrl);
		this.name = name;
		this.age = age;
	}
	
	public String getName(){
		return this.name;
	}
	public int getAge(){
		return this.age;
	}
	
	@Override public void play(Rhythm rhythm, Note note, NoteCallback noteCallback){
		rhythm.perform();
		noteCallback.notePlayed(note);
	}
	
	@Override public boolean equals(Object o){
		if(!super.equals(o)){
			return false;
		}
		Cello that = (Cello) o;
		return this.name.equals(that.getName()) && this.age == that.getAge();
	}
	@Override public int hashCode(){
		int hash = super.hashCode();
		hash = 31 * hash + name != null ? name.hashCode() : 0;
		hash = 31 * hash + age != -1 ? name.hashCode() : 0;
		return hash;
	}
}