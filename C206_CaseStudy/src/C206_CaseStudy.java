import java.time.LocalDateTime;
import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Currency> currencyList = new ArrayList<>();
		ArrayList<MoneyHolding> holdingList = new ArrayList<>();
		ArrayList<Transaction> transactionList = new ArrayList<>();
		int option = -1;
 
		while (option != 13) {
 
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
				viewAllMoneyHolding(holdingList,currencyList);
			} else if (option == 5) {
				addMoneyHolding(holdingList);
			}  else if (option == 6) {
				deleteMoneyHolding(holdingList);
			}  else if (option == 7) {
				searchRateByCurrency(currencyList);
			}  else if (option == 8) {
				convertCurrency(currencyList);
			}  else if (option == 9) {
				
			}  else if (option == 10) {
				
			}  else if (option == 11) {
				
			} else if (option == 12) {
				viewAllMoneyHolding(holdingList,currencyList);
			} else if  (option == 13){
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
		System.out.println("4. VIEW MONEY HOLDING");
		System.out.println("5. ADD MONEY HOLDING");
		System.out.println("6. DELETE MONEY HOLDING");
		System.out.println("7. SEARCH RATE BY CURRENCY");
		System.out.println("8. CONVERT CURRENCY");
		System.out.println("9. ADD TRANSACTION");
		System.out.println("10. VIEW ALL TRANSACTION");
		System.out.println("11. DELETE TRANSACTION");
		System.out.println("12. SEARCH HOLDING OF CURRENCY");
		System.out.println(" ");
		
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
		currencyList.add(inputCurrency());
		System.out.println("Currency Added!");
		
	}
	
	public static void viewAllCurrency(ArrayList<Currency> currencyList) {
		Helper.line(20, "-");
		System.out.println("VIEW ALL CURRENCY");
		Helper.line(20, "-");
		
		System.out.println(String.format("%-10s%-20s%-20s%-20s", "ISO", "CURRENCY", "BUY RATE", "SELL RATE"));
		
		for (Currency i : currencyList)
		{			
			String items [] = i.toString().split(",");
			System.out.println(String.format("%-10s%-20s%-20s%-20s", items[0], items[1], items[2], items[3]));
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
	//MEMBER2
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

		holdingList.add(inputMoneyHolding());
		System.out.println("Holdings added!");
	}
	
//	public String retrieveAllMoneyHolding(ArrayList<MoneyHolding> holdingList) {
//		return null;
//		
//	}
	
	public static void viewAllMoneyHolding(ArrayList<MoneyHolding> holdingList,ArrayList<Currency> currencyList) {
		Helper.line(20, "-");
		System.out.println("VIEW ALL HOLDING");
		Helper.line(20, "-");
		
		String output = String.format("%-10s% -10s% -20s", "ISO" , "HOLDINGS" , "SGD_VALUE");
		
		for (int i =0; i < holdingList.size(); i++) {
			for (int j =0; j < currencyList.size(); j++) {
				if (holdingList.get(i).getIso().equalsIgnoreCase(currencyList.get(j).getIso())) {
					String items [] = holdingList.get(i).toString().split(",");
					
					//GET SELL RATE
					double sellRate = currencyList.get(j).getSellRate();
					//CALCULATE SGD
					double sgdValue = Double.parseDouble(items[1]) * sellRate;
					output += String.format("%-10s%-10s%-20.2f", items[0], items[1],sgdValue);
					System.out.println(output);
					break;
				}
			}}
		}
		/*
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
		*/
		public static void deleteMoneyHolding(ArrayList<MoneyHolding> MoneyHolding) {
			Helper.line(20, "-");
			System.out.println("DELETE Holding");
			Helper.line(20, "-");
			String ISO = Helper.readString("Enter Holding Name > ");
			boolean exist = false;
			
			for (MoneyHolding i : MoneyHolding) {

				if (i.getIso().equalsIgnoreCase(ISO)) {

				 {
					MoneyHolding.remove(i);
					exist = true;
					break;
				}
			}
			if (exist == false) {
				System.out.println("Holding does not exist");
			}
			
		}
	}
	//MEMBER 3 (8)
		public void searchHolding(ArrayList<MoneyHolding> holdingList, ArrayList<Currency> currencyList) {
			
			String curToSearch = Helper.readString("Enter currency to search > ");
			String output = String.format("%-10s% -10s% -20s", "ISO" , "HOLDINGS" , "SGD_VALUE");
			
			String iso = "";
			double holdingAmt = 0.0;
			
			boolean exist = false;
			// check if exist
			for (MoneyHolding i : holdingList) {
				if (i.getIso().equalsIgnoreCase(curToSearch));
				iso = i.getIso();
				holdingAmt = i.getHoldingAmt();
				exist = true;
				break;
			}
			
			// if exist
			if (exist == true) {
				for (int i =0; i <currencyList.size(); i++) {
					if (currencyList.get(i).getIso().equalsIgnoreCase(iso)) {
						//GET SELL RATE
						double sellRate = currencyList.get(i).getSellRate();
						//CALCULATE SGD
						double sgdValue = holdingAmt * sellRate;
						output += String.format("%-10s%-10.2f%-20.4f", iso, holdingAmt,sgdValue);
						System.out.println(output);
						break;
					}
				}
			}
			
			
		}
	
	
	public void retrieveAllHoldingAndSgdValue(ArrayList<MoneyHolding> MoneyHolding) {
		
	}
	
	public void viewAllHoldingAndSgdValue(ArrayList<MoneyHolding>MoneyHolding) {

	}


	//MEMEBER 4 - SEARCH AND CURRNCEY CONVERTER
	public static void searchRateByCurrency(ArrayList<Currency>currencyList) {
		
		String name = Helper.readString("Enter currency(ISO) to search > ");

		boolean exist = false;
		
		System.out.println(String.format("%-10s%-20s%-20s%-20s", "ISO", "CURRENCY", "BUY RATE", "SELL RATE"));
		
		for (Currency i : currencyList)
		{
			if (i.getIso().equalsIgnoreCase(name)) 
			{				
				String items [] = i.toString().split(",");
				System.out.println(String.format("%-10s%-20s%-20s%-20s", items[0], items[1], items[2], items[3]));
				
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
			output = String.format("SELLING %s%.2f for %s%.2f", ccout, convertedAmt, ccin, amtin);
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
	public double getrate(ArrayList<Currency> Currency , String a,String type) {
		double rate =0;
		for(int i = 0 ; i < Currency.size();i++)
		{
			if(Currency.get(i).getCurrencyName().equalsIgnoreCase(a))
			{if(type.equalsIgnoreCase("BUY")) {
				rate=Currency.get(i).getBuyRate();
				}
			else if (type.equalsIgnoreCase("SELL")) {
				rate = Currency.get(i).getSellRate();
			}
			}
		} 
		return rate;
		
	}

	public Transaction inputTransaction(ArrayList<Currency>currencyList) {

		Helper.line(20, "-");
        System.out.println("ADD TRANSACTION");
        Helper.line(20, "-");
        int typei = Helper.readInt("Chose your transaction type (1)BUY (2)SELL");
       
        String ccin = Helper.readString("Enter currency in > ");
        double amtin = Helper.readDouble("Enter amount in > ");
        String ccout = Helper.readString("Enter currency out > ");
        
        double amtout = 0.0; //DO CALCULATION AND RATE
        double rate = 0.0;
   	
	
	String type = "";
	 //the admin enter the type 
	 if (typei==1) {
		 type="BUY";
	 }
	 else if (typei==2) {
		 type="SELL";
	 }
	 else {
		 typei = Helper.readInt("Please enter a valid number");
	 }
        if (!type.equals(null) && !ccin.equals(null) && amtin != 0 && !ccout.equals(null)) {
        	if(type.equalsIgnoreCase("BUY")) {
        		 getrate(currencyList, ccin, "BUY");
        	Transaction t = new Transaction(LocalDateTime.now(), type, ccin, amtin, "SGD", (amtin*rate),rate );
            //update holding munus (amtin*rate)
        	return t;
            }
        	else if(type.equalsIgnoreCase("SELL")) {
        		getrate(currencyList, "SGD", "SELL");
            	Transaction t = new Transaction(LocalDateTime.now(), type, "SGD", amtin, ccin, (amtin/rate),rate );
                return t;}
        	 //update holding plus (amtin*rate)
        }
        else
        {
        	return null;
        }
	

		return null;
		
	}
	

	
public void addTransaction(ArrayList<Transaction> transactionList,ArrayList<Currency>currencyList) {

		 
		

		inputTransaction(currencyList);
		System.out.println("Transaction Added!");
	} 

	
	public void viewAllTransaction(ArrayList<Transaction> transactionList) {
		Helper.line(20, "-");
		System.out.println("VIEW ALL TRANSACTIONS");
		System.out.println(String.format("%-10s%-10s%-20s%-10s%-20s%-10s%-10s", "DATE", "TYPE", "CURRENCY IN", "AMOUNT IN", "CURRENCY OUT","RATE"));

		Helper.line(20, "-");
		for (Transaction i : transactionList) {

			String items [] = i.toString().split(",");
			System.out.println(String.format("%-10s%-10s%-20s%-10.2f%-20s%-10.2f%-10.2f", item[0], item[1], item[2], item[3],item[4],item[5],item[6]));

		}
	}
	
	public void deleteTransaction(ArrayList<Transaction>transactionList, String word) {
		
	}
	
}
