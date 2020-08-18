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
	@Test
	public void viewAllHoldingAndSgdValueTest() {
		// check not empty
				assertNotNull("Check the holding not empty.", holdingList);
	}
	public void addCurrencyTest() {
		assertNotNull("Check the currency not empty.", currencyList);
	}
	public void deleteCurrencyTest() { 
		assertNotNull("Check the currency exist.", currencyList);
	}

	@Test
	public void searchHoldingAndSgdValueTest() {
		// check not empty
		assertNotNull("Check the holding not empty.", holdingList);
		
	
	}
	
}
