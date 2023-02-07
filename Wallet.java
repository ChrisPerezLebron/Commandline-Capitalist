import java.math.BigDecimal;

public class Wallet {
	private BigDecimal balance; 
	
	public Wallet() {
		balance = new BigDecimal("50");
		
	}
	
	
	public void deposit(String valueStr) {
		BigDecimal depositValue = new BigDecimal(valueStr); 
		balance = balance.add(depositValue); 
	}
	
	public BigDecimal balance() {
	
		/*
		 * this might not be necessary b/c from my understanding BigInteger objects are immutable anyways. 
		 * Hence, data hiding is kind of useless. But not 100% sure so it is safer than assuming. 
		 */
		return new BigDecimal(balance.toString()); 
	}
	
}
