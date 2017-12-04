package edu.nyu.cs9053.homework9;

import java.util.concurrent.Semaphore;

/**
 * User: blangel
 * Date: 4/3/16
 * Time: 2:18 PM
 */
public class ProducerConsumerFactory {
	private final static Semaphore semp = new Semaphore(1);

    public static Producer createProducer() {
	// TODO
		return new SeltzerProducer(semp);
    }

    public static Consumer createConsumer() {
	// TODO
		return new SeltzerConsumer(semp);
    }

}
