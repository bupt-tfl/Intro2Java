package edu.nyu.cs9053.homework5;

/**
 * User: blangel
 * Date: 2/21/17
 * Time: 8:42 AM
 */
public abstract class Rhythm {

    /**
     * @return duration between {@linkplain Note} in milliseconds
     */
    public abstract long getDuration();

    public void perform() {
        long duration = getDuration();
        try {
            Thread.sleep(duration);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(ie);
        }
    }

}
