
import static org.junit.Assert.*;

import java.time.LocalDate;
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

	private Transaction dt1;
	private Transaction dt2;
	private Transaction dt3;
	private Transaction dt4;
	
	private Transaction wt1;
	private Transaction wt2;
	private Transaction wt3;
	private Transaction wt4;
 
	private ArrayList<Currency> currencyList;
	private ArrayList<MoneyHolding> holdingList;
	private ArrayList<Transaction> transactionList;
	private ArrayList<Transaction> dayList;
	private ArrayList<Transaction> weekList;

	@Before
	public void setUp() throws Exception {
		cc1 = new Currency("MYR", "Malaysia Ringt", 3.075, 3.070);
		cc2 = new Currency("KRW", "Korean Won", 878.73, 874.89);
		cc3 = new Currency("USD","United State Dollar", 0.78,0.727);
		mh1 = new MoneyHolding("USD", 100000);
		mh2 = new MoneyHolding("MYR", 500000);
		//double amountout=0;
		
		t1 = new Transaction(LocalDate.now(),1,"SELL","SGD",100,"MYR",(100*3.075),3.075);
		t2 = new Transaction(LocalDate.now(),2,"BUY","MYR",100,"SGD",(100*3.070),3.070);
		


		dayList = new ArrayList<>();
		dt1 = new Transaction(LocalDate.of(2020,8,20),dayList.size()+1,"SELL", "SGD", 500.00, "MYR", 1535, 3.070);
		dt2 = new Transaction(LocalDate.of(2020,8,20),dayList.size()+1,"SELL", "SGD", 100.00, "KRW", 877200.00, 877.20);
		dt3 = new Transaction(LocalDate.of(2020,8,20),dayList.size()+1,"BUY", "MYR", 1000.00, "SGD", 325.00, 3.075);
		dt4 = new Transaction(LocalDate.of(2020,8,20),dayList.size()+1,"BUY", "USD", 1000.00, "SGD", 1369.11, 0.7304);
		
		dayList.add(dt1);
		dayList.add(dt2);
		dayList.add(dt3);
		dayList.add(dt4);
		
		weekList = new ArrayList<>();
		wt1 = new Transaction(LocalDate.of(2020,8,8),weekList.size()+1,"SELL", "SGD", 500.00, "MYR", 1535, 3.070);
		wt2 = new Transaction(LocalDate.of(2020,8,8),weekList.size()+1,"SELL", "SGD", 100.00, "KRW", 877200.00, 877.20);
		wt3 = new Transaction(LocalDate.of(2020,8,8),weekList.size()+1,"BUY", "MYR", 1000.00, "SGD", 325.00, 3.075);
		wt4 = new Transaction(LocalDate.of(2020,8,8),weekList.size()+1,"BUY", "USD", 1000.00, "SGD", 1369.11, 0.7304);
		
		weekList.add(wt1);
		weekList.add(wt2);
		weekList.add(wt3);
		weekList.add(wt4);
		
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
	//MEMBER 4 - VIEW SUMMARY OF TRANSACTIONS BY DAYS TEST(GROUPED BY TYPE AND CURRENCY) 
	@Test
	public void viewByDaysTest()
	{
		//CHECK IF THE TRANSACTION LIST IS NOT EMPTY
		assertNotNull("Check the transactionList2 not empty.", dayList);

		//TEST IF THE TRANSACTIONS FROM 2 DAY AGO IS DISPLAYED
		String output =  C206_CaseStudy.viewByDays(dayList, 2);
		String expected = "TYPE      CURRENCY IN    AMOUNT IN      CURRENCY OUT        AMOUNT OUT          \n" + 
				"SELL      SGD            500.00         MYR                 1535.00             \n" + 
				"SELL      SGD            100.00         KRW                 877200.00           \n" + 
				"BUY       MYR            1000.00        SGD                 325.00              \n" + 
				"BUY       USD            1000.00        SGD                 1369.11             \n" ;
				
				
		assertEquals("Test that the summary of transactions are shown accurately", expected,output);
			
	}
	//MEMBER 4 - VIEW SUMMARY OF TRANSACTIONS BY WEEKS TEST(GROUPED BY TYPE AND CURRENCY) 
	@Test
	public void viewByWeeksTest()
	{
		//CHECK IF THE TRANSACTION LIST IS NOT EMPTY
		assertNotNull("Check the weekList not empty.", weekList);
			//TEST IF THE TRANSACTIONS ONE DAY AGO IS DISPLAYED
		String output =  C206_CaseStudy.viewByWeeks(weekList, 2);
		String expected = "TYPE      CURRENCY IN    AMOUNT IN      CURRENCY OUT        AMOUNT OUT          \n" + 
				"SELL      SGD            500.00         MYR                 1535.00             \n" + 
				"SELL      SGD            100.00         KRW                 877200.00           \n" + 
				"BUY       MYR            1000.00        SGD                 325.00              \n" + 
				"BUY       USD            1000.00        SGD                 1369.11             \n" ;
				
				
		assertEquals("Test that the summary of transactions are shown accurately", expected,output);
		
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

		
	//Member 1 - ADD CURRENCY TEST
	@Test
	public void addCurrencyTest() { 
		//LIST IS NOT EMPTY
		assertNotNull("Check the currency not empty.", currencyList);
		
		//CHECK IF THE ARRAYLIST INCREASE BY 1 WHEN THE OBJECT HAVE BEEN ADDED
		//add new object
		String expectedOutput = C206_CaseStudy.addCurrency(currencyList,"SGD","SINGAPORE",1.0,1.0);
		//did the size increase?
		assertEquals("Check that currency arraylist size is 4", 4, currencyList.size());
		//did it succeed?
		assertEquals("Check that Currency is added", "Currency Added!",expectedOutput );

	}
	
	// MEMBER 3
	@Test
	public void searchHoldingAndSgdValueTest() {
		// CHECKING THE LIST IS NOT EMPTY 
		assertNotNull("Check the holding not empty.", holdingList);

		
		//TEST IF THE SEARCHED CURRENCY IS NOT IN THE LIST
			String missingTest =  C206_CaseStudy.searchHoldingAndSgdValue(holdingList, currencyList, "SGD");
			String expected = "Currency does not exist";
			assertEquals("Test that the searched currency is not in the list", expected, missingTest);
				
		// TEST IF CORRECT 
			String testOutput = String.format("%-10s %-10s %-20s\n", "ISO" , "HOLDINGS" , "SGD_VALUE");
			testOutput += String.format("%-10s %-10.2f %-20.4f\n", "MYR" , 500000.00, 1535000.0000);	
			String correctTest =  C206_CaseStudy.searchHoldingAndSgdValue(holdingList, currencyList, "MYR");
			assertEquals("Check expected outcome" , testOutput, correctTest);
	}


	
	
	@Test//MEMBER 5 -ADD TRANSACTION RECORD
	public void addTransaction() {
		//test that the transaction object is created and addinto the transactionlist
			 ArrayList<Transaction> tList=new ArrayList<Transaction>();
			 
			 //TEST THE TRANSACTION IS ADDED SUCCESSFULLY
		C206_CaseStudy.addTransaction(tList, currencyList, 1, "MYR", 100, 3.075);
		assertNotNull(tList);
	
		
	}
	@Test
	public void deleteTransaction() {
		// TEST IF THE CORRECT TRANSACTION IS DELETED
		ArrayList<Transaction> list2 = new ArrayList<Transaction>();
		list2.add(t1);
		String output="Transaction deleted !";
		
		
		String s=C206_CaseStudy.deleteTransaction(transactionList, 1);
		
		assertEquals(output, s);


	}

	//MEMBER 2 ADD MONEY INTO HOLDING TEST
		@Test 
		public void addinputHoldingTest() {
			//CHECKING THE LIST IS NOT EMPTY 
			assertNotNull("Check the holding not empty.", holdingList);
			
			//CHECK THE CURRENT SIZE OF THE ARRAYLIST
			assertEquals("Check that holding arraylist size is 2", 2, holdingList.size());

			//CHECK THAT THE ARRAYLIST SIZE INCREASE WHEN THE HOLDINGS HAVE BEEN ADDED
			String output = C206_CaseStudy.addMoneyHolding(holdingList,"USD",5000.0);
			
			assertEquals("Check that holding arraylist size is ", 3, holdingList.size());
			assertSame("Check that holding is added", "Holdings Added!", output);
			 
		} 
 

	
	

}
