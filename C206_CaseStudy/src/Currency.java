public class Currency {
	
	private String iso; 
	private String currencyName;
	private double buyRate;
	private double sellRate;
	
	public Currency(String iso, String currencyName, double buyRate, double sellRate) {
		this.iso = iso;
		this.currencyName = currencyName;
		this.buyRate = buyRate;
		this.sellRate = sellRate;
	}

	public String getIso() {
		return iso;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public double getBuyRate() {
		return buyRate;
	}

	public double getSellRate() {
		return sellRate;
	}
	
	public String toString()
	{
		String iso = this.iso;
		String currencyName = this.currencyName;
		String buyRate = Double.toString(this.buyRate);
		String sellRate = Double.toString(this.sellRate); 
		
		String output = iso + "," + currencyName + "," + buyRate+ "," + sellRate;
		return output ; 
		
	}
	
	

}
