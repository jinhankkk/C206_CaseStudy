
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
	private static void menu() {
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

	private void setHeader(String a) {
		
	}
	
	private void addCurrency(ArrayList<Currency> addCurr ) {
		
	}









}
