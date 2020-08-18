import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private Currency cc1;
	private Currency cc2;

	private MoneyHolding mh1;
	private MoneyHolding mh2;

	private Transaction t1;
	private Transaction t2;

	private ArrayList<Currency> currencyList;
	private ArrayList<MoneyHolding> holdingList;
	private ArrayList<Transaction> transactionList;

	@Before
	public void setUp() throws Exception {
		cc1 = new Currency("MYR", "Malaysia Ringt", 3.075, 3.070);
		cc2 = new Currency("KRW", "Korean Won", 878.73, 874.89);
		mh1 = new MoneyHolding("USD", 100000);
		mh2 = new MoneyHolding("MYR", 500000);

		currencyList = new ArrayList<>();
		currencyList.add(cc1);
		currencyList.add(cc2);
		
		holdingList = new ArrayList<>();
		holdingList.add(mh1);
		holdingList.add(mh2);
		
		transactionList = new ArrayList<>();

	}

	public void searchRateByCurrency() {

	}

	@Test
	public void addMoneyHoldingTest() {
		assertNotNull("Check the holding not empty.", holdingList);
	}
<<<<<<< HEAD
	
	@Test
	public void viewAllHoldingAndSgdValueTest() {
		// CHECK IF LIST NOT EMPTY
		assertNotNull("Check the currency not empty.", currencyList);
		assertNotNull("Check the holding not empty.", holdingList);
		holdingList.add(mh1);
		holdingList.add(mh2);
		currencyList.add(cc1);
		currencyList.add(cc2);
		assertEquals("Test if that Currency arraylist size is 2?", 2, currencyList.size());
		assertEquals("Test if that Holding arraylist size is 2?", 2, holdingList.size());
	
		String output = String.format("%-10s %-10s %-20s\n", "ISO" , "HOLDINGS" , "SGD_VALUE");
		
		for (int i =0; i < holdingList.size(); i++) {
			for (int j =0; j < currencyList.size(); j++) {
				String iso = currencyList.get(j).getIso();
				if (holdingList.get(i).getIso().equalsIgnoreCase(iso)) {
					String items [] = holdingList.get(i).toString().split(",");
					
					//GET SELL RATE
					double sellRate = currencyList.get(j).getSellRate();
					//CALCULATE SGD
					double sgdValue = Double.parseDouble(items[1]) * sellRate;
					double curValue = Double.parseDouble(items[1]);
					output += String.format("%-10s %-10.2f %-20.4f\n", items[0], curValue,sgdValue);
				}
				
				}
			}
		System.out.println(output);
=======

	public void addCurrencyTest() {
		assertNotNull("Check the currency not empty.", currencyList);
	}
	public void deleteCurrencyTest() { 
		assertNotNull("Check the currency exist.", currencyList);
>>>>>>> branch 'master' of https://github.com/jinhankkk/C206_CaseStudy.git
	}

	
	@Test
	public void searchHoldingAndSgdValueTest() {
		// CHECK IF LIST NOT EMPTY
		assertNotNull("Check the currency not empty.", currencyList);
		assertNotNull("Check the holding not empty.", holdingList);
		holdingList.add(mh1);
		holdingList.add(mh2);
		currencyList.add(cc1);
		currencyList.add(cc2);
		assertEquals("Test if that Currency arraylist size is 2?", 2, currencyList.size());
		assertEquals("Test if that Holding arraylist size is 2?", 2, holdingList.size());
		
		// CHECK IF THE EXPECTED OUTPUT SAME AS CASE STUDY
		String curToSearch = "USD";
		String output = String.format("%-10s %-10s %-20s\n", "ISO" , "HOLDINGS" , "SGD_VALUE");
		
		String iso = "";
		double holdingAmt = 0.0;
		
		boolean exist = false;
		// check if exist
		for (MoneyHolding i : holdingList) {
			if (i.getIso().equalsIgnoreCase(curToSearch)) {
			String items [] = i.toString().split(",");
			iso = items[0];
			holdingAmt = Double.parseDouble(items[1]);
			exist = true;
			break;
		}
		}
		// if exist
		if (exist == true) {
			for (int j =0; j <currencyList.size(); j++) {
				if (currencyList.get(j).getIso().equalsIgnoreCase(iso)) {
					//GET SELL RATE
					double sellRate = currencyList.get(j).getSellRate();
					//CALCULATE SGD
					double sgdValue = holdingAmt * sellRate;
					output += String.format("%-10s %-10.2f %-20.4f\n", iso, holdingAmt,sgdValue);	
				}	
			}	
		}
		System.out.println(output);
	}
}
