package edu.nyu.cs9053.homework5;

public class Bassoon extends Aerophones implements MusicalInstrument{
	
	private final String name;
	private final int age;
	
	public Bassoon(String name, int age){
		super("obscure","422.112","https://en.wikipedia.org/wiki/Soprano");
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
		Bassoon that = (Bassoon) o;
		return this.name.equals(that.getName()) && this.age == that.getAge();
	}
	@Override public int hashCode(){
		int hash = super.hashCode();
		hash = 31 * hash + name != null ? name.hashCode() : 0;
		hash = 31 * hash + age != -1 ? name.hashCode() : 0;
		return hash;
	}
}