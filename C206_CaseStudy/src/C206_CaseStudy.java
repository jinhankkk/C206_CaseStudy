import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Currency> currencyList = new ArrayList<Currency>();
		int option = -1;
		ArrayList<MoneyHolding>  MoneyHolding = new ArrayList<MoneyHolding>();
		
		while (option != 5) {

			menu();
			option = Helper.readInt("Enter choice > ");
			if (option == 1) {
				viewAllCurrency(currencyList);
				
			} else if (option == 2) {
				addCurrency(currencyList);

			} else if (option == 3) {
				deleteCurrency(currencyList);

			} else if (option == 4) {
				//getCheapest();
			} else if (option == 5) {
				System.out.println("!");
			} else {
				System.out.println("Invalid option!");
			}

		}
	}
	public static void menu() {
		//TODO: P05 Task 1 - Write code here for the menu options.
		Helper.line(20, "-");
		System.out.println("WELCOME TO  J MONEY EXCHANGE MANAGEMENT SYSTEM");
		Helper.line(20, "-");
		System.out.println("1. VIEW LIST OF CURRENCIES");
		System.out.println("2. ADD CURRENCY");
		System.out.println("3. DELETE CURRENCY");
		System.out.println("4. VIEW HOLDINGS OF CURRENCY");
		System.out.println("5. ADD HOLDINGS TO CURRENCY");
		System.out.println("6. DELETE HOLDINGS OF CURRENCY");
		System.out.println("7. ");
		
	}

	public void setHeader(String a) {
		
	} 
	
	public static void viewAllCurrency(ArrayList<Currency> currencyList) {
		Helper.line(20, "-");
		System.out.println("VIEW ALL CURRENCY");
		Helper.line(20, "-");
		for (Currency i : currencyList) {
			System.out.println(i.toString());
		}
	}
	
	public static void addCurrency(ArrayList<Currency> currencyList ) {
		Helper.line(20, "-");
		System.out.println("ADD CURRENCY");
		Helper.line(20, "-");
		String iso = Helper.readString("Enter ISO > ");
		String curName = Helper.readString("Enter Currency Name > ");
		double buyRate = Helper.readDouble("Enter Buy Rate > "); 
		double sellRate = Helper.readDouble("Enter Sell Rate > ");
		
		if (iso != null && curName != null) {
			// CHECK IF CURRENCY EXIST
			for (int i=0; i<currencyList.size(); i++) {
				if (currencyList.get(i).getCurrencyName().equalsIgnoreCase(curName)) {
					System.out.println("Currency already exist");
					break;
				}
			}
			// INSERT INTO CURRENCY LIST
			currencyList.add(new Currency (iso,curName,buyRate,sellRate));
			
		}
		
	}
	
	public static void deleteCurrency(ArrayList<Currency> currencyList ) {
		Helper.line(20, "-");
		System.out.println("DELETE CURRENCY");
		Helper.line(20, "-");
		String curName = Helper.readString("Enter Currency Name > ");
		boolean exist = false;
		
		for (Currency i : currencyList) {
			if (i.getCurrencyName().equalsIgnoreCase(curName)) {
				currencyList.remove(i);
				exist = true;
				break;
			}
		}
		
		if (exist == false) {
			System.out.println("Currency does not exist");
		}
		
	}
	
	public String retrieveAllCurrency(ArrayList<Currency> cur) {
		
		
	}
	
	
	


	public MoneyHolding inputMoneyHolding() {
		Helper.line(20, "-");
		System.out.println("ADD HOLDING");
		Helper.line(20, "-");
		String iso = Helper.readString("Enter ISO > ");
		String holdingname = Helper.readString("Enter Holding Name > ");
		double buyRate = Helper.readDouble("Enter Buy Rate > "); 
		double sellRate = Helper.readDouble("Enter Sell Rate > ");
		
		if (iso != null && holdingname != null) {
			// CHECK IF CURRENCY EXIST
			for (int i=0; i<MoneyHolding.size(); i++) {
				if (MoneyHolding.get(i).getMoneyHolding().equalsIgnoreCase(holdingname)) {
					System.out.println("Currency already exist");
					break;
				}
			}
			// INSERT INTO CURRENCY LIST
			MoneyHolding.add(new MoneyHolding (iso,holdingname,buyRate,sellRate));
		
		
	}

	public void addMoneyHolding(ArrayList<MoneyHolding> MoneyHolding) {
		
	}
	
	public String retrieveAllMoneyHolding(ArrayList<MoneyHolding> MoneyHolding) {
		return null;
		
	}
	
	public void viewAllMoneyHolding(ArrayList<MoneyHolding>MoneyHolding) {
		Helper.line(20, "-");
		System.out.println("VIEW ALL HOLDING");
		Helper.line(20, "-");
		for (MoneyHolding i : MoneyHolding) {
			System.out.println(i.toString());
		}
		
	}
	
	public void deleteMoneyHolding(ArrayList<MoneyHolding> MoneyHolding) {
		Helper.line(20, "-");
		System.out.println("DELETE CURRENCY");
		Helper.line(20, "-");
		String holdingname = Helper.readString("Enter Holding Name > ");
		boolean exist = false;
		
		for (MoneyHolding i : MoneyHolding) {
			if (i.getMoneyHolding().equalsIgnoreCase(holdingname)) {
				MoneyHolding.remove(i);
				exist = true;
				break;
			}
		}
		
		if (exist == false) {
			System.out.println("Holding does not exist");
		}
		
	}
	
	public void retrieveAllHoldingAndSgdValue(ArrayList<MoneyHolding> MoneyHolding) {
		
	}
	
	public void viewAllHoldingAndSgdValue(ArrayList<MoneyHolding>MoneyHolding) {
		
	}

	public void searchRateByCurrency(ArrayList<Currency>Currency , String a) {
		for(int i = 0 ; i < Currency.size();i++)
		{
			if(Currency.get(i).getCurrencyName().equalsIgnoreCase(a))
			{
				System.out.println(Currency.get(i).toString());	
			}
		} 
		
	}
	
	public void convertCurrency(ArrayList<Currency>Currency) {
		
		
	}
	
	public Transaction inputTransaction() {
		return null;
		
	}
	
	public void addTransaction(ArrayList<Transaction> Transaction) {
		 
	} 
	
	public String retrieveAllTransaction(ArrayList<Transaction>Transaction) {
		return null;
		
	}
	
	public void viewAllTransaction(ArrayList<Transaction>Transaction) {
		
	}
	
	public void deleteTransaction(ArrayList<Transaction>Transaction, String word) {
		
	}
	
}
