import java.util.Scanner;
import java.util.InputMismatchException;
import static java.lang.System.out;

public class BankFrontOffice{

	public static void main(String[] args) {

		Bank SBIbank = new Bank();
		Scanner scn = new Scanner(System.in);

		while (true){
			try{
			out.println("\n choose one option");
			out.println(" 1. Open Account");
			out.println(" 2. Account details");
			out.println(" 3. Deposit");
			out.println(" 4. Withdraw");
			out.println(" 5. Balence Enquiry");
			out.println(" 6. Transfer Money");
			out.println(" 7. Display all Accounts");
			out.println(" 8. Exit");

			out.print(" Enter Option:");

			int option = scn.nextInt();scn.nextLine();
			
			    if(option == 1){
					SBIbank.OpenAccount();
					break;
				}

				 if(option == 2){
					out.print(" Enter account number:");
					long accnum = scn.nextLong();scn.nextLine();
					SBIbank.displayaccount(accnum);
					break;
				}

				 if(option == 3){
					out.print(" Enter account number:");
					long accnum = scn.nextLong();scn.nextLine();
					out.print("Enter deposit amount:");
					double amt = scn.nextDouble();scn.nextLine();
					SBIbank.deposit(accnum,amt);
					break;
				}
				 if(option == 4){
					out.print(" Enter account number:");
                    long accnum = scn.nextLong();scn.nextLine();
					out.print("Enter Withdraw amount:");
					double amt = scn.nextDouble();scn.nextLine();
					SBIbank.withdraw(accnum,amt);
					break;
				}

				 if(option == 5){
					out.print(" Enter account number:");
                    long accnum = scn.nextLong();scn.nextLine();
					SBIbank.balenceEnquiry(accnum);
					break;
				}

				 if(option == 6){
					out.print(" Enter account number:");
                    long srcaccnum = scn.nextLong();scn.nextLine();
					out.print(" Enter destination account number:");
					long destaccnum = scn.nextLong();scn.nextLine();
					out.print("Enter deposite amount:");
					double amt = scn.nextDouble();scn.nextLine();
					SBIbank.transfermoney(srcaccnum,destaccnum,amt);
					break;
				}

				 if(option == 7){
					out.print(SBIbank);
					break;
				}

				 if(option == 8){
					out.println("_/\\__/\\__/\\_THANK YOU, PLEASE VISIT AGAIN_/\\__/\\__/\\_");
					break;
				 }
					if (option < 8){
					out.println("Invalid option");
					}	
			}catch(IllegalArgumentException e){
				out.println("Error: "+e.getMessage());
			}catch(InputMismatchException e){
				out.println("Enter only number:");
				scn.nextLine();

		}


	
	}
    }
	}

