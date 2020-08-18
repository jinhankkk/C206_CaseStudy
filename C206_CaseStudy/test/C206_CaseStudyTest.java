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

	//MEMBER 4 - SEARCH BY CURRENCY TEST
	@Test
	public void searchRateByCurrency() {
		//CHECK IF THE CURRENCY LIST IS NOT EMPTY
		assertNotNull("Check the currencyList not empty.", currencyList);
		
		//TEST IF THE SEARCHED CURRENCY IS NOT IN THE LIST
		String missingTest =  C206_CaseStudy.searchRateByCurrency(currencyList, "SGD");
		String expected = "Currency does not exist";
		assertEquals("Test that the searched currency is not in the list", expected,missingTest);
		
		//TEST IF THE EXPECTED OUTPUT STRING IS SAME AS WHAT WAS SEARCHED
		String searchedOutput = String.format("%-10s%-20s%-20s%-20s","MYR","Malaysia Ringt","3.075","3.07");
		String search =  C206_CaseStudy.searchRateByCurrency(currencyList, "MYR");
		assertEquals("Test searchRateByCurrency", searchedOutput,search);

	}
	
	//MEMBER 4 - CONVERT CURRENCY TEST
	@Test
	public void convertCurrencyTest()
	{
		//CHECK IF THE CURRENCY LIST IS NOT EMPTY
		assertNotNull("Check the currencyList not empty.", currencyList);


		//TEST IF THE SEARCHED CURRENCY IS NOT IN THE LIST
		String getConvert =  C206_CaseStudy.convertCurrency(currencyList, "SELL","MYR",500,"KRW");
		String expected = "SELLING KRW 437445.00 for MYR 500.00";
		
		System.out.println(expected);
		System.out.println(getConvert);
		assertEquals("Test that the searched currency MYR is converted correctly", expected,getConvert);
		
	}
	@Test
	public void addMoneyHoldingTest() {
		assertNotNull("Check the holding not empty.", holdingList);
	} 
	@Test
	public void viewAllHoldingAndSgdValueTest() {
		// check not empty
				assertNotNull("Check the holding not empty.", holdingList);
	}
	
	//Member 1
	
	public void addCurrencyTest() {
		assertNotNull("Check the currency not empty.", currencyList);
		C206_CaseStudy.addCurrency(currencyList);
		assertEquals("Check that Camcorder arraylist size is 1", 1, currencyList.size());
		assertSame("Check that Currency is added", cc1, currencyList.get(0));

		assertEquals("Check that Camcorder arraylist size is 2", 2, currencyList.size());
		assertSame("Check that Currency is added", cc2, currencyList.get(1));
	}

	@Test
	public void searchHoldingAndSgdValueTest() {
		// check not empty
		assertNotNull("Check the holding not empty.", holdingList);
		
	
	}
	
}

