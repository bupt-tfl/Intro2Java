package edu.nyu.cs9053.homework5;

public class Xylophone extends Chordophones implements MusicalInstrument{
	
	private final String name;
	private final int age;
	
	public Xylophone(String name, int age){
		super("southeast Asia","111.212","https://en.wikipedia.org/wiki/Xylophone#/media/File:Kulintang_a_Kayo_01.jpg");
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
		Xylophone that = (Xylophone) o;
		return this.name.equals(that.getName()) && this.age == that.getAge();
	}
	@Override public int hashCode(){
		int hash = super.hashCode();
		hash = 31 * hash + name != null ? name.hashCode() : 0;
		hash = 31 * hash + age != -1 ? name.hashCode() : 0;
		return hash;
	}
}