import static org.junit.Assert.*;

import java.util.ArrayList;

public class C206_CaseStudyTest {

	private Currency cc1;
	private Currency cc2;
	
	private MoneyHolding mh1;
	private MoneyHolding mh2;
	
	private Transaction t1;
	private Transaction t2;
	

	ArrayList<Currency> currencyList;
	ArrayList<MoneyHolding> holdingList;
	ArrayList<Transaction> transactionList;
	
	public void setUp() throws Exception
	{
		cc1 = new Currency("MYR","Malaysia Ringt",3.075,3.070);
		cc2 = new Currency("KRW","Korean Won",878.73,874.89);

		currencyList = new ArrayList<>();
		holdingList = new ArrayList<>();
		transactionList = new ArrayList<>();
		
		
	}
	public void searchRateByCurrency()
	{
		
	}

}
