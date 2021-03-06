package edu.nyu.cs9053.homework10;

/**
 * User: blangel
 * Date: 4/12/16
 * Time: 7:16 PM
 */
public interface Fortification<T> {

    /**
     * Ensures there are soldiers to handle the attack and if so invokes the appropriate method on {@code handle}
     *
     * @param handler to invoke when there are soldiers to handle the request
     */
    void handleAttack(AttackHandler handler);

    /**
     * Stop any threads, called on defeat :(
     */
    void surrender();

}
