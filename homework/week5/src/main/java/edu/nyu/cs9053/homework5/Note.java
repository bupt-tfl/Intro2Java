package edu.nyu.cs9053.homework5;

/**
 * User: blangel
 * Date: 2/20/17
 * Time: 4:02 PM
 */
public class Note {

    public static Note pause() {
        return new Note("");
    }

    private final String noteValue;

    public Note(String noteValue) {
        this.noteValue = noteValue;
    }

    public String getNoteValue() {
        return noteValue;
    }
}
