import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Transaction {

	private LocalDateTime txnDate;
	private String type;
	private String ccyIn;
	private double amtIn;
	private String ccyout;
	private double amtOut;
	private double rate;
	
	public Transaction(LocalDateTime txnDate,String type , String ccyIn, double amtIn, String ccyOut, double amtOut, double rate) {
		this.txnDate = LocalDateTime.now();
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
	
	public String toString() {
		
		LocalDateTime now = LocalDateTime.now();
		String formattedDate = now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
		
		String type = this.type;
		String ccin = this.ccyIn;
		String amtin = String.valueOf(this.amtIn);
		String ccout = this.ccyout;
		String amtout = String.valueOf(this.amtOut);
		String rate = String.valueOf(this.rate);
		
		return formattedDate+","+type+","+ccin+","+amtin+","+ccout+","+amtout+","+rate;
	}
	
}
