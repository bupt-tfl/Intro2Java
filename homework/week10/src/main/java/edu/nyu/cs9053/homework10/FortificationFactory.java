package edu.nyu.cs9053.homework10;

import java.util.concurrent.ExecutorService;

/**
 * User: blangel
 * Date: 4/12/16
 * Time: 7:31 PM
 */
public class FortificationFactory {

    public static Fortification<Thread> createMiddleAges(int concurrencyFactor) {
        // TODO - return proper Fortification<Thread> implementation - remove this comment as well once completed
        return new MiddleAgesFortification(concurrencyFactor); 
    }

    public static Fortification<ExecutorService> createModern(final int concurrencyFactor) {
        // TODO - return proper Fortification<Thread> implementation - remove this comment as well once completed
        return new ModernFortification(concurrencyFactor);
    }

}
