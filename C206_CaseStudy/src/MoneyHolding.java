
public class MoneyHolding {

	private String iso;
	private double holdingAmt;
	
	public MoneyHolding(String iso, double holdingAmt) {
		this.iso = iso;
		this.holdingAmt = holdingAmt;
	}
	
	public String getIso() {
		return iso;
	}
	
	public double getHoldingAmt() {
		return holdingAmt;
	}
	
	public String toString() {
		String iso = this.iso;
		String holdings = Double.toString(this.holdingAmt);
		
		return iso + "," + holdings;
	}
	
}
