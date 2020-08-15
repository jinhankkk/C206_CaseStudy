import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int option = -1;

		while (option != 5) {

			menu();
			option = Helper.readInt("Enter choice > ");
			if (option == 1) {
				viewAllItems(itemList);
			} else if (option == 2) {
				addItem();
				itemList =load();
			} else if (option == 3) {
				getMostExpensive(itemList);
			} else if (option == 4) {
				getCheapest(itemList);
			} else if (option == 5) {
				System.out.println("Thank you for using Sushi World!");
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
		System.out.println("1. ADD CURRENCY");
		System.out.println("2. VIEW LIST OF CURRENCIES");
		System.out.println("3. DELETE CURRENCY");
		System.out.println("4. ");
		System.out.println("5. ");
		
	}

	public void setHeader(String a) {
		
	}
	
	public void addCurrency(ArrayList<Currency> currencyList ) {
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
			// INSERT INTO CurrencyList
			currencyList.add(new Currency (iso,curName,buyRate,sellRate));
			
			
		}
		
	}
	
	public String retrieveAllCurrency(ArrayList<Currency> cur) {
		return null;
		
	}
	
	public void viewAllCurrency(ArrayList<Currency> currencyList) {
		Helper.line(20, "-");
		System.out.println("VIEW ALL CURRENCY");
		Helper.line(20, "-");
		for (Currency i : currencyList) {
			System.out.println(i.toString());
		}
	}
	
	public void deleteCurrency(ArrayList<Currency> currencyList ) {
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

	public MoneyHolding inputMoneyHolding() {
		return null;
		
	}

	public void addMoneyHolding(ArrayList<MoneyHolding> MoneyHolding) {
		
	}
	
	public String retrieveAllMoneyHolding(ArrayList<MoneyHolding> MoneyHolding) {
		return null;
		
	}
	
	public void viewAllMoneyHolding(ArrayList<MoneyHolding>MoneyHolding) {
		
	}
	
	public void deleteMoneyHolding(ArrayList<MoneyHolding> MoneyHolding) {
		
	}
	
	public void retrieveAllHoldingAndSgdValue(ArrayList<MoneyHolding> MoneyHolding) {
		
	}
	
	public void viewAllHoldingAndSgdValue(ArrayList<MoneyHolding>MoneyHolding) {
		
	}

	public void searchRateByCurrency(ArrayList<Currency>Currency , String a) {
		
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
