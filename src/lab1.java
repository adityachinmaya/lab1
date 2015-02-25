import java.util.Scanner;

public class lab1 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		
/** The problem assigned is to create a java program that prompts the
 *  user to input how many years the plan to work, expected interest 
 *  return on their investment, how long they want to draw this amount,
 *  their required income, and their expected SSI income. This program
 *  will return to the user the amount of money the user will have to
 *  save each month to achieve their goal.
*/
		
		final double SocialSecurity = 2642.00;
		/**we are not told otherwise so it is assumed that the maximum
		   Social security is recieved.
		*/
		
		System.out.print("Input the number of years you wish to work: ");
		int YearsWorked = (input.nextInt())*12;
		System.out.print("Input the annual return rate while you worked: ");
		double AnnualReturnWork = (input.nextDouble())/1200;
		System.out.print("Input the number of years you want to be retired: ");
		int YearsRetired = (input.nextInt())*12;
		System.out.print("Input the annual return rate while you were retired: ");
		double AnnualReturnRetire = (input.nextDouble())/1200;
		System.out.print("Input your income: ");
		double Income = input.nextDouble();
	//All inputs are taken
	//interest rates are converted to decimals and then monthly basis
	//years are converted to monthly basis
		
		double RetiredPayments = Income - SocialSecurity;
		

		
	/**  The annuity and annuity growth formulas are used.
		Annuity: PV  = Pmt*((1-(1/(1+i)^n))/i)
				 PV  = Amount of money that needs to be saved
				 Pmt = Amount of money you'll get paid on retirement
				 	   Required income - Monthly SSI
				 i   = annual return rate while working (i/12 = monthly)
				 n   = number of years worked (n*12 = number of months)
				 
Annuity Growth:  Pmt = FV*(1/((1+i)^n - 1))
		 		 Pmt = output - amount that needs to be saved monthly
		 		 FV  = PV from the annuity formula
		 		 i   = annual return rate while retired (i/12 = monthly)
		 		 n   = number of years retired (n*12 = number of months)
	*/	
		
		double TotalSavingsNeeded  = RetiredPayments*( (1-(1/(Math.pow((1+AnnualReturnRetire),YearsRetired))))/AnnualReturnRetire);
		System.out.printf("You need to save a total of $%6.2f" , TotalSavingsNeeded);
		
		double MonthlySavingsNeeded = TotalSavingsNeeded*(AnnualReturnWork/((Math.pow((1+AnnualReturnWork),YearsWorked))-1)); 
		
		System.out.printf("%nYou need to save an amount monthly of $%4.2f" , MonthlySavingsNeeded);
		input.close();
	}
}
