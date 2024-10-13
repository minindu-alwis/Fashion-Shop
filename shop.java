import java.util.*;
class shop{
	public static Scanner input=new Scanner(System.in);
	public static int z=0;
	public static String[] tshirtsizes={"XS","S","M","L","XL","XXL"};
	public static String[] phonenumber=new String[0];
	public static String[] size=new String[0];
	public static int[] qty=new int[0]; 
	public static int[] amount=new int[0];
	public static int[] orderstatus=new int[0];
	public static String[] realorderid=new String[0];
	public static final int PROCESSING=0;
	public static final int DELIVERING=1;
	public static final int DELIVERED=2;
	
//================================================Clear Console Method Start==============================================================	
	public final static void clearConsole() { 
		try {
		final String os = System.getProperty("os.name"); 
		if (os.contains("Windows")) {
		new ProcessBuilder("cmd", "/c", 
		"cls").inheritIO().start().waitFor();
		} else {
		System.out.print("\033[H\033[2J"); 
		System.out.flush();
		}
		} catch (final Exception e) {
		e.printStackTrace();
		// Handle any exceptions.
		}
		}

//================================================Clear Console Method End==============================================================		
//================================================Main Method Start=====================================================================	
	public static void main(String args[]){	
		homePage();
	
	}//Main method eke
//================================================Main Method End=====================================================================		
//================================================Home Page Method Start==============================================================	
	public static void homePage(){
		System.out.println("\n");
		System.out.println("\t /$$$$$$$$                 /$$       /$$                            /$$$$$$  /$$                          ");
		System.out.println("\t| $$_____/                | $$      |__/                           /$$__  $$| $$                          ");
		System.out.println("\t| $$    /$$$$$$   /$$$$$$$| $$$$$$$  /$$  /$$$$$$  /$$$$$$$       | $$  \\__/| $$$$$$$   /$$$$$$   /$$$$$$ ");
		System.out.println("\t| $$$$$|____  $$ /$$_____/| $$__  $$| $$ /$$__  $$| $$__  $$      |  $$$$$$ | $$__  $$ /$$__  $$ /$$__  $$");
		System.out.println("\t| $$__/ /$$$$$$$|  $$$$$$ | $$  \\ $$| $$| $$  \\ $$| $$  \\ $$       \\____  $$| $$  \\ $$| $$  \\ $$| $$  \\ $$");
		System.out.println("\t| $$   /$$__  $$ \\____  $$| $$  | $$| $$| $$  | $$| $$  | $$       /$$  \\ $$| $$  | $$| $$  | $$| $$  | $$");
		System.out.println("\t| $$  |  $$$$$$$ /$$$$$$$/| $$  | $$| $$|  $$$$$$/| $$  | $$      |  $$$$$$/| $$  | $$|  $$$$$$/| $$$$$$$/");
		System.out.println("\t|__/   \\_______/|_______/ |__/  |__/|__/ \\______/ |__/  |__/       \\______/ |__/  |__/ \\______/ | $$____/ ");
		System.out.println("\t                                                                                                | $$      ");
		System.out.println("\t                                                                                                | $$      ");
		System.out.println("\t                                                                                                |__/      ");
		System.out.println("\n");
		System.out.println("\t_________________________________________________________________________________________________________");
		System.out.println("\n");
		System.out.println("\t\t[1] Place Order                                        [2] Search Customer");
		System.out.println("\n");
		System.out.println("\t\t[3] Search Order                                       [4] View Reports");
		System.out.println("\n");
		System.out.println("\t\t[5] Set Order Status                                   [6] Delete Order");
		System.out.println("\n");
		System.out.print("\t\tInput Option : ");
		int option=input.nextInt();
		clearConsole();
		switch(option){
			
			case 1:
					placeOrder();
					break;
			
			case 2:
					searchCustomer();
					break;
			
			case 3:
					searchOrder();
					break;
			
			case 4:
					viewreports();
					break;
					
			case 5:
					setOrderStatus();
					break;
				
			case 6:
					deleteOrder();
					break;
			
			default:
					System.out.println("\t\tInvalid Input.......");
					homePage();
					break;								
			
			
			
			
			}//Swtich eke
	
	
	}//home page eke	
//================================================Home Page Method End==================================================================	

//================================================Place Order Method Start==================================================================	

	public static void placeOrder(){
		System.out.println("\n");
		System.out.println("\t  _____  _                   ____          _           ");
		System.out.println("\t |  __ \\| |                 / __ \\        | |          ");
		System.out.println("\t | |__) | | __ _  ___ ___  | |  | |_ __ __| | ___ _ __ ");
		System.out.println("\t |  ___/| |/ _` |/ __/ _ \\ | |  | | '__/ _` |/ _ \\ '__|");
		System.out.println("\t | |    | | (_| | (_|  __/ | |__| | | | (_| |  __/ |   ");
		System.out.println("\t |_|    |_|\\__,_|\\___\\___|  \\____/|_|  \\__,_|\\___|_|   ");
		System.out.println("\n");
		System.out.println("\t_______________________________________________________");
		System.out.println("\n");
		
		orderId();
		System.out.println();
    
    // Enter phone number
		String validatedPhoneNumber=phoneNumberValidate();
		if (validatedPhoneNumber.equals("not")) {
			System.out.println("\n\tBye Sudda !!!!!!!!!!!!!!!");
			return;
		}
		System.out.println();
		
		// Enter size
		String lastsize=size();
		System.out.println();
		
		// Enter quantity
		int lastqty=getquantity();
		if (lastqty==0) {
			return;	
		}
		

		double lastamount=getamount(lastqty, lastsize);
		System.out.printf("\n\tAmount : %.2f", lastamount);
		System.out.println();
		
		System.out.print("\n\tDo you want to place this order? (y/n) : ");
		char option = input.next().charAt(0);
		if (option == 'y' || option == 'Y') {
			System.out.println("\n\t\tOrder Placed..!");
			z++;//orderid increment
			
			// Temparrays for extend
			String[] tempphone=new String[phonenumber.length + 1];
			String[] tempsize=new String[size.length + 1];
			int[] tempqty=new int[qty.length + 1];
			int[] tempamount=new int[amount.length + 1];
			int[] tempstatus=new int[orderstatus.length + 1];
			String[] temprealoderid=new String[realorderid.length + 1];
			
			// copy data to array
			for (int i=0;i<realorderid.length;i++) {
				tempphone[i]=phonenumber[i];
				tempsize[i]=size[i];
				tempqty[i]=qty[i];
				tempamount[i]=amount[i];
				tempstatus[i]=orderstatus[i];
				temprealoderid[i]=realorderid[i];
			}

			// new oderdetails add to temp
			tempphone[tempphone.length-1] =validatedPhoneNumber;
			tempsize[tempsize.length-1]=lastsize;
			tempqty[tempqty.length-1]=lastqty;
			tempamount[tempamount.length-1]=(int)lastamount;
			tempstatus[tempstatus.length-1]=PROCESSING; 
			temprealoderid[temprealoderid.length-1]="ODR#" + String.format("%05d", z); // New order ID

			// temp to main arrays
			phonenumber = tempphone;
			size=tempsize;
			qty=tempqty;
			amount=tempamount;
			orderstatus=tempstatus;
			realorderid=temprealoderid; 
			
			/*System.out.println(Arrays.toString(phonenumber));
			System.out.println(Arrays.toString(size));
			System.out.println(Arrays.toString(qty));
			System.out.println(Arrays.toString(amount));
			System.out.println(Arrays.toString(orderstatus));
			System.out.println(Arrays.toString(realorderid));*/
			
			}else{
				// not place
				System.out.println("\n\t\tOrder not placed!!!!!!!!!!!!!!!!!!!!!");
			}//if end
			
			System.out.print("\n\tDo you want to place another order? (y/n) : ");	
			char yesnoo = input.next().charAt(0);
			clearConsole();
			if(yesnoo=='y' || yesnoo=='Y'){
				placeOrder();
			}else{
				homePage();
			}
		
	}//place order eke
	                                                  
//================================================Place Order Method Start==================================================================	

//================================================OrderID Method Start==================================================================
		
    public static void orderId(){
			
        System.out.printf("\tEnter Order ID : ODR#%05d%n", z+1);
       		  
	  }//oder id method

//================================================OrderID Method End==================================================================	

//================================================phoneNumberValidate Method Start==================================================================	

	public static String phoneNumberValidate(){
		
		System.out.print("\tEnter Phone Number : ");
		String phoneNumber=input.next();
		
		if(phoneNumber.length()==10 && phoneNumber.charAt(0)=='0'){
			return phoneNumber;
			}else{
				System.out.println("\n\t\tInvalid Phone number... Try again");
				System.out.print("\n\tDo you wan to enter phone number agin? (y/n) : ");
				char yesno=input.next().charAt(0);
				if(yesno=='y' || yesno=='Y'){
					System.out.print("\033[5A");//go to phone number
					System.out.print("\033[0J");//clear enterd phone number
					return phoneNumberValidate();
					}else{
						return "not";
						}
				
				}	
		
		}//phone number validation eka

//================================================phoneNumberValidate Method End==================================================================	

//================================================Size Method Strat=================================================================================

	public static String size(){	
		System.out.print("\tEnter T-Shirt Size (XS/S/M/L/XL/XXL): ");
		String tsize=input.next().toUpperCase();
		
		boolean isValidsize=false;
		for(int a=0;a<6;a++){
			
			if(tsize.equals(tshirtsizes[a])){
				isValidsize=true;
				break;
				}
					
			}
			if(isValidsize){
				return tsize;
				}
					
					System.out.print("\033[1A");//go to phone number
					System.out.print("\033[0J");//clear enterd phone number
					return size();
		
		}//size method eke eka
//================================================Size Method End=================================================================================

//================================================getquantity Method Strat=================================================================================

	public static int getquantity(){
		
		System.out.print("\tEnter QTY : ");
		int qty=input.nextInt();
		if(qty<=0){
		   System.out.print("\033[1A");
           System.out.print("\033[0J");
           	getquantity();
           	return 0;		
			}
			return qty;		
		
		}//getquantity eke
		
//================================================getquantity() Method End=================================================================================	

//================================================getamount Method Strat=================================================================================

		public static int getamount(int qty, String size){
		int amount=0;
        switch (size)
	   {
		case "XS": 
			amount=qty*600;
			break;
		case "S":
			amount=qty*800;
			break;
		case "M":
			amount=qty*900;
			break;
		case "L":
			amount=qty*1000;
			break;
		case "XL":
			amount=qty*1100;
			break;
		case "XXL":
			amount=qty*1200;
			break;
	   }
	   return amount;
		
		}//getamount eke

//================================================getamount Method End=================================================================================

//-----------------------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------place order end-------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------Search customer Start-------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------------------------------------------

	public static void searchCustomer(){
		System.out.println("\n");
		System.out.println("\t   _____                     _        _____          _                            ");
		System.out.println("\t  / ____|                   | |      / ____|        | |                           ");
		System.out.println("\t | (___   ___  __ _ _ __ ___| |__   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ");
		System.out.println("\t  \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__|");
		System.out.println("\t  ____) |  __/ (_| | | | (__| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |   ");
		System.out.println("\t |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|   ");
		System.out.println("\t_________________________________________________________________________________");
		System.out.println("\n");
		System.out.println("\n");
		int data[] = new int[6];
		System.out.print("\tEnter Customer Phone Number : ");
		String inputphonenumber=input.next();
//public static String[] tshirtsizes={"XS","S","M","L","XL","XXL"};		
		boolean found = false;
		for(int i=0;i<phonenumber.length;i++){
			if(inputphonenumber.equals(phonenumber[i])){
				found=true;
				
				String sizemind = "";
                int index =0;
                
                for (int m = 0; m < phonenumber.length; m++) {
                    if (inputphonenumber.equals(phonenumber[m])) {
                        switch (size[m]) {
                            case "XS": index = 0; break;
                            case "S": index = 1; break;
                            case "M": index = 2; break;
                            case "L": index = 3; break;
                            case "XL": index = 4; break; 
                            case "XXL": index = 5; break;
                            default: break; 
                        }//switch eke
                        data[index]+=qty[m];// Increment the quantity for the size
                    }//if eke
                }// 2nd for loop

                // print The table Strat---------------------------------------------------------------------------------------------------------------
                System.out.println("\n");
                System.out.printf("%s", "\t\t+----------+---------+---------------+");
                System.out.printf("%s", "\n\t\t|   Size   |  QTY    |    Amount     |");
                System.out.printf("%s", "\n\t\t+----------+---------+---------------+");

                double total=0;
				for (int d=0;d<tshirtsizes.length;d++) {
                double amount = calculateamount(tshirtsizes[d], data[d]);
                System.out.printf("\n\t\t|    %3s   |  %3d    |    %8.2f   |", tshirtsizes[d], data[d], amount);
                total += amount;
				}//me for eke

				System.out.printf("%s", "\n\t\t+----------+---------+---------------+");
                System.out.printf("%s%.2f%s", "\n\t\t|  Total Amount      |  ", total, "      |");
                System.out.printf("%s", "\n\t\t+----------+---------+---------------+\n");
                break; // Exit loop --> customer found
				
				// print The table End---------------------------------------------------------------------------------------------------------------
			
				
				}//first if
			}//for eke	
		
			if(!found){//number eka array eke nathinam
					System.out.println("\n\t\tInvalid input..............");
					System.out.print("\n\tDo you want to search another customer report? (y/n) : ");
					char yesnosc=input.next().charAt(0);
					clearConsole();
					if(yesnosc=='Y' || yesnosc=='y'){
						searchCustomer();
						}else{
							homePage();
							}
					
					}//second if
		//search another number			
			System.out.println("\n");		
			System.out.print("\tDo you want to search another customer report? (y/n) : ");
				char yesnor=input.next().charAt(0);
				clearConsole();
				if(yesnor=='Y' || yesnor=='y'){
					searchCustomer();
					}else{
						homePage();
						}

	}//searchcustomer eke


//-----------------------------------------calculateamount method Start---------------------------------------------------

	public static int calculateamount(String size, int qty) {
        int realamount = 0;
        switch (size) {
            case "XS": realamount =qty*600; break;
            case "S": realamount=qty*800; break;
            case "M": realamount=qty*900; break;
            case "L": realamount=qty*1000; break;
            case "XL": realamount=qty*1100; break;
            case "XXL": realamount=qty*1200; break; 
        }
        return realamount;
    }//calculateamount eke

//-----------------------------calculateamount method End----------------------------------------------------------

//-----------------------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------Search customer End-------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------Search order Start-------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------------------------------------------

	public static void searchOrder(){
		System.out.println("\n");
		System.out.println("\t   _____                     _        ____          _           ");
		System.out.println("\t  / ____|                   | |      / __ \\        | |          ");
		System.out.println("\t | (___   ___  __ _ _ __ ___| |__   | |  | |_ __ __| | ___ _ __ ");
		System.out.println("\t  \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |  | | '__/ _` |/ _ \\ '__|");
		System.out.println("\t  ____) |  __/ (_| | | | (__| | | | | |__| | | | (_| |  __/ |   ");
		System.out.println("\t |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\____/|_|  \\__,_|\\___|_|   ");
		System.out.println("\t_________________________________________________________________");
		System.out.println("\n");
		System.out.println("\n");
		
		System.out.print("\tEnter order ID : ");
		String inputorderid=input.next().toUpperCase();
		
		
		int index=searchcustomerid(inputorderid);
		
		if(index==-1){
			System.out.println("\n\t\tInvalid ID ................");
			}else{
				showCustomerdetails(index);
				System.out.print("\n\tDo you want to search another order? (y/n) : ");
				char yesno=input.next().charAt(0);
				clearConsole();
					if(yesno=='Y' || yesno=='y'){
						searchOrder();
						}else{
							homePage();
							}
					
					
				}//if eka		
		System.out.print("\n\tDo you want to search another order? (y/n) : ");
		char orderyesno=input.next().charAt(0);
		clearConsole();
		if(orderyesno=='y' || orderyesno=='Y'){
			searchOrder();
			}else{
				
				homePage();
				
				}	    


	}//search order eke

//-----------------------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------Search order End-------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------Delete order Start-------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------------------------------------------

 
	public static void deleteOrder(){
		System.out.println("\n");
		System.out.println("\t  _____       _      _          ____          _           ");
		System.out.println("\t |  __ \\     | |    | |        / __ \\        | |          ");
		System.out.println("\t | |  | | ___| | ___| |_ ___  | |  | |_ __ __| | ___ _ __ ");
		System.out.println("\t | |  | |/ _ \\ |/ _ \\ __/ _ \\ | |  | | '__/ _` |/ _ \\ '__|");
		System.out.println("\t | |__| |  __/ |  __/ ||  __/ | |__| | | | (_| |  __/ |   ");
		System.out.println("\t |_____/ \\___|_|\\___|\\__\\___|  \\____/|_|  \\__,_|\\___|_|   ");
		System.out.println("\t______________________________________________________________");
		System.out.println("\n");
		System.out.println("\n");
		System.out.print("\tEnter order ID : ");
		String inputorderid=input.next().toUpperCase();


		int index=searchcustomerid(inputorderid);
		
		if(index==-1){
			System.out.println("\n\t\tInvalid orderid ................");
			}else{
				showCustomerdetails(index);
				System.out.print("\n\tDo you want to delete this order (y/n) : ");
				char yesno=input.next().charAt(0);
				if(yesno=='Y' || yesno=='y'){
						removeCustomer(index);
						System.out.println("\n\t\tOrder Deleted ...! ");
					}else{
						clearConsole();
						homePage();
						}//else eke
					
					
				}//if eka		
		System.out.print("\n\tDo you want to delete another order? (y/n) : ");
		char orderyesno=input.next().charAt(0);
		clearConsole();
		if(orderyesno=='y' || orderyesno=='Y'){
			deleteOrder();
			}else{
				homePage();
				}	       

                                                                                                      
                                                          
	}//deleteOrder eke
	
//-----------search customer id & get it method start-------
	public static int searchcustomerid(String inputorderid){
		for(int i=0;i<realorderid.length;i++){
			if(realorderid[i].equals(inputorderid)){
				
				return i;
				
				}//if eke
			
			}//for eke
	return -1;
	
	}//searchcustome eke
	
//----------------search customer & get it method end--------------------------------	

//----------------------show customer details method start--------------------

	public static void showCustomerdetails(int index){
		System.out.println("\n\tPhone Number : "+phonenumber[index]);
		System.out.println("\tSize         : "+ size[index]);
		System.out.println("\tQTY          : "+qty[index]);
		System.out.printf("\tAmount       : %.2f%n", (double)amount[index]);
		System.out.println("\tStatus       : " +(orderstatus[index]==0 ? "Processing" : orderstatus[index]==1 ? "DELIVERING" : orderstatus[index]==2 ? "DELIVERED" : "NOT VALID STATUS"));
		
		}//show customer detatils eke
		
//----------------------show customer details End--------------------		
		
//---------------------------removecustomer method start------------------


	public static void removeCustomer(int index){
    String[] deletetemprealorderid=new String[realorderid.length-1];
    String[] deletetempphonenumber=new String[phonenumber.length-1];
    String[] deletetempsize=new String[size.length-1];
    int[] deletetempqty=new int[qty.length-1];
    int[] deletetempamount=new int[amount.length-1];    
    int[] deletetemporderstatus=new int[orderstatus.length-1];    
    
    // copy after index valuse
    for(int i=index; i<phonenumber.length-1; i++){
        deletetemprealorderid[i]=realorderid[i+1];
        deletetempphonenumber[i]=phonenumber[i+1];
        deletetempsize[i]=size[i+1];
        deletetempqty[i]=qty[i+1];
        deletetempamount[i]=amount[i+1];
        deletetemporderstatus[i]=orderstatus[i+1];
    }
    
    // copy valuse to index
    for(int i=0; i<index; i++){
        deletetemprealorderid[i]=realorderid[i];
        deletetempphonenumber[i]=phonenumber[i];
        deletetempsize[i]=size[i];
        deletetempqty[i]=qty[i];
        deletetempamount[i]=amount[i];
        deletetemporderstatus[i]=orderstatus[i];
    }
    
    // deletetoarrays copy for main arrays
    realorderid=deletetemprealorderid;
    phonenumber=deletetempphonenumber;
    size=deletetempsize;
    qty=deletetempqty;
    amount=deletetempamount;
    orderstatus=deletetemporderstatus;
    
	}//remove customer eke
//---------------------------removecustomer method End------------------

//-----------------------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------Delete order End-------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------Set Order Status Start-------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------------------------------------------


	public static void setOrderStatus(){
		System.out.println("\n");
		System.out.println("\t   ____          _              _____ _        _             ");
		System.out.println("\t  / __ \\        | |            / ____| |      | |            ");
		System.out.println("\t | |  | |_ __ __| | ___ _ __  | (___ | |_ __ _| |_ _   _ ___ ");
		System.out.println("\t | |  | | '__/ _` |/ _ \\ '__|  \\___ \\| __/ _` | __| | | / __|");
		System.out.println("\t | |__| | | | (_| |  __/ |     ____) | || (_| | |_| |_| \\__ \\");
		System.out.println("\t  \\____/|_|  \\__,_|\\___|_|    |_____/ \\__\\__,_|\\__|\\__,_|___/");
		System.out.println("\t______________________________________________________________");
		System.out.println("\n");
		System.out.println("\n");
		System.out.print("\tEnter order ID : ");
		String inputorderid=input.next().toUpperCase();


		int index=searchcustomerid(inputorderid);
		
		if(index==-1){
			System.out.println("\n\t\tInvalid orderid ................");
			}else{
				showCustomerdetails(index);
				
				if(orderstatus[index]==2){//delivered num eka para cus details ekk cant change this pennan (delivering thibboth if eka)	
				System.out.println("\n\t\tCan't change this order status, Order alredy delivered....!");
			
					}else{//ehem naththam wenas karannd kiyala ahanna
				System.out.print("\n\tDo you want to change this order status? (y/n) : ");
				char yesno=input.next().charAt(0);
				if(yesno=='Y' || yesno=='y'){
					
					changeStatus(index);
									
					}else{//no dunnoth
						clearConsole();
						homePage();
						}//else eke
					
				}
				}//if eka		
				
		//method run wela iwara unama
				
		System.out.print("\n\tDo you want to change another order Status? (y/n) : ");
		char orderyesno=input.next().charAt(0);
		clearConsole();
		if(orderyesno=='y' || orderyesno=='Y'){
			setOrderStatus();
			}else{
				homePage();
				}	       

                                                                                                      
                                                          
	}//setOrderStatus eke

//-----------------change order status method start ----------------------------

	public static void changeStatus(int index){
			if(orderstatus[index]==0){
				System.out.println("\n\t\t[1] Order Delivering");
				System.out.println("\n\t\t[2] Order Delivered");
				System.out.print("\n\tEnter Option : ");
					int option=input.nextInt();
								
					switch(option){
									
							case 1:
								changetodelivering(index);
								break;
							case 2:
								changetodevlivered(index);
								break;
							default:
								System.out.println("\n\t\tInvalid input...................");
								invalidinputt(index);
								break;
									
					}//switch eke
								
				System.out.println("\n\t\tStatus Updated !!!!!!");	
							
				}//processing thibboth if eka
							
				else if(orderstatus[index]==1){
					System.out.println("\n\t\t[1] Order Delivered");
					System.out.print("\n\tEnter Option : ");
						int option2=input.nextInt();
							
							switch(option2){
									
								case 1:
									changetodevlivered(index);
									break;
										
								default:
									System.out.println("\n\t\tInvalid input...................");
									invalidinput(index);
									break;
										
									
								}//switch eke
						System.out.println("\n\t\tStatus Updated !!!!!!");	
					}
							
	}//change order status eke
	
//-----------------change order status method End ----------------------------

//-----------------change todelivering method start ----------------------------

	public static void changetodelivering(int index){
		
		orderstatus[index]=DELIVERING;
		
		}//changetodelivering  eke 	

//-----------------change to delivering method end ----------------------------	

//-----------------change to devlivered method start ----------------------------	
		
	public static void changetodevlivered(int index){
				
		orderstatus[index]=DELIVERED;

		}//changetodevlivered eke	
		
//-----------------change to devlivered method End ----------------------------		


//-----------------invalidinput in deververing method start ----------------------------	
		
	public static void invalidinput(int index){
		System.out.print("\n\tEnter Option : ");
		int option=input.nextInt();
		
		if(option!=1){
			System.out.println("\n\t\tInvalid input...................");
			invalidinput(index);
			}else{
				changetodevlivered(index);
				}
		}//invalidinput eke	
		
//-----------------invalidinput in deververing method End ----------------------------	

//-----------------invalidinput processing method start ----------------------------	
		
	public static void invalidinputt(int index){
		System.out.print("\n\tEnter Option : ");
		int option=input.nextInt();
		
		if(option==1){
			changetodelivering(index);
			
			}else if(option==2){
				changetodevlivered(index);
				}else{
					System.out.println("\n\t\tInvalid input...................");
					invalidinputt(index);
					}

		}//invalidinput eke	
		
//-----------------invalidinput processing method End ----------------------------		

//-----------------------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------Set Order Status End-------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------View Reports Start-------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	public static void viewreports(){
		System.out.println("\n");
		System.out.println("\t  _____                       _       ");
		System.out.println("\t |  __ \\                     | |      ");
		System.out.println("\t | |__) |___ _ __   ___  _ __| |_ ___ ");
		System.out.println("\t |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
		System.out.println("\t | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
		System.out.println("\t |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
		System.out.println("\t            | |                       ");
		System.out.println("\t            |_|                       ");
		System.out.println("\t_______________________________________");
		System.out.println("\n");
		System.out.println("\t\t[1] Customer Reports");
		System.out.println("\n\t\t[2] Item Reports");
		System.out.println("\n\t\t[3] Orders Reports");
		System.out.println("\n");
		
		System.out.print("\tEnter Option : ");
		int optionr=input.nextInt();
		
		switch(optionr){
			
			case 1:
				clearConsole();
				customerreports();
				break;
				
			case 2:
				clearConsole();
				itemreports();
				break;
				
			case 3:
				clearConsole();
				ordersreportstables();
				break;		
			
			default:
				System.out.println("\n\t\tInvalid input........");
				System.out.print("\n\tDo you want to enter option agin? (y/n) : ");
				char orderyesno=input.next().charAt(0);
				clearConsole();
					if(orderyesno=='y' || orderyesno=='Y'){
							viewreports();
					}else{
							clearConsole();
							homePage();
					}//if eke	        
				
			}//switch eke

	}//viewreports

//------------------------------------------------------------------------	
//------------------------Reports Walata Adala Methods Start--------------	
//------------------------------------------------------------------------
//------------------------customer reports method Start-------------------	

	public static void customerreports(){
		
		System.out.println("\n");
		System.out.println("\t   _____          _                              _____                       _       ");
		System.out.println("\t  / ____|        | |                            |  __ \\                     | |      ");
		System.out.println("\t | |    _   _ ___| |_ ___  _ __ ___   ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___ ");
		System.out.println("\t | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
		System.out.println("\t | |___| |_| \\__ \\ || (_) | | | | | |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
		System.out.println("\t  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
		System.out.println("\t                                                           | |                       ");
		System.out.println("\t                                                           |_|                       ");
		System.out.println("\t_______________________________________________________________________________________");
		System.out.println("\n");
		System.out.println("\t\t[1] Best in Customers");
		System.out.println("\n\t\t[2] View Customers");
		System.out.println("\n\t\t[3] All Customer Report");
		System.out.println("\n");
            		
		System.out.print("\tEnter Option : ");
		int optioncr=input.nextInt();
		
		
		switch(optioncr){
			
			case 1:
				clearConsole();
				bestincustomers();
				break;
				
			case 2:
				clearConsole();
				viewcustomers();
				break;
				
			case 3:
				clearConsole();
				allcustomerreport();
				break;		
			
			default:
				System.out.println("\n\t\tInvalid input........");
				System.out.print("\n\tDo you want to enter option agin? (y/n) : ");
				char orderyesno=input.next().charAt(0);
				clearConsole();
					if(orderyesno=='y' || orderyesno=='Y'){
							customerreports();
					}else{
							viewreports();
					}//if eke	        
				
			}//switch eke
	
		}//customer reports eke

//------------------------customer reports method end-------------------	

//------------------------item reports method Start-------------------

	public static void itemreports(){
		System.out.println("\n");
		System.out.println("\t  _____ _                   _____                       _       ");
		System.out.println("\t |_   _| |                 |  __ \\                     | |      ");
		System.out.println("\t   | | | |_ ___ _ __ ___   | |__) |___ _ __   ___  _ __| |_ ___ ");
		System.out.println("\t   | | | __/ _ \\ '_ ` _ \\  |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
		System.out.println("\t  _| |_| ||  __/ | | | | | | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
		System.out.println("\t |_____|\\__\\___|_| |_| |_| |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
		System.out.println("\t                                      | |                       ");
		System.out.println("\t                                      |_|                       ");
		System.out.println("\t______________________________________________________________");
		System.out.println("\n");
		System.out.println("\t\t[1] Best Selling Catgories Sorted by QTY");
		System.out.println("\n\t\t[2] Best Selling Categories Sorted by Amount");
		System.out.println("\n");
		
            		
		System.out.print("\tEnter Option : ");
		int optionir=input.nextInt();
		
		switch(optionir){
			
			case 1:
				clearConsole();
				sortedbyQTY();
				break;
				
			case 2:
				clearConsole();
				sortedbyamount();
				break;	
			
			default:
				System.out.println("\n\t\tInvalid input........");
				System.out.print("\n\tDo you want to enter option agin? (y/n) : ");
				char orderyesno=input.next().charAt(0);
				clearConsole();
					if(orderyesno=='y' || orderyesno=='Y'){
							itemreports();
					}else{
							viewreports();
					}//if eke	        
				
			}//switch eke
		
		
		
		}//item reports eke

//------------------------item reports method end-------------------

//------------------------orders reports method Start-------------------

	public static void ordersreportstables(){
		System.out.println("\n");
		System.out.println("\t   ____          _             _____                       _       ");
		System.out.println("\t  / __ \\        | |           |  __ \\                     | |      ");
		System.out.println("\t | |  | |_ __ __| | ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___ ");
		System.out.println("\t | |  | | '__/ _` |/ _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
		System.out.println("\t | |__| | | | (_| |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
		System.out.println("\t  \\____/|_|  \\__,_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
		System.out.println("\t                                         | |                       ");
		System.out.println("\t                                         |_|                       ");
		System.out.println("\t____________________________________________________________________");
		System.out.println("\n");
		System.out.println("\t\t[1] All Orders");
		System.out.println("\n\t\t[2] Orders By Amount");
		System.out.println("\n");
		
            		
		System.out.print("\tEnter Option : ");
		int optionir=input.nextInt();

		switch(optionir){
			
			case 1:
				clearConsole();
				allorders();
				break;
				
			case 2:
				clearConsole();
				ordersbyamount();
				break;	
			
			default:
				System.out.println("\n\t\tInvalid input........");
				System.out.print("\n\tDo you want to enter option agin? (y/n) : ");
				char orderyesno=input.next().charAt(0);
				clearConsole();
					if(orderyesno=='y' || orderyesno=='Y'){
							ordersreportstables();
					}else{
							viewreports();
					}//if eke	        
				
			}//switch








		
		
		
		}//orders reports eke

//------------------------orders reports method end-------------------
//------------------------------------------------------------------------	
//------------------------Reports Walata Adala Methods End--------------	
//------------------------------------------------------------------------

//-------------------------------------------------------------------------------	
//------------------------Customer Reports Walata Adala Methods Start--------------	
//-----------------------------------------------------------------------------

//------------------------best in customers method end-------------------	
	public static void bestincustomers(){
		System.out.println("\n");
		System.out.println("\t  ____            _     _____          _____          _                                ");
		System.out.println("\t |  _ \\          | |   |_   _|        / ____|        | |                               ");
		System.out.println("\t | |_) | ___  ___| |_    | |  _ __   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ___ ");
		System.out.println("\t |  _ < / _ \\/ __| __|   | | | '_ \\  | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__/ __|");
		System.out.println("\t | |_) |  __/\\__ \\ |_   _| |_| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |  \\__ \\");
		System.out.println("\t |____/ \\___||___/\\__| |_____|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  |___/ ");
		System.out.println("\t_______________________________________________________________________________________");
		System.out.println("\n");
		
		System.out.println("\n");
			
		//phone number lenth=uniqe ewa thiyen nisa	
		String[] uniqueCustomers=new String[phonenumber.length];
		int[] totalQty=new int[phonenumber.length];
		double[] totalAmount=new double[phonenumber.length];
		int uniqueCount=0;

		//get details for orders
		for (int i=0; i<phonenumber.length;i++){
			String customer=phonenumber[i];
			int quantity=qty[i];
			double itemAmount=calculateamount(size[i],qty[i]); //method to get amount

			// check the customer in array......
			int customerIndex=-1;
			for (int j=0;j<uniqueCount;j++){
				if (uniqueCustomers[j].equals(customer)){
					customerIndex=j;
					break;
				}
			}//second for

			if (customerIndex == -1) {
				// new phonenum
				uniqueCustomers[uniqueCount]=customer;
				totalQty[uniqueCount]=quantity;
				totalAmount[uniqueCount]=itemAmount;
				uniqueCount++; //unique cus ++
			} else {
				//alredy have.....add totl and qty
				totalQty[customerIndex]+=quantity;
				totalAmount[customerIndex]+=itemAmount;
			}
		}//first for
		
		//sort to amount
		 for (int i=0;i<uniqueCount-1;i++){
			for (int j=i+1;j<uniqueCount; j++){
				if (totalAmount[i]<totalAmount[j]){
					double tempAmount = totalAmount[i];
					totalAmount[i]=totalAmount[j];
					totalAmount[j]=tempAmount;
					
					int tempQty=totalQty[i];
					totalQty[i]=totalQty[j];
					totalQty[j]=tempQty;
					
					String tempCustomer=uniqueCustomers[i];
					uniqueCustomers[i]=uniqueCustomers[j];
					uniqueCustomers[j]=tempCustomer;
				}//if eke
			}//secon for
		}//first for
		
		//print the table
		System.out.println("\t\t+----------------+---------+---------------+");
		System.out.println("\t\t|  Customer ID   | All QTY |  Total Amount  |");
		System.out.println("\t\t+----------------+---------+---------------+");

	   for (int i = 0; i < uniqueCount; i++) {
			System.out.printf("\t\t| %12s   |    %2d   |  %10.2f   |\n", uniqueCustomers[i],totalQty[i],totalAmount[i]);
		}

		System.out.println("\t\t+----------------+---------+---------------+");
		
			System.out.println("\n");
			
			System.out.print("\tTo access the Main Menu, Please Enter 0 : ");
			int exitto=input.nextInt();
			clearConsole();
			if(exitto==0){
				homePage();
				}else{
					bestincustomers();
					}                                                                    
																						   
			
			
		}//bestincustomers

//------------------------best in customers method end-------------------	

//------------------------calcutale amount for reports method Strat-------------------			
		
	public static double calculateamountt(String size, int qty) {
		double price=0.0;
		switch(size){
			case "XS": price=600.0;break;
			case "S": price=800.0;break;
			case "M": price=900.0;break;
			case "L": price=1000.0;break;
			case "XL": price=1100.0;break;
			case "XXL": price=1200.0;break;
		}
		return price * qty;
	}//calculateamountt eke		
		
//------------------------calcutale amount for reports method end-------------------	

//------------------------view customers method Start-------------------	

	public static void viewcustomers(){
		System.out.println("\n");
		System.out.println("\t __      ___                  _____          _                                ");
		System.out.println("\t \\ \\    / (_)                / ____|        | |                               ");
		System.out.println("\t  \\ \\  / / _  _____      __ | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ___ ");
		System.out.println("\t   \\ \\/ / | |/ _ \\ \\ /\\ / / | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__/ __|");
		System.out.println("\t    \\  /  | |  __/\\ V  V /  | |___| |_| \\__ \\ || (_) | | | | | |  __/ |  \\__ \\");
		System.out.println("\t     \\/   |_|\\___| \\_/\\_/    \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  |___/");
		System.out.println("\t_________________________________________________________________________________");
		System.out.println("\n");
		
		
		
		System.out.println("\n");
			
			//phone number lenth=uniqe ewa thiyen nisa	
			String[] uniqueCustomers=new String[phonenumber.length];
			int[] totalQty=new int[phonenumber.length];
			double[] totalAmount=new double[phonenumber.length];
			int uniqueCount=0;

			//get details for orders
			for (int i=0; i<phonenumber.length;i++){
				String customer=phonenumber[i];
				int quantity=qty[i];
				double itemAmount=calculateamount(size[i],qty[i]); //method to get amount

				// check the customer in array......
				int customerIndex=-1;
				for (int j=0;j<uniqueCount;j++){
					if (uniqueCustomers[j].equals(customer)){
						customerIndex=j;
						break;
					}
				}//second for

				if (customerIndex == -1) {
					// new phonenum
					uniqueCustomers[uniqueCount]=customer;
					totalQty[uniqueCount]=quantity;
					totalAmount[uniqueCount]=itemAmount;
					uniqueCount++; //unique cus ++
				} else {
					//alredy have.....add totl and qty
					totalQty[customerIndex]+=quantity;
					totalAmount[customerIndex]+=itemAmount;
				}
			}//first for
			
			//print the table
			System.out.println("\t\t+----------------+---------+---------------+");
			System.out.println("\t\t|  Customer ID   | All QTY |  Total Amount  |");
			System.out.println("\t\t+----------------+---------+---------------+");

		   for (int i = 0; i < uniqueCount; i++) {
				System.out.printf("\t\t| %12s   |    %2d   |  %10.2f   |\n", uniqueCustomers[i],totalQty[i],totalAmount[i]);
			}

			System.out.println("\t\t+----------------+---------+---------------+");
			
				System.out.println("\n");
				
				System.out.print("\tTo access the Main Menu, Please Enter 0 : ");
				int exitto=input.nextInt();
				clearConsole();
				if(exitto==0){
					homePage();
					}else{
						viewcustomers();
						}                                                                    
																							   
				
		
		}//viewcustomers eke

//------------------------view customers method end-------------------

//------------------------all customer report method end-------------------		
	public static void allcustomerreport(){
		
		System.out.println("\n");
		System.out.println("\t           _ _    _____          _                              _____                       _   ");
		System.out.println("\t     /\\   | | |  / ____|        | |                            |  __ \\                     | |  ");
		System.out.println("\t    /  \\  | | | | |    _   _ ___| |_ ___  _ __ ___   ___ _ __  | |__) |___ _ __   ___  _ __| |_ ");
		System.out.println("\t   / /\\ \\ | | | | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __|");
		System.out.println("\t  / ____ \\| | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_ ");
		System.out.println("\t /_/    \\_\\_|_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|");
		System.out.println("\t                                                                          | |                   ");
		System.out.println("\t                                                                          |_|                   ");
		System.out.println("\t_________________________________________________________________________________________________");
		System.out.println("\n");
                                                                            




		System.out.println("\n");
		
		//phone number lenth=uniqe ewa thiyen nisa
        String[] uniqueCustomers=new String[phonenumber.length];
        int[] totalQty=new int[phonenumber.length];
        double[] totalAmount=new double[phonenumber.length];
        int[][] sizeQty=new int[phonenumber.length][6];

        int uniqueCount=0;

        //get details for orders
        for (int i=0;i<phonenumber.length;i++) {
            String customer=phonenumber[i];
            int quantity=qty[i];
            double itemAmount=amount[i]; //get amount in Manin Array
            int sizeIndex=getSizeIndex(size[i]); //method in down (size is main array)

            // check the customer in array......
            int customerIndex=-1;
            for (int j=0;j<uniqueCount;j++) {
                if (uniqueCustomers[j].equals(customer)) {
                    customerIndex=j;
                    break;
                }
            }

            if(customerIndex==-1){
                // New customer
                uniqueCustomers[uniqueCount]=customer;
                sizeQty[uniqueCount][sizeIndex]=quantity;//qty & size
                totalQty[uniqueCount]=quantity;
                totalAmount[uniqueCount]=itemAmount;
                uniqueCount++;
            } else {
                // Already customer
                sizeQty[customerIndex][sizeIndex]+=quantity;
                totalQty[customerIndex]+=quantity;
                totalAmount[customerIndex]+=itemAmount;
            }
        }

        System.out.println("\t\t+----------------+----+----+----+----+----+----+---------+");
        System.out.println("\t\t| Phone Number   | XS | S  | M  | L  | XL | XXL|  Total  |");
        System.out.println("\t\t+----------------+----+----+----+----+----+----+---------+");

        for (int i = 0; i < uniqueCount; i++) {
            System.out.printf("\t\t| %12s   | %2d | %2d | %2d | %2d | %2d |  %2d | %7.2f |\n",
                              uniqueCustomers[i],
                              sizeQty[i][0], sizeQty[i][1], sizeQty[i][2], sizeQty[i][3], sizeQty[i][4], sizeQty[i][5],
                              totalAmount[i]);
        }

        System.out.println("\t\t+----------------+----+----+----+----+----+----+---------+");
      
  
		System.out.println("\n");
		
		System.out.print("\tTo access the Main Menu, Please Enter 0 : ");
		int exitto=input.nextInt();
		clearConsole();
		if(exitto==0){
			homePage();
			}else{
				allcustomerreport();
				}                      
                                               
		
		}//allcustomerreport eke	

//--------------- get t shirt index method Start------------------------------
   public static int getSizeIndex(String size) {
        switch (size) {
            case "XS": return 0;
            case "S": return 1;
            case "M": return 2;
            case "L": return 3;
            case "XL": return 4;
            case "XXL": return 5;
            default: return -1;
        }
    }	
//--------------- get t shirt index method End------------------------------    
    
		
//------------------------allcustomer report method end-------------------
//-------------------------------------------------------------------------------	
//------------------------Customer Reports Walata Adala Methods End--------------	
//-----------------------------------------------------------------------------

//-------------------------------------------------------------------------------	
//------------------------Item Reports Walata Adala Methods Start--------------	
//-----------------------------------------------------------------------------

//------------------------sorted by QTY method Start-------------------

	public static void sortedbyQTY(){
		
		System.out.println("\n");
		System.out.println("\t   _____            _           _   ____           ____ _________     __");
		System.out.println("\t  / ____|          | |         | | |  _ \\         / __ \\__   __\\ \\   / /");
		System.out.println("\t | (___   ___  _ __| |_ ___  __| | | |_) |_   _  | |  | | | |   \\ \\_/ / ");
		System.out.println("\t  \\___ \\ / _ \\| '__| __/ _ \\/ _` | |  _ <| | | | | |  | | | |    \\   /  ");
		System.out.println("\t  ____) | (_) | |  | ||  __/ (_| | | |_) | |_| | | |__| | | |     | |   ");
		System.out.println("\t |_____/ \\___/|_|   \\__\\___|\\__,_| |____/ \\__, |  \\___\\_\\ |_|     |_|   ");
		System.out.println("\t                                           __/ |                        ");
		System.out.println("\t                                          |___/                         ");
		System.out.println("\t______________________________________________________________________");
		System.out.println("\n");

		//store main datas
        String[] sizeNames={"XS","S","M","L","XL","XXL"};
        int[] totalQty=new int[6]; // XS=0, S=1, M=2, L=3, XL=4, XXL=5 method in up
		double[] totalAmount=new double[6];
		
		//calculate from main arrays
		for(int i=0;i<size.length;i++){
			int sizeIndex=getSizeIndex(size[i]);
			if (sizeIndex!=-1){
				totalQty[sizeIndex] +=qty[i];
				totalAmount[sizeIndex] +=amount[i];
			}
		}

		// Swap----sort by QTY
		for (int i=0;i<sizeNames.length-1;i++) {
			for (int j=i+1;j<sizeNames.length;j++) {
				if(totalQty[i]<totalQty[j]){
					String tempSize=sizeNames[i];
					sizeNames[i]=sizeNames[j];
					sizeNames[j]=tempSize;

					int tempQty=totalQty[i];
					totalQty[i]=totalQty[j];
					totalQty[j]=tempQty;

					double tempAmount=totalAmount[i];
					totalAmount[i]=totalAmount[j];
					totalAmount[j]=tempAmount;
				}
			}//sec for
		}//first for

		// print table
		System.out.println("\t\t+-------+-----+-------------+");
		System.out.println("\t\t|Size   | QTY | Total Amount|");
		System.out.println("\t\t+-------+-----+-------------+");

		for (int i = 0; i < sizeNames.length; i++) {
			System.out.printf("\t\t| %3s   | %3d | %10.2f  |\n", sizeNames[i], totalQty[i], totalAmount[i]);
		}

		System.out.println("\t\t+-------+-----+-------------+");

				
		System.out.println("\n");
		
		System.out.print("\tTo access the Main Menu, Please Enter 0 : ");
		int exitto=input.nextInt();
		clearConsole();
		if(exitto==0){
			homePage();
			}else{
				sortedbyQTY();
				}                
		
		
		}//sorted by QTY eke

//------------------------sorted by QTY method End-------------------

//------------------------sorted by amount method Start-------------------

	public static void sortedbyamount(){
		
		System.out.println("\n");
		System.out.println("\t   _____            _           _   ____                                               _   ");
		System.out.println("\t  / ____|          | |         | | |  _ \\            /\\                               | |  ");
		System.out.println("\t | (___   ___  _ __| |_ ___  __| | | |_) |_   _     /  \\   _ __ ___   ___  _   _ _ __ | |_ ");
		System.out.println("\t  \\___ \\ / _ \\| '__| __/ _ \\/ _` | |  _ <| | | |   / /\\ \\ | '_ ` _ \\ / _ \\| | | | '_ \\| __|");
		System.out.println("\t  ____) | (_) | |  | ||  __/ (_| | | |_) | |_| |  / ____ \\| | | | | | (_) | |_| | | | | |_ ");
		System.out.println("\t |_____/ \\___/|_|   \\__\\___|\\__,_| |____/ \\__, | /_/    \\_\\_| |_| |_|\\___/ \\__,_|_| |_|\\__|");
		System.out.println("\t                                           __/ |                                           ");
		System.out.println("\t                                          |___/                                            ");
		System.out.println("\t_________________________________________________________________________________________");
		System.out.println("\n");


		//store main datas
        String[] sizeNames={"XS","S","M","L","XL","XXL"};
        int[] totalQty=new int[6]; //XS=0,S=1,M=2,L=3,XL=4,XXL=5 method in up
		double[] totalAmount=new double[6];
		
		//calculate from main arrays
		for(int i=0;i<size.length;i++){
			int sizeIndex=getSizeIndex(size[i]);
			if (sizeIndex!=-1){
				totalQty[sizeIndex] +=qty[i];
				totalAmount[sizeIndex] +=amount[i];
			}
		}

		// Swap----sort by Amount
		for (int i=0;i<sizeNames.length-1;i++) {
			for (int j=i+1;j<sizeNames.length;j++) {
				if(totalAmount[i]<totalAmount[j]){
					String tempSize=sizeNames[i];
					sizeNames[i]=sizeNames[j];
					sizeNames[j]=tempSize;

					int tempQty=totalQty[i];
					totalQty[i]=totalQty[j];
					totalQty[j]=tempQty;

					double tempAmount=totalAmount[i];
					totalAmount[i]=totalAmount[j];
					totalAmount[j]=tempAmount;
				}
			}//sec for
		}//first for

		// print table
		System.out.println("\t\t+-------+-----+-------------+");
		System.out.println("\t\t|Size   | QTY | Total Amount|");
		System.out.println("\t\t+-------+-----+-------------+");

		for (int i = 0; i < sizeNames.length; i++) {
			System.out.printf("\t\t| %3s   | %3d | %10.2f  |\n", sizeNames[i], totalQty[i], totalAmount[i]);
		}

		System.out.println("\t\t+-------+-----+-------------+");

				
		System.out.println("\n");
		
		System.out.print("\tTo access the Main Menu, Please Enter 0 : ");
		int exitto=input.nextInt();
		clearConsole();
		if(exitto==0){
			homePage();
			}else{
				sortedbyamount();
				}                
		
		
	}//sorted by amount eke

//------------------------sorted by amount method End-------------------

//-------------------------------------------------------------------------------	
//------------------------Item Reports Walata Adala Methods End------------------	
//-------------------------------------------------------------------------------

//----------------------------------------------------------------------------------	
//------------------------Order Reports Walata Adala Methods Start------------------	
//----------------------------------------------------------------------------------

//------------------------all order method start-------------------

	public static void allorders(){
		
		System.out.println("\n");
		System.out.println("\t __      ___                  ____          _               ");
		System.out.println("\t \\ \\    / (_)                / __ \\        | |              ");
		System.out.println("\t  \\ \\  / / _  _____      __ | |  | |_ __ __| | ___ _ __ ___ ");
		System.out.println("\t   \\ \\/ / | |/ _ \\ \\ /\\ / / | |  | | '__/ _` |/ _ \\ '__/ __|");
		System.out.println("\t    \\  /  | |  __/\\ V  V /  | |__| | | | (_| |  __/ |  \\__ \\");
		System.out.println("\t     \\/   |_|\\___| \\_/\\_/    \\____/|_|  \\__,_|\\___|_|  |___/");
		System.out.println("\t______________________________________________________________");
		System.out.println("\n");
				
		int orderCount=realorderid.length;

		//make 2d array to hold the order details
		String[][] orders=new String[orderCount][6]; 

		// main array to 2d array
		for(int i=0;i<orderCount;i++){
			orders[i][0]=realorderid[i];
			orders[i][1]=phonenumber[i];
			orders[i][2]=size[i];        
			orders[i][3]=String.valueOf(qty[i]); 
			orders[i][4]=String.valueOf(amount[i]); 
			switch(orderstatus[i]){
            case 0:
                orders[i][5]="processing";
                break;
            case 1:
                orders[i][5]="delivering";
                break;
            case 2:
                orders[i][5]="delivered";
                break;
            default:
                break;
                
			}//switch eke
			
				
		}//for eke

		for (int i=0;i<orders.length-1;i++){
			for (int j=i+1;j<orders.length;j++){
				int orderId1=Integer.parseInt(orders[i][0].substring(4));//remove odr#
				int orderId2=Integer.parseInt(orders[j][0].substring(4));

			if (orderId1<orderId2){
				String[] temp=orders[i];
				orders[i]=orders[j];
				orders[j]=temp;
			}
		}//sec for
	}//first for
		
		System.out.println("\t\t+----------------+----------------+------+-----+---------+------------+");
		System.out.println("\t\t|   Order ID     |  Customer ID   | Size | QTY | Amount  |  Status    |");
		System.out.println("\t\t+----------------+----------------+------+-----+---------+------------+");

		for (int i=0;i<orders.length;i++) {
			System.out.printf("\t\t| %14s | %14s | %4s | %3s | %7.2f | %8s |\n",
					orders[i][0], orders[i][1], orders[i][2], orders[i][3],Double.parseDouble(orders[i][4]), orders[i][5]);
		}

		System.out.println("\t\t+----------------+----------------+------+-----+---------+------------+");
		
		
		System.out.println("\n");
		
		System.out.print("\tTo access the Main Menu, Please Enter 0 : ");
		int exitto=input.nextInt();
		clearConsole();
		if(exitto==0){
			homePage();
			}else{
				allorders();
				}             
                                                          
                                                 
		}//allorders eke
		
//------------------------all order method End-------------------	

//------------------------orders by amount method Start-------------------

	public static void ordersbyamount(){
		System.out.println("\n");
		System.out.println("\t   ____          _                 ____                                               _   ");
		System.out.println("\t  / __ \\        | |               |  _ \\            /\\                               | |  ");
		System.out.println("\t | |  | |_ __ __| | ___ _ __ ___  | |_) |_   _     /  \\   _ __ ___   ___  _   _ _ __ | |_ ");
		System.out.println("\t | |  | | '__/ _` |/ _ \\ '__/ __| |  _ <| | | |   / /\\ \\ | '_ ` _ \\ / _ \\| | | | '_ \\| __|");
		System.out.println("\t | |__| | | | (_| |  __/ |  \\__ \\ | |_) | |_| |  / ____ \\| | | | | | (_) | |_| | | | | |_ ");
		System.out.println("\t  \\____/|_|  \\__,_|\\___|_|  |___/ |____/ \\__, | /_/    \\_\\_| |_| |_|\\___/ \\__,_|_| |_|\\__|");
		System.out.println("\t                                          __/ |                                           ");
		System.out.println("\t                                         |___/                                            ");
		System.out.println("\t__________________________________________________________________________________________");
		System.out.println("\n");
		
		
		
		int orderCount=realorderid.length;

		//make 2d array to hold the order details
		String[][] orders=new String[orderCount][6]; 

		// main array to 2d array
		for(int i=0;i<orderCount;i++){
			orders[i][0]=realorderid[i];
			orders[i][1]=phonenumber[i];
			orders[i][2]=size[i];        
			orders[i][3]=String.valueOf(qty[i]); 
			orders[i][4]=String.valueOf(amount[i]); 
			switch(orderstatus[i]){
            case 0:
                orders[i][5]="processing";
                break;
            case 1:
                orders[i][5]="delivering";
                break;
            case 2:
                orders[i][5]="delivered";
                break;
            default:
                break;
                
			}//switch eke
			
				
		}//for eke

		// Swap ----- amount
		for (int i=0;i<orders.length-1;i++){
			for (int j=i+1;j<orders.length;j++){
				//Arra--- String
				double amount1=Double.parseDouble(orders[i][4]);
				double amount2=Double.parseDouble(orders[j][4]);

				if (amount1<amount2){ 
					String[]temp=orders[i];
					orders[i]=orders[j];
					orders[j]=temp;
				}
			}//secon for
		}//fisrt for

		System.out.println("\t\t+----------------+----------------+------+-----+---------+------------+");
		System.out.println("\t\t|   Order ID     |  Customer ID   | Size | QTY | Amount  |  Status    |");
		System.out.println("\t\t+----------------+----------------+------+-----+---------+------------+");

		for (int i = 0; i < orders.length; i++) {
			System.out.printf("\t\t| %14s | %14s | %4s | %3s | %8.2f | %8s |\n",
					orders[i][0], orders[i][1], orders[i][2], orders[i][3],Double.parseDouble(orders[i][4]), orders[i][5]);
		}

		System.out.println("\t\t+----------------+----------------+------+-----+---------+------------+");		
		System.out.println("\n");
		
		System.out.print("\tTo access the Main Menu, Please Enter 0 : ");
		int exitto=input.nextInt();
		clearConsole();
		if(exitto==0){
			homePage();
			}else{
				ordersbyamount();
				}             

		
		
		}//orders by amount eke
		
//------------------------orders by amount method End-------------------		


}//class eke
