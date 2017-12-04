package edu.nyu.cs9053.homework9;

import java.util.concurrent.Semaphore;

public class SeltzerConsumer implements Consumer{
	private final Semaphore semp;
	
	public SeltzerConsumer(Semaphore semp){
		this.semp = semp;
	}
	@Override public Seltzer consume(VendingMachine from){
		try{
			semp.acquire();
			try{
				if(from.isEmpty()) {
					return null;
				}else{
	    			Seltzer seltzer = from.remove();      	    			
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

