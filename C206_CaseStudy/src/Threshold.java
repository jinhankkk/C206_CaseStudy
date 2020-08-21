
public class Threshold extends MoneyHolding {
	
	private double thresholdAmount;
	
	public Threshold(String iso, double holdingAmt, double thresholdAmount) {
		super(iso, holdingAmt);
		this.thresholdAmount = thresholdAmount;
	}
	
	public double getThresholdAmount() {
		return thresholdAmount;
	}
	
}
