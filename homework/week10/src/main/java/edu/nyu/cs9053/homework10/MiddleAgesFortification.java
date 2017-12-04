package edu.nyu.cs9053.homework10;

import java.util.concurrent.ArrayBlockingQueue;


/**
 * User: blangel
 * Date: 4/12/16
 * Time: 7:28 PM
 */
public class MiddleAgesFortification extends AbstractFortification<Thread>{
	
	private Thread threads[];
	
	private final ArrayBlockingQueue<Runnable> queue;
	
	public MiddleAgesFortification(int  concurrencyFactor){
		super(concurrencyFactor);
		queue = new ArrayBlockingQueue<Runnable>(concurrencyFactor);
		threads = new Thread[concurrencyFactor];
		for(int i = 0; i < concurrencyFactor; i++){
			threads[i] = new Thread(new Runnable(){
				@Override
				public void run(){
					while(!Thread.currentThread().isInterrupted()){
						
							Runnable handle = null;
							try {
								handle = queue.take();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							handle.run();
					
					}
				}
			});
			threads[i].start();			
		}
		
	}
	

	@Override
	public void handleAttack(final AttackHandler handler) {
		// TODO Auto-generated method stub
		try {
			queue.put(new Runnable(){
					@Override
					public void run(){
						handler.soldiersReady();
					}
				});
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void surrender() {
		// TODO Auto-generated method stub
		Thread.currentThread().interrupt();
		
	}


}
