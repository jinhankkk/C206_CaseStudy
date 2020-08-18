import java.time.LocalDateTime;
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
				searchRateByCurrency(currencyList);
			}  else if (option == 8) {
				convertCurrency(currencyList);
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
	//MEMBER 1 - ADD,VIEW,DELETE CURRENCY
	public static Currency inputCurrency()
	{
		Helper.line(20, "-");
        System.out.println("ADD CURRENCY");  
        Helper.line(20, "-");

		String iso = Helper.readString("Enter ISO > ");
		String curName = Helper.readString("Enter Currency Name > ");
		double buyRate = Helper.readDouble("Enter Buy Rate > "); 
		double sellRate = Helper.readDouble("Enter Sell Rate > ");

		if (iso != null && curName != null) {
            
        	Currency c = new Currency(iso,curName,buyRate,sellRate);
            return c;

        }
        else
        {
        	return null;
        }
		
	}
	public static void addCurrency(ArrayList<Currency> currencyList ) {
		inputCurrency();
		System.out.println("Currency Added!");
		
	}
	
	public static void viewAllCurrency(ArrayList<Currency> currencyList) {
		Helper.line(20, "-");
		System.out.println("VIEW ALL CURRENCY");
		Helper.line(20, "-");
		
		System.out.println(String.format("%-10s%-10s%-20s%-20s", "ISO", "CURRENCY", "BUY RATE", "SELL RATE"));
		
		for (Currency i : currencyList)
		{			
			String items [] = i.toString().split(",");
			System.out.println(String.format("%-10s%-10s%-20.4f%-20.4fs", items[0], items[1], items[2], items[3]));
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

	//MONEY HOLDING
	public static MoneyHolding inputMoneyHolding() {

		Helper.line(20, "-");
        System.out.println("ADD HOLDING");
        Helper.line(20, "-");
        String iso = Helper.readString("Enter ISO > ");
        double amount = Helper.readInt("Enter amount > ");

        if (!iso.equals(null) && amount > 0) {
            
        	MoneyHolding mh = new MoneyHolding(iso,amount);
            return mh;

        }
        else
        {
        	return null;
        }
	}

	public static void addMoneyHolding(ArrayList<MoneyHolding> holdingList) {

		inputMoneyHolding();
		System.out.println("Holdings added!");
	}
	
	public String retrieveAllMoneyHolding(ArrayList<MoneyHolding> holdingList) {
		return null;
		
	}
	
	public void viewAllMoneyHolding(ArrayList<MoneyHolding> holdingList) {
		Helper.line(20, "-");
		System.out.println("VIEW ALL HOLDING");
		Helper.line(20, "-");
		for (MoneyHolding i : holdingList)
		{			
			String items [] = i.toString().split(",");

			//HOW TO CALCULATE THE SGD VALUE 
			int sgd = Integer.parseInt(items[1]); //----> HOW GET THE SELL RATE 
			System.out.println(String.format("%-10s%-10.2f%-20.4f", items[0], items[1],sgd ));
			
		}
	}
	
	public void deleteMoneyHolding(ArrayList<MoneyHolding> MoneyHolding) {
		Helper.line(20, "-");
		System.out.println("DELETE Holding");
		Helper.line(20, "-");
		String curName = Helper.readString("Enter Holding Name > ");
		boolean exist = false;
		
		for (MoneyHolding i : MoneyHolding) {
			if (i.getMoneyHolding().equalsIgnoreCase(curName)) {
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
<<<<<<< HEAD
//MEMEBER 4 - SEARCH AND CURRENCY CONVERTER
	public static void searchRateByCurrency(ArrayList<Currency>currencyList , String name) {
=======
	
	//MEMEBER 4 - SEARCH AND CURRNCEY CONVERTER
	public static void searchRateByCurrency(ArrayList<Currency>currencyList) {
		
		String name = Helper.readString("Enter currency(iso) to search > ");
>>>>>>> branch 'master' of https://github.com/jinhankkk/C206_CaseStudy.git
		boolean exist = false;
		
		System.out.println(String.format("%-10s%-10s%-20s%-20s", "ISO", "CURRENCY", "BUY RATE", "SELL RATE"));

		for (Currency i : currencyList)
		{
			if (i.getIso().equalsIgnoreCase(name)) 
			{				
				String items [] = i.toString().split(",");
				System.out.println(String.format("%-10s%-10s%-20.4f%-20.4fs", items[0], items[1], items[2], items[3]));
				
				exist = true;
				break;
			}
		} 
		
		if (exist == false) {
			System.out.println("Currency does not exist");
		}
	}
	
	public static void convertCurrency(ArrayList<Currency>currencyList) {
		
		String type = Helper.readString("Enter Type of transaction > " );
		String ccin = Helper.readString("Enter Currency in > ");
		double amtin = Helper.readDouble("Enter Amount in > ");
		String ccout = Helper.readString("Enter Currency Out > ");
		
		String output = "";
		double convertedAmt = 0;
		
		if(type.equalsIgnoreCase("sell"))
		{
			for(Currency i : currencyList)
			{
				if(i.getIso().equalsIgnoreCase(ccout))
				{
					convertedAmt = amtin * i.getSellRate();
					break;
				}
			}
			output = String.format("SELLING %s%.2f for %s%f", ccout, convertedAmt, ccin, amtin);
		}
		else if(type.equalsIgnoreCase("buy"))
		{
			for(Currency i : currencyList)
			{
				if(i.getIso().equalsIgnoreCase(ccout))
				{
					convertedAmt = amtin * i.getBuyRate();
					break;
				}
			}
			output = String.format("SELLING %s%.2f for %s%f", ccout, convertedAmt, ccin, amtin);	
		}
		else
		{
			System.out.println("invalid type");
		}
	
		System.out.println(output);
	}
	
	
	//MEMBER 5 - TRANSACTION
	public Transaction inputTransaction() {

		Helper.line(20, "-");
        System.out.println("ADD TRANSACTION");
        Helper.line(20, "-");
        
        String type = Helper.readString("Enter type > ");
        String ccin = Helper.readString("Enter currency in > ");
        double amtin = Helper.readDouble("Enter amount in > ");
        String ccout = Helper.readString("Enter currency out > ");
        
        double amtout = 0.0; //-------------------DO CALCULATION AND RATE-------------------------
        double rate = 0.0;
       
        if (!type.equals(null) && !ccin.equals(null) && amtin != 0 && !ccout.equals(null)) {
            
        	Transaction t = new Transaction(LocalDateTime.now(), type, ccin, amtin, ccout, amtout,rate );
            return t;

        }
        else
        {
        	return null;
        }
		
	}
	
	public void addTransaction(ArrayList<Transaction> transactionList) {
		 
		inputTransaction();
		System.out.println("Transaction Added!");
	} 
	
	public String retrieveAllTransaction(ArrayList<Transaction>transactionList) {
		return null;
		
	}
	
	public void viewAllTransaction(ArrayList<Transaction> transactionList) {
		Helper.line(20, "-");
		System.out.println("VIEW ALL HOLDING");
		System.out.println(String.format("%-10s%-10s%-20s%-10s%-20s%-10s%-10s", "DATE", "TYPE", "CURRENCY IN", "AMOUNT IN", "CURRENCY OUT","RATE"));

		Helper.line(20, "-");
		for (Transaction i : transactionList) {

			String items [] = i.toString().split(",");
			System.out.println(String.format("%-10s%-10s%-20s%-10.2f%-20s%-10.2f%-10.2f", items[0], items[1], items[2], items[3],items[4],items[5],items[6]));

		}
	}
	
	public void deleteTransaction(ArrayList<Transaction>transactionList, String word) {
		
	}
	
}
