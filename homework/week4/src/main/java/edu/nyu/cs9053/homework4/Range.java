public enum Range{
	
	Soprano(270,1050),
	Alto(175,700),
	Tenor(125,440),
	Baritone(110,500),
	Bass(74,330);
	
	private final int lowHz;
	private final int highHz;
	
	Range(int lowHz,int highHz){
		this.lowHz = lowHz;
		this.highHz = highHz;
	}
	
	public int getLowHz(){
		return this.lowHz;
	}
	public int getHighHz(){
		return this.highHz;
	}
	
	public static void varargs(Range ... arguments){
		for(Range argument : arguments){
			System.out.printf("%d %d %n", argument.lowHz, argument.highHz);
		}
	}
	
}