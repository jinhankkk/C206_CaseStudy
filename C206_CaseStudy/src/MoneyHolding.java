
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
		String holdingAmt = Double.toString(this.holdingAmt);
		
		return iso + "," + holdingAmt; 
	}

	public static int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static Object get(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
