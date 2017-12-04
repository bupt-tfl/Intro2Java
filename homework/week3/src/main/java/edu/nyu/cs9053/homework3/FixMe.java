package edu.nyu.cs9053.homework3;

import edu.nyu.cs9053.homework3.metadata.Processor;


/**
 * User: blangel
 * Date: 8/23/14
 * Time: 11:45 AM
 */
public class FixMe {

    private final String name;

    public final String metadata;

    public FixMe(String name) {
        this.name = name;

		this.metadata = "";

    }

    public FixMe(String name, String metadata) {
        this.name = name;

		this.metadata = metadata;
        metadata = new Processor(true).processMetadata(metadata);

    }

    public FixMe changeName(String name) {
        return new FixMe(name);
    }


    public FixMe changeName(String firstName, String lastName, String metadata) {

        return new FixMe(changeName(firstName, lastName), metadata);
    }

    public String changeName(String firstName, String lastName) {
        return String.format("%s %s", firstName, lastName);
    }

    public String getName() {
        return name;
    }

}
