package edu.nyu.cs9053.homework10;

public abstract class AbstractFortification<T> implements Fortification<T>, ConcurrencyFactorProvider{
	
	private final int concurrencyFactor;
	
	public AbstractFortification(int concurrencyFactor){
		this.concurrencyFactor = concurrencyFactor;
	}
	
	@Override
	public int getConcurrencyFactor() {
		// TODO Auto-generated method stub
		return this.concurrencyFactor;
	}
	
	@Override
	public void handleAttack(AttackHandler handler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surrender() {
		// TODO Auto-generated method stub
		
	}
}
