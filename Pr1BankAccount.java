import static java.lang.System.out;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

class Pr1BankAccount {

	private static String bankname;
	private static String branchname;
	private static String ifsc;

     long accnum;
	private String accname;
	private double balence;

	static { // initialiazing static block

		out.println("\n BankAccount class is loaded");
		try
		{
			Thread.sleep(1000); 
		}
		catch (InterruptedException e){}
		out.println("Static Var memory is allocated with default values");
		try
		{
			Thread.sleep(1000); 
		}
		catch (InterruptedException e){}
		out.println("Reading static var value from file and initialiazing them");
		try
		{
			Thread.sleep(1000); 
		}
		catch (InterruptedException e){}

		BufferedReader fileReader = null;
		try
		{
			fileReader = new BufferedReader(new FileReader("Bankdetails.txt"));
			bankname = fileReader.readLine();
			branchname = fileReader.readLine();
			ifsc = fileReader.readLine();
		
			out.println("Static Var are intialiazed with file values\n");
			try
		{
			Thread.sleep(1000); 
		}
		catch (InterruptedException e){}
		}catch (FileNotFoundException e){
		  out.println("Error: Bank details.txt file is not found");
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			if (fileReader!=null){
				try
				{fileReader.close();}
				catch (IOException e){  }
			}
		}
		try
		{
			Thread.sleep(1000); 
		}
		catch (InterruptedException e){}
} //end of static block

	{   // initialiazing non-static block
		out.println("Non-Static var memory allocated with default values");
		try{Thread.sleep(1000); }
		catch (InterruptedException e){}
		out.println("Reading accnum value from file and initialiazing it");
		try{Thread.sleep(1000); }
		catch (InterruptedException e){}
		
		BufferedReader br = null;
		try
		{
			br = new BufferedReader(new FileReader("accnumseq.txt"));
		    this.accnum = Long.parseLong (br.readLine())+1;
			out.println(" Accnum is initialiazed iwth file value\n");
			try{Thread.sleep(1000); }
		    catch (InterruptedException e){}
		}catch(FileNotFoundException e){
			out.println(" accnumseq.txt file not found exception");
		}catch (IOException e){
			e.printStackTrace();
			
	   } finally { 
		   if (br!=null);{
		   try{ br.close();  }
		   catch (IOException e){}
		   }
	   }
	     //Saving new accnum value in file
		 FileWriter fileWriter = null;
		   try
		   {
			fileWriter = new FileWriter("accnumseq.txt");

			fileWriter.write("  " +this.accnum);
			fileWriter.flush();

		   }catch(FileNotFoundException e){
			   out.println("acccnumseq.txt file i snot found and unable to create");
		   }catch (IOException e){
		       e.printStackTrace();
		   }
		    finally {
				if (fileWriter!=null)
				{try
				{
					fileWriter.close();
				}
				catch (IOException e){}
				}
			}
	}

	 public Pr1BankAccount (String accname, double balence){

		 out.println("Other NSV are being initialiazed with given values\n");
		   try{Thread.sleep(1000); }
		    catch (InterruptedException e){}

			this.accname = accname;
			this.balence = balence;
		
		out.println("NSV are initialiazed with given object values");
		  try{Thread.sleep(1000); }
		    catch (InterruptedException e){}
	 }

	 public static String getBankname(){
		 return bankname;
	 }
	 public static String grtBranchname(){
		 return branchname;
	 }
	 public static String getIFSC(){
		 return ifsc;
	 }
	 public long getAccnum(){
		 return accnum;
	 }
	 public void setAccname(String accname){
		 this.accname = accname;
	 }
	 public String getAccname(){
		 return this.accname;
	 }
	 public double getBalence(){
		 return this.balence;
	 }

	 public void deposit(double amt){
		 this.balence = this.balence+amt;
	 }
	 public void withdraw(double amt){
		 this.balence = this.balence-amt;
	 }
	 public void currentbalence(){
		 out.println(this.balence);
	 }

	 @Override
		 public String toString(){
		 return("\n BankName\t :"     +bankname)    + "\n" +
			   ("\n BranchName\t :"   +branchname)  + "\n" +
			   ("\n IFSC\t :"         +ifsc)        + "\n" +
			   ("\n AccountNum\t :"   + accnum)     + "\n" +
			   ("\n AccName\t :"      +accname)     + "\n" +
			   ("\n Balence\t :"      + balence);
	     }
}



  
			 



		


	
