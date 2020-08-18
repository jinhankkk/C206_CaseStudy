import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private Currency cc1;
	private Currency cc2;  
	private Currency cc3;

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
		cc3 = new Currency("USD","United State Dollar", 0.78,0.727);
		mh1 = new MoneyHolding("USD", 100000);
		mh2 = new MoneyHolding("MYR", 500000);
		//double amountout=0;
		t1 = new Transaction(LocalDateTime.now(),1,"SELL","SGD",100,"MYR",(100*3.075),3.075);
		t2 = new Transaction(LocalDateTime.now(),2,"BUY","MYR",100,"SGD",(100*3.070),3.070);
		currencyList = new ArrayList<>();
		currencyList.add(cc1);
		currencyList.add(cc2);
		currencyList.add(cc3);
		
		holdingList = new ArrayList<>();
		holdingList.add(mh1);
		holdingList.add(mh2);
		
		transactionList = new ArrayList<>();
		transactionList.add(t1);
		transactionList.add(t2);
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

		//TEST IF THE CONVERTED CURRENCY CORRECT
		String getConvert =  C206_CaseStudy.convertCurrency(currencyList, "SELL","MYR",500,"KRW");
		String expected = "SELLING KRW 437445.00 for MYR 500.00";
		
		System.out.println(expected);
		System.out.println(getConvert);
		assertEquals("Test that the searched currency MYR is converted correctly", expected,getConvert);
		
	}
	
	// MEMBER 3
	@Test
	public void viewAllHoldingAndSgdValueTest() {
		// check not empty
					assertNotNull("Check the holding not empty.", holdingList);
					
					String allHoldings = C206_CaseStudy.viewAllHoldingAndSgdValueTest(holdingList, currencyList);
					
					String testOutput= String.format("%-10s %-10.2f %-20.4f\n", "USD" , 100000.00, 72700.0000);
					 testOutput += String.format("%-10s %-10.2f %-20.4f\n", "MYR" , 500000.00, 1535000.0000);
						
					System.out.println(testOutput);
					System.out.println("-------------\n"+allHoldings);  
					//testOutput = String.format("%-10s %-10.2f %-20.4f\n", "" , "" ,"" );
					assertEquals("Check expected outcome" , testOutput, allHoldings);
	}


	@Test//MEMBER 2 ADD MONEY INTO HOLDING 

	public void addinputHoldingTest() {
		//CHECKING THE LIST IS NOT EMPTY 
		assertNotNull("Check the holding not empty.", holdingList);
		//MAKE SURE IS NOT EMPTY
		C206_CaseStudy.inputMoneyHolding();
		assertEquals("Check that holding arraylist size is 1", 1, holdingList.size());
		assertSame("Check that holding is added", mh1, holdingList.get(0));
		assertEquals("Check that holding arraylist size is 2", 2, holdingList.size());
		assertSame("Check that holding is added", mh2, holdingList.get(1));
		
		
	} 
	 
	

	
	//Member 1 - ADD CURRENCY
	@Test
	public void addCurrencyTest() { 
		assertNotNull("Check the currency not empty.", currencyList);
		C206_CaseStudy.addCurrency(currencyList);
		assertEquals("Check that currency arraylist size is 1", 1, currencyList.size());
		assertSame("Check that Currency is added", cc1, currencyList.get(0));

		assertEquals("Check that currency arraylist size is 2", 2, currencyList.size());
		assertSame("Check that Currency is added", cc2, currencyList.get(1));
	}

	@Test
	public void searchHoldingAndSgdValueTest() {
		// CHECKING THE LIST IS NOT EMPTY 
		assertNotNull("Check the holding not empty.", holdingList);
		
	
	}
	
	
	@Test//MEMBER 5 -ADD TRANSACTION RECORD
public void addTransaction() {
	//check that the transaction object is created and addinto the transactionlist
	assertNotNull("Check the transactionlist not empty",transactionList);
	assertNotEquals(null, t1);
	assertNotEquals(null, t2);

	
}
	@Test
	public void deleteTransaction() {
		// TEST IF THE CORRECT TRANSACTION IS DELETED
		ArrayList<Transaction> list2 = new ArrayList<Transaction>();
		list2.add(t1);
		list2.add(t2);
		
		
		C206_CaseStudy.deleteTransaction(transactionList, 1);
	    assertNotEquals(list2, transactionList);
	}
	
}
