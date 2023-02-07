import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Driver {

	public static void main(String[] args) throws IOException {
//		/*
//		 * add an initial menu that will allow the user to login or create a new game 
//		 */
//		
		Lock balanceLock = new ReentrantLock(); 
		Wallet wallet = new Wallet(); 
//		
		Thread miner1Thread = new Thread(new MinerThread(balanceLock, wallet)); 
		
		Thread miner2Thread = new Thread(new MinerThread(balanceLock, wallet)); 
		
		miner1Thread.start();
		
		
		miner2Thread.start();
		
//		try {
//			miner1Thread.join(); 
//			miner2Thread.join();
//		} catch(Exception e) {
//			
//		}
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(wallet.balance().toString()); 
		
		while(true) {
			if ( System.in.available() != 0 ) {
				System.out.println("everything has been haulted"); 
//	            int c = System.in.read();
//	            if ( c == 0x1B ) {
//	                    break;
//	            }
			}
		}
	}

}
