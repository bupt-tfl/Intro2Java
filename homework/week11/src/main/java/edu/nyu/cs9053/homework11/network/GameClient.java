package edu.nyu.cs9053.homework11.network;

import edu.nyu.cs9053.homework11.game.Difficulty;
import edu.nyu.cs9053.homework11.game.GameProvider;
import edu.nyu.cs9053.homework11.game.screen.InputMove;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * User: blangel
 * Date: 11/15/15
 * Time: 3:32 PM
 *
 * A blocking IO implementation of a client which requests moves from a remote server implementing the
 * {@linkplain edu.nyu.cs9053.homework11.network.NetworkGameProvider}
 */
public class GameClient implements GameProvider {
    
    private final Difficulty difficulty;
    
    private final InputStream serverInput;
    
    private final OutputStream serverOutput;
    
    private static final Charset CHARSET = Charset.forName("UTF-8");

	public static GameClient construct(Difficulty difficulty) {
        try{
        	return new GameClient(difficulty,new Socket(GameServer.SERVER_HOST,GameServer.SERVER_PORT).getInputStream(),new Socket(GameServer.SERVER_HOST,GameServer.SERVER_PORT).getOutputStream());
        }catch(IOException ioe){
        	System.out.printf("Failed to construct client - %s%n", ioe.getMessage());
        	throw new RuntimeException(ioe);
        }
    	
    }

    public GameClient(Difficulty difficulty, InputStream serverInput, OutputStream serverOutput) {
    	this.difficulty = difficulty;
    	this.serverInput = serverInput;
    	this.serverOutput = serverOutput;
    }

	@Override
	public Difficulty getDifficulty() {
		return this.difficulty;
	}

	@Override
	public int getRandomNumberOfNextFoes() {
		
		try{
			serverOutput.write(getDifficulty().name().getBytes(CHARSET));
			BufferedReader inputReader = new BufferedReader(new InputStreamReader(serverInput));
			return Integer.parseInt(inputReader.readLine());
		}catch(IOException ioe){
			System.out.printf("Failed to get number of next foes - %s%n", ioe.getMessage());
		}		
		return 0;
	}

	@Override
	public InputMove getRandomNextMove() {
		
		try{
			serverOutput.write("getMove".getBytes(CHARSET));
			BufferedReader inputReader = new BufferedReader(new InputStreamReader(serverInput));
			return InputMove.valueOf(inputReader.readLine());
		}catch(IOException ioe){
			System.out.printf("Failed to get next move - %s%n",ioe.getMessage());
		}
		return null;
	}

}
