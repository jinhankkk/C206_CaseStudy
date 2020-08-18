import java.time.LocalDateTime;
import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_2 = 2;
	private static final int addHolding = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Currency> currencyList = new ArrayList<>();
		ArrayList<MoneyHolding> holdingList = new ArrayList<>();
		ArrayList<Transaction> transactionList = new ArrayList<>();
		int option = -1;
 
		//add default objects
		Currency a = new Currency("MYR","Malaysia Ringt",3.075,3.070);
		currencyList.add(a);

		Currency b = new Currency("KRW","Korean Won",878.73,874.89);
		currencyList.add(b);
		
		holdingList.add(new MoneyHolding("MYR" , 100000));
		holdingList.add(new MoneyHolding("KRW" , 500000));
		
		while (option != 13) {
 
			menu();
			option = Helper.readInt("Enter choice > ");
			if (option == 1) {
				viewAllCurrency(currencyList);
				
			} else if (option == OPTION_2) {
				viewAllCurrency(currencyList);
				addCurrency(currencyList);
			} else if (option == 3) {
				deleteCurrency(currencyList);
			} else if (option == 4) {
				viewAllHoldingAndSgdValue(holdingList,currencyList);
			} else if (option == addHolding) {
				addMoneyHolding(holdingList);
			}  else if (option == 6) {
				deleteMoneyHolding(holdingList);
			}  else if (option == 7) {
				String name = Helper.readString("Enter Currency(ISO) name > ");
				searchRateByCurrency(currencyList,name);
			}  else if (option == 8) {

				String type = Helper.readString("Enter Type of transaction > " );
				String ccin = Helper.readString("Enter Currency in > ");
				double amtin = Helper.readDouble("Enter Amount in > ");
				String ccout = Helper.readString("Enter Currency Out > ");
				convertCurrency(currencyList,type,ccin,amtin,ccout);
			}  else if (option == 9) {
				addTransaction(transactionList, currencyList);
			}  else if (option == 10) {
				viewAllTransaction(transactionList);
			}  else if (option == 11) {
				deleteTransaction(transactionList, 1);
			} else if (option == 12) {
				searchHoldingAndSgdValue(holdingList,currencyList);
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
		System.out.println("13. QUIT");
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

	
	//MEMBER 2 (6) and 3 (7)
	
	public static String viewAllHoldingAndSgdValueTest(ArrayList<MoneyHolding> holdingList,ArrayList<Currency> currencyList) {
		String output = "";
		for (int i =0; i < holdingList.size(); i++) {
			for (int j =0; j < currencyList.size(); j++) {
				String iso = currencyList.get(j).getIso();
				if (holdingList.get(i).getIso().equalsIgnoreCase(iso)) {
					String items [] = holdingList.get(i).toString().split(",");
					
					//GET SELL RATE
					double sellRate = currencyList.get(j).getSellRate();
					//CALCULATE SGD
					double sgdValue = Double.parseDouble(items[1]) * sellRate;
					double curValue = Double.parseDouble(items[1]);
					output += String.format("%-10s %-10.2f %-20.4f\n", items[0], curValue,sgdValue);
				}
				
			}
			}
		return output;
		//System.out.println(output);
	}
	
		public static void viewAllHoldingAndSgdValue(ArrayList<MoneyHolding> holdingList,ArrayList<Currency> currencyList) {
			Helper.line(20, "-");
			System.out.println("VIEW ALL HOLDING");
			Helper.line(20, "-");
			
			String output = String.format("%-10s %-10s %-20s\n", "ISO" , "HOLDINGS" , "SGD_VALUE");
			output+= viewAllHoldingAndSgdValueTest(holdingList,currencyList);
			System.out.println(output);
			
			
			}
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
				public static void searchHoldingAndSgdValue(ArrayList<MoneyHolding> holdingList, ArrayList<Currency> currencyList) {
					
					String curToSearch = Helper.readString("Enter currency to search > ");
					
					String output = String.format("%-10s %-10s %-20s\n", "ISO" , "HOLDINGS" , "SGD_VALUE");
					
					String iso = "";
					double holdingAmt = 0.0;
					
					boolean exist = false;
					// check if exist
					for (MoneyHolding i : holdingList) {
						if (i.getIso().equalsIgnoreCase(curToSearch)) {
						String items [] = i.toString().split(",");
						iso = items[0];
						holdingAmt = Double.parseDouble(items[1]);
						exist = true;
						break;
					}
					}
					// if exist
					if (exist == true) {
						for (int j =0; j <currencyList.size(); j++) {
							if (currencyList.get(j).getIso().equalsIgnoreCase(iso)) {
								//GET SELL RATE
								double sellRate = currencyList.get(j).getSellRate();
								//CALCULATE SGD
								double sgdValue = holdingAmt * sellRate;
								output += String.format("%-10s %-10.2f %-20.4f\n", iso, holdingAmt,sgdValue);
								
							}
							
						}
						
					}
					
					
					System.out.println(output);
				}

	public static void viewAllMoneyHoldingAndSgdValue(ArrayList<MoneyHolding> holdingList,ArrayList<Currency> currencyList) {
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
					output += String.format("%-10s%-10.2f%-20.4f", items[0], items[1],sgdValue);
					System.out.println(output);
					break;
				}
			}
		}
	}
	
	
	//MEMEBER 4 - SEARCH AND CURRNCEY CONVERTER
	public static String searchRateByCurrency(ArrayList<Currency>currencyList,String name) {

		boolean exist = false;
		String output ="";
		System.out.println(String.format("%-10s%-20s%-20s%-20s", "ISO", "CURRENCY", "BUY RATE", "SELL RATE"));
		
		for (Currency i : currencyList)
		{
			if (i.getIso().equalsIgnoreCase(name)) 
			{				
				String items [] = i.toString().split(",");
				output=String.format("%-10s%-20s%-20s%-20s", items[0], items[1], items[2], items[3]);
				
				exist = true;
				return output;
			}
		} 
		
		if (exist == false) {
			output = "Currency does not exist";
			return output;
		}
		
		return output;
	}
	
	public static String convertCurrency(ArrayList<Currency>currencyList, String type, String ccin, double amtin, String ccout) {
			
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
			output = String.format("SELLING %s %.2f for %s %.2f", ccout.toUpperCase(), convertedAmt, ccin.toUpperCase(), amtin);

			System.out.println(output);
			return output;
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
			output = String.format("SELLING %s %.2f for %s %f", ccout.toUpperCase(), convertedAmt, ccin.toUpperCase(), amtin);	

			System.out.println(output);
			return output;
		}
		else
		{
			output = "invalid type";
			System.out.println(output);
			return output;
		}
	}
	
	
	//MEMBER 5 - TRANSACTION
	public static double getrate(ArrayList<Currency> Currency , String a,String type) {
		double rate =0;
		for(int i = 0 ; i < Currency.size();i++)
		{
			if(Currency.get(i).getIso().equalsIgnoreCase(a))
			{if(type.equalsIgnoreCase("BUY")) {
				rate=Currency.get(i).getBuyRate();
				return rate;
				}
			else if (type.equalsIgnoreCase("SELL")) {
				rate = Currency.get(i).getSellRate();
				return rate;
			}
			}
		} 
		return rate;
		
	}

	public static Transaction inputTransaction(ArrayList<Currency>currencyList) {

		Helper.line(20, "-");
        System.out.println("ADD TRANSACTION");
        Helper.line(20, "-");
        int typei = Helper.readInt("Chose your transaction type (1)BUY (2)SELL >");
       
        String ccin = Helper.readString("Enter currency in > ");
        double amtin = Helper.readDouble("Enter amount in > ");
      
        
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
	        if (!type.equals(null) && !ccin.equals(null) && amtin != 0 ) {
	        	if(type.equalsIgnoreCase("BUY")) {
	        		System.out.println(currencyList+ccin);
	        		rate= getrate(currencyList, ccin, "BUY");
	        	Transaction t = new Transaction(LocalDateTime.now(),currencyList.size()+1, type, ccin, amtin, "SGD", (amtin*rate),rate );
	            //update holding munus (amtin*rate)
	        	return t;
	            }
	        	else if(type.equalsIgnoreCase("SELL")) {
	        		rate=getrate(currencyList, "SGD", "SELL");
	            	Transaction t = new Transaction(LocalDateTime.now(),currencyList.size()+1, type, "SGD", amtin, ccin, (amtin*rate),rate );
	            	
	                return t;}
	        	 //update holding plus (amtin*rate)
	        }
	        else
	        {
	        	return null;
	        }
	        
	        return null;
	} 
	
	
	public static void addTransaction(ArrayList<Transaction> transactionList,ArrayList<Currency>currencyList) {
			transactionList.add(inputTransaction(currencyList));
			System.out.println("Transaction Added!");
		} 

	
	public static void viewAllTransaction(ArrayList<Transaction> transactionList) {
		Helper.line(20, "-");
		System.out.println("VIEW ALL TRANSACTIONS");
		System.out.println(String.format("%-10s%-10s%-20s%-10s%-20s%-20s%-10s", "DATE", "TYPE", "CURRENCY IN", "AMOUNT IN", "CURRENCY OUT","AMOUNT OUT","RATE"));

		Helper.line(20, "-");
		for (Transaction i : transactionList) {

			String items [] = i.toString().split(",");
			System.out.println(String.format("%-10s%-10s%-20s%-10s%-20s%-20s%-10s", items[0], items[1], items[2], items[3],items[4],items[5],items[6]));

		} 
	}
	
	public static void deleteTransaction(ArrayList<Transaction>transactionList,int id) {
		id=Helper.readInt("Enter the transaction ID of the record:");
        for(int i =0; i<transactionList.size(); i++) {
               if(transactionList.get(i).getTrid()==id) {
                transactionList.remove(i);
               }
               else {
                System.out.println("Transaction not found!");
               }
              }
    }
	
	
}
