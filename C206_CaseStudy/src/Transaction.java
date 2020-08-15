import java.time.LocalDateTime;

public class Transaction {

	private LocalDateTime txnDate;
	private String type;
	private String ccyIn;
	private double amtIn;
	private String ccyout;
	private double amtOut;
	private double rate;
	
	public Transaction(LocalDateTime txnDate,String type , String ccyIn, double amtIn, String ccyOut, double amtOut, double rate) {
		this.txnDate = txnDate;
		this.type = type;
		this.ccyIn = ccyIn;
		this.amtIn = amtIn;
		this.ccyout = ccyOut;
		this.amtOut = amtOut;
		this.rate = rate;
	}
	
	public LocalDateTime getTxnDate() {
		return txnDate;
	}
	
	public String getType() {
		return type;
	}
	
	public String getCcyIn() {
		return ccyIn;
	}
	
	public double getAmtIn() {
		return amtIn;
	}
	
	public String Ccyout() {
		return ccyout;
	}
	
	public double getAmtOut() {
		return amtOut;
	}
	
	public double getRate() {
		return rate;
	}
	
	
}
