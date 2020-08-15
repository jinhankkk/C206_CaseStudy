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
		System.out.println("WELCOME TO SUSHI WORLD");
		Helper.line(20, "-");
		System.out.println("1. View all items");
		System.out.println("2. Add item");
		System.out.println("3. Most expensive item");
		System.out.println("4. Cheapest item");
		System.out.println("5. Quit");
		
	}

	public void setHeader(String a) {
		
	}
	
	public void addCurrency(ArrayList<Currency> addCurr ) {
		
	}
	
	public String retrieveAllCurrency(ArrayList<Currency> cur) {
		
	}
	
	public void viewAllCurrency(ArrayList<Currency> currencyList) {
		
	}
	
	public void deleteCurrency(ArrayList<Currency> currencyList ) {
		
	}

	public MoneyHolding inputMoneyHolding() {
		
	}

	public void addMoneyHolding(ArrayList<MoneyHolding> MoneyHolding) {
		
	}
	
	public String retrieveAllMoneyHolding(ArrayList<MoneyHolding> ) {
		
	}
	
	public void viewAllMoneyHolding(ArrayList<MoneyHolding>) {
		
	}
	
	public void deleteMoneyHolding(ArrayList<MoneyHolding> ) {
		
	}
	
	public void retrieveAllHoldingAndSgdValue(ArrayList<MoneyHolding>) {
		
	}
	
	public void viewAllHoldingAndSgdValue(ArrayList<MoneyHolding>) {
		
	}

	public void searchRateByCurrency(ArrayList<Currency> , String a) {
		
	}
	
	public void convertCurrency(ArrayList<Currency>) {
		
	}
	
	public Transaction inputTransaction() {
		
	}
	
	public void addTransaction(ArrayList<Transaction> Transaction) {
		
	}
	
	public String retrieveAllTransaction(ArrayList<Transaction>) {
		
	}
	
	public void viewAllTransaction(ArrayList<transaction>) {
		
	}
	
	public void deleteTransaction(ArrayList<Transaction>, String "") {
		
	}
	
}
