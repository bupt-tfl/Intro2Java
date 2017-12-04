package edu.nyu.cs9053.homework11.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import edu.nyu.cs9053.homework11.game.Difficulty;

/**
 * User: blangel
 * Date: 11/15/15
 * Time: 3:31 PM
 *
 * A NIO implementation of a NetworkGameProvider.
 *
 * The server takes the following commands:
 * <pre>
 *     foes Difficulty
 * </pre>
 * <pre>
 *     move
 * </pre>
 * where the String "foes Easy" would be a call to {@linkplain NetworkGameProvider#getRandomNumberOfNextFoes(String)}
 * with "Easy"
 * and a call using String "move" would be a call to {@linkplain NetworkGameProvider#getRandomNextMove()}
 */
public class GameServer implements NetworkGameProvider, Runnable {

    public static final String SERVER_HOST = "localhost";

    public static final int SERVER_PORT = 8080;
    
    private final Selector selector;
    
    private final ServerSocketChannel serverChannel;
    
    private final ByteBuffer serverBuffer;
    
    private final HashMap<SocketChannel,ByteBuffer> clientBufferMap;
    
    private static final Charset CHARSET = Charset.forName("UTF-8");

    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer();
        server.run();
    }

    public GameServer() throws IOException {
    	
    	this.serverChannel = ServerSocketChannel.open();
    	this.selector = Selector.open();
    	this.serverBuffer = ByteBuffer.allocate(4096);
    	this.clientBufferMap = new HashMap<>();
    	
    	serverChannel.bind(new InetSocketAddress(SERVER_HOST,SERVER_PORT));
    	serverChannel.configureBlocking(false);
    	serverChannel.register(selector, SelectionKey.OP_ACCEPT);
    	
    	
    }

	@Override
	public void run() {
		while(true){
			try {
				int readyChannels = this.selector.select();
				if (readyChannels == 0) continue;

				Iterator<SelectionKey> iter = this.selector.selectedKeys().iterator();
				while(iter.hasNext()){
					try{
						SelectionKey key = iter.next();
						
						if(key.isAcceptable()){
							
							SocketChannel clientChannel = serverChannel.accept();
							clientChannel.configureBlocking(false);	
							clientChannel.register(this.selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
							clientBufferMap.put(clientChannel, ByteBuffer.allocate(4096));
						} else if(key.isReadable()){
							SocketChannel clientChannel = (SocketChannel) key.channel();
							serverBuffer.clear();
							try{
								String data = new String(serverBuffer.array(),CHARSET);
								ByteBuffer writeBuffer = clientBufferMap.get(clientChannel);
								if(data.substring(0,7).equals("getMove")){
									writeBuffer.put(ByteBuffer.wrap(getRandomNextMove().getBytes(CHARSET)));
									writeBuffer.put((byte)'\n');
								}else{
									writeBuffer.put(ByteBuffer.wrap(getRandomNumberOfNextFoes(data).getBytes(CHARSET)));
	                                writeBuffer.put((byte)'\n');
								}
							}catch(Exception e){
								clientBufferMap.remove(clientChannel);
								key.cancel();
							}
								
						} else if(key.isWritable()){
							SocketChannel clientChannel = (SocketChannel) key.channel();
							ByteBuffer writeBuffer = clientBufferMap.get(clientChannel);
							if(writeBuffer == null || writeBuffer.position() == 0) continue;
							
							writeBuffer.flip();
							clientChannel.write(writeBuffer);
							writeBuffer.clear();
						}
					}finally{
						iter.remove();
					}
				}
			} catch (IOException ioe) {
			
				System.out.printf("Failed to run - %s%n", ioe.getMessage());
			}
		}
	}

	@Override
	public String getRandomNumberOfNextFoes(String difficulty) {
		Random random = new Random();
		
		try{
			int level = Difficulty.valueOf(difficulty).getLevel();
			int randomNumber = random.nextInt(level+1);
			return Integer.toString(randomNumber);
		} catch(Exception e){
			
			return String.valueOf(random.nextInt(Difficulty.Easy.getLevel()+1));
		}
		
	}

	@Override
	public String getRandomNextMove() {
		
		Random random = new Random();
		double randomNumber = random.nextInt(20);
		if(randomNumber < 5){
			return "UP";
		}else if(randomNumber >=5 && randomNumber <10){
			return"Down";
		}else if(randomNumber >=10 && randomNumber <15){
			return "Right";
		}else{
			return "Left";
		}
	}
	

}
