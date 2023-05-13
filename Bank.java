import java.util.Scanner;
import static java.lang.System.out;

class Bank{ 

	private Pr1BankAccount[] accounts;
	private int size;
	private Scanner scanner;
	
	public Bank(){
		accounts = new Pr1BankAccount [10];
		size     =  0;
		scanner  = new Scanner(System.in);
  }
     private void pause(){
		 try{Thread.sleep(1000);}
		 catch(InterruptedException e){}
	 }
	 public void OpenAccount(){ //OpenAccount method is started
		 out.print("Enter Account HolderName:");
		 String accname = scanner.nextLine();

		 out.print("Enter Balence:");
		 double balence = scanner.nextDouble();
		 scanner.nextLine();
		  
		 out.println("BankAccount object creation started");
		 pause();

		 Pr1BankAccount account = new Pr1BankAccount(accname, balence);
		  out.println("BankAccount object is created");
		  pause();

		  accounts[size++] = account;
		  out.println("BankAccount object is stored in bank");
		  pause();
		  
	 }// OpenAccount method close

	 private Pr1BankAccount getAccount(long accnum)throws IllegalArgumentException{
		 
		 if(accnum<=0)throw new IllegalArgumentException("Account number can not be a negative number or zero");
		 out.println("Searching for given Account number object");
		 pause();

		 for(int i=0; i<size; i++){
			 Pr1BankAccount account = accounts[i];
			 if(account.getAccnum() == accnum)
				 return account;
		 }
		 return null;
	 }
	 public void deposit(long accnum, double amt) throws IllegalArgumentException{
		 out.println("Deposit operation starts");
		 pause();
		 if(amt<+0)
			 throw new IllegalArgumentException(" Amount cannot be negative or zero");
             
			 Pr1BankAccount account = getAccount(accnum);
			 if(account == null) throw new IllegalArgumentException (" Account is not found with given details");
			 account.deposit(amt);
			 out.println("Cash RS"+amt+" is credited into your account");
			 pause();
	 }
	 public void withdraw(long accnum, double amt)throws IllegalArgumentException{
		 out.println("Withdraw operation starts");
		 pause();
		 Pr1BankAccount account = getAccount(accnum);
		 if(account == null) throw new IllegalArgumentException("Account is not found with given details");
		 if(amt<=0) throw new IllegalArgumentException(" Amount not be in negative number or zero");
		 if(amt>account.getBalence()) throw new IllegalArgumentException("Insufficient Balence");
		 account.withdraw(amt);
		 out.println("Cash RS"+amt+" is debited from your account");
		 pause();
	 }

	 public void balenceEnquiry(long accnum) throws IllegalArgumentException{
		 out.println(" Balence Enquiry operations starts");
		 pause();
		 Pr1BankAccount account = getAccount(accnum);
		 if(account == null)throw new IllegalArgumentException(" Account is not found with given details");
		 out.print("Current balence:");
		 account.currentbalence();
		 pause();
	 }

	  public void transfermoney(long sourceaccnum, long destinationaccnum, double amt)throws IllegalArgumentException{
		  out.println("Transfer money operation starts");
		  pause();
		  withdraw(sourceaccnum, amt);
		  deposit(destinationaccnum, amt);
		  out.println("Transfer money operation end");
	  }

	  public void displayaccount(long accnum)throws IllegalArgumentException{
		  out.println("Display bank account operation starts");
		  pause();
		  Pr1BankAccount account = getAccount(accnum);
		  if(account == null)throw new IllegalArgumentException("Account is not found with given details");
		  out.println("Account details");
		  out.println(account);
	  }

	  @Override
		  public String toString(){
		  if(size == 0)
			  return "No accounts found";
		  StringBuilder accountsBuilder = new StringBuilder();
		  for(int i = 0; i<size; i++){
			  accountsBuilder.append(" account"+(i+i)+"details:");
			  accountsBuilder.append(accounts[i]+"\n");
		  }
		  return accountsBuilder.toString();
	  }
}

		  
	



          







