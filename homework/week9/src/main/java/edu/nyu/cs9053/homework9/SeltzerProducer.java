package edu.nyu.cs9053.homework9;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SeltzerProducer implements Producer {
	private final Semaphore semp;
	public SeltzerProducer(Semaphore semp){
		this.semp = semp;
	}
	@Override public Seltzer produce(VendingMachine into){
		try{
			semp.acquire();
			try{
				if(into.atCapacity()) {
					return null;
				}else{
					Random random = new Random();
	    			Flavor[] flavors = Flavor.values();
	    			Flavor flavor = flavors[random.nextInt(flavors.length)];
	    			Seltzer seltzer = new Seltzer(flavor);
	    			into.add(seltzer);
	    			return seltzer;
				}	
			} catch(Exception e){
				
			}finally{
				semp.release();
			}
		} catch(InterruptedException e){
			}
		return null;
	}
}

