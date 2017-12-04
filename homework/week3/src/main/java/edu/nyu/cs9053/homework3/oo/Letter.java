import java.io.PrintStream;


public class Letter{
	
	public final char[][] letter; 
	public final PrintStream ps;
	
	public Letter(char[][] letter, PrintStream ps){
		this.letter = letter;
		this.ps = ps;
	}
	
	public void print(){		
		for(int i = 0; i < letter.length; i++){
			for(int j = 0; j < letter[0].length; j++){
				ps.print(letter[i][j]);
			}
			ps.println();
		}
	}
	
	
}