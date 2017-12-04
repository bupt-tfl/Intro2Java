package edu.nyu.cs9053.homework5;

/**
 * User: blangel
 * Date: 2/20/17
 * Time: 4:02 PM
 */
public interface Musician {

    void playDitty(DittyCallback dittyCallback, MusicalInstrument instrument, Note ... notes);

    /**
     * @return beats per minute for which this musician is adroit at playing
     */
    long getTempo();
}
