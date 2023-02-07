import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.locks.Lock;

public class MinerThread implements Runnable {
	
	private final int BASE_IDLE = 1000; //30000; //30 second idle
	
	private Random rand;
	
	private Lock balLock; //lock for balance manipulation
	private Wallet wallet; 
	
	
	private BigInteger blockCount; //the # of "blocks" harvested. Used to calculate level. Level affects drop chances 
	private double haste;	//lowers dead time between **possible** block finds
	private double fortuneChance; //chance of getting a fortune multiplier
	private double fortuneMultiplier; //multiplies profit earned on a successful block 
	
	private boolean autoSale; //if true product is sold immediately if false product goes into inventory [set to true by default] 
	
	
	public MinerThread(Lock lock, Wallet wallet) {
		
		rand = new Random(); 
		
		/*
		 * set up wallet and lock
		 */
		balLock = lock; 
		this.wallet = wallet; 
		
		/*
		 * initialize base stats 
		 */
		blockCount = new BigInteger("0");  
		haste = 1.0; 
		fortuneChance = 0.0001; // 0.01% chance
		fortuneMultiplier = 1.0; 
		
		autoSale = true; 
		
	}
		
	public void run() {  
		while(true) {
			try {
				Thread.sleep((int) (BASE_IDLE * haste) );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			breakBlock(); 
		}	
	}
	
	public void breakBlock() {
		double dropVal = rand.nextDouble() * 100; 
		
		if(dropVal <= 50.09765625) {
			//dirt was mined
			final double DIRT_PRICE_PER_BLOCK = 0.50; 
			
			if(autoSale) {
				sellBlock(DIRT_PRICE_PER_BLOCK, "Dirt"); 
			}
			
			blockCount = blockCount.add(new BigInteger("1")); 
		}
		else if(dropVal <= 75.09765625) {
			//sand was mined
		}
		else if(dropVal <= 87.59765625) {
			//stone was mined
		}
		else if(dropVal <= 93.84765625) {
			//Coal was mined
		}
		else if(dropVal <= 96.97265625) {
			//Iron was mined
		}
		else if(dropVal <= 98.53515625) {
			//Silver
		}
		else if(dropVal <= 99.31640625) {
			//Platinum
		}
		else if(dropVal <= 99.70703125) {
			//Gold
		}
		else if(dropVal <= 99.90234375) {
			//Diamond
		}
		else if (dropVal <= 100) {
			//Rhenium
		}
		
		
		
	}
	
	public void sellBlock(double pricePerBlock, String blockName) {
		double salePrice = 0.0; 
		if((rand.nextDouble() * 100) <= fortuneChance) 
			salePrice = pricePerBlock * fortuneMultiplier; 
		else 
			salePrice = pricePerBlock; 
		
		balLock.lock();
		wallet.deposit(Double.toString(salePrice));
		balLock.unlock();
		
		System.out.println("$" + salePrice + " " + blockName + " block found"); 
	}
	
	public void setAutoSale(boolean bool) {
		autoSale = bool; 
	}
}
