package edu.nyu.cs9053.homework10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: blangel
 * Date: 4/12/16
 * Time: 7:27 PM
 */
public class ModernFortification extends AbstractFortification<ExecutorService> {
	
	private final ExecutorService executor;
	
	public ModernFortification(int concurrencyFactor){
		super(concurrencyFactor);
		this.executor = Executors.newFixedThreadPool(concurrencyFactor);
	}

	@Override
	public void handleAttack(final AttackHandler handler) {
		// TODO Auto-generated method stub
		for(int i = 0; i < getConcurrencyFactor(); i++){
			executor.submit(new Runnable(){
				@Override
				public void run(){
					handler.soldiersReady();
				}
			});
		}
		
	}

	@Override
	public void surrender() {
		// TODO Auto-generated method stub
		executor.shutdown();
		
	}

}
