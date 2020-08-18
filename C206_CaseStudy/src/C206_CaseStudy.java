import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Currency> currencyList = new ArrayList<>();
		ArrayList<MoneyHolding> holdingList = new ArrayList<>();
		ArrayList<Transaction> transactionList = new ArrayList<>();
		int option = -1;

		while (option != 12) {

			menu();
			option = Helper.readInt("Enter choice > ");
			if (option == 1) {
				addCurrency(currencyList);
				viewAllCurrency(currencyList);
				
			} else if (option == 2) {
				viewAllCurrency(currencyList);
				addCurrency(currencyList);
			} else if (option == 3) {
				deleteCurrency(currencyList);
			} else if (option == 4) {
				addMoneyHolding(holdingList);
			} else if (option == 5) {
				
			}  else if (option == 6) {
				
			}  else if (option == 7) {
				String curr = Helper.readString("Enter currency name");
				searchRateByCurrency(currencyList, curr);
			}  else if (option == 8) {
				
			}  else if (option == 9) {
				
			}  else if (option == 10) {
				
			}  else if (option == 11) {
				
			} else if (option == 12) {
				System.out.println("Goodbye!");
			} else {
				System.out.println("Invalid option!");
			}

		}
	}
	public static void menu() {
		//TODO: P05 Task 1 - Write code here for the menu options.
		Helper.line(20, "-");
		System.out.println("WELCOME TO J MONEY EXCHANGE MANAGEMENT SYSTEM");
		Helper.line(20, "-");
		System.out.println("1. VIEW LIST OF CURRENCIES");
		System.out.println("2. ADD CURRENCY");
		System.out.println("3. DELETE CURRENCY");
		System.out.println("4. ADD MONEY HOLDING");
		System.out.println("5. VIEW MONEY HOLDING");
		System.out.println("6. DELETE MONEY HOLDING");
		System.out.println("7. SEARCH BY RATE");
		System.out.println("8. CONVERT CURRENCY");
		System.out.println("9. ADD TRANSACTION");
		System.out.println("10. VIEW ALL LTRANSACTION");
		System.out.println("11. DELETE TRANSACTION");
	//	System.out.println("4. VIEW HOLDINGS OF CURRENCY");
	//	System.out.println("5. ADD HOLDINGS TO CURRENCY");
	//	System.out.println("6. DELETE HOLDINGS OF CURRENCY");
		
	}

	public void setHeader(String a) {
		
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
	
	public static void viewAllCurrency(ArrayList<Currency> currencyList) {
		Helper.line(20, "-");
		System.out.println("VIEW ALL CURRENCY");
		Helper.line(20, "-");
		for (Currency i : currencyList) {
			System.out.println(i.toString());
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
		return null;		
	}

	public MoneyHolding inputMoneyHolding() {
		return null;
		
	}

	public static void addMoneyHolding(ArrayList<MoneyHolding> holdingList) {
		
	}
	
	public String retrieveAllMoneyHolding(ArrayList<MoneyHolding> holdingList) {
		return null;
		
	}
	
	public void viewAllMoneyHolding(ArrayList<MoneyHolding> holdingList) {
		Helper.line(20, "-");
		System.out.println("VIEW ALL HOLDING");
		Helper.line(20, "-");
		for (MoneyHolding i : holdingList) {
			System.out.println(i.toString());
		}
	}
	
	public void deleteMoneyHolding(ArrayList<MoneyHolding> MoneyHolding) {
		
	}
	
	public void retrieveAllHoldingAndSgdValue(ArrayList<MoneyHolding> MoneyHolding) {
		
	}
	
	public void viewAllHoldingAndSgdValue(ArrayList<MoneyHolding>MoneyHolding) {
		
	}

	public static void searchRateByCurrency(ArrayList<Currency>currencyList , String curr) {
		boolean exist = false;
		
		for (int i=0; i<currencyList.size(); i++) {
			if (currencyList.get(i).getIso().equalsIgnoreCase(curr)) {
				System.out.println(currencyList.get(i).toString());
				exist = true;
				break;
			}
		} 
		
		if (exist == false) {
			System.out.println("Currency does not exist");
		}
	
	public void convertCurrency(ArrayList<Currency>Currency) {
		for(int i = 0 ; i < Currency.size() ; i++)
		{
			
		}
		
		
	}
	
	public Transaction inputTransaction() {
		return null;
		
	}
	
	public void addTransaction(ArrayList<Transaction> transactionList) {
		 
	} 
	
	public String retrieveAllTransaction(ArrayList<Transaction>transactionList) {
		return null;
		
	}
	
	public void viewAllTransaction(ArrayList<Transaction> transactionList) {
		Helper.line(20, "-");
		System.out.println("VIEW ALL HOLDING");
		Helper.line(20, "-");
		for (Transaction i : transactionList) {
			System.out.println(i.toString());
		}
	}
	
	public void deleteTransaction(ArrayList<Transaction>transactionList, String word) {
		
	}
	
}
