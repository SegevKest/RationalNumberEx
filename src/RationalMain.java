import java.util.Scanner;

public class RationalMain {

	
	public static Rational getRationalFromUser() {
		
		Scanner scan = new Scanner(System.in);
		Rational newRatio = null;
		
		int newNumerator, newDenominator;
		
		System.out.println("Please insert the new Numerator of the Rational Number: ");
		newNumerator = scan.nextInt();
		
		System.out.println("\nPlease insert the new Denominator of the Rational Number: ");
		newDenominator = scan.nextInt();
		
		newRatio = new Rational(newNumerator, newDenominator);
		
		System.out.println("\nThe new Rational number is :"+ newRatio);
		
		return newRatio;
		
		
	}
	
	
	public static void main(String args[]) {
		
		Rational r1 = getRationalFromUser();
		Rational r2 = getRationalFromUser();
		
		// Start executing all methods of Rational
		
		
		System.out.println("\nCheck Greater than");
		
		
		System.out.println("\nCheck Equals");
		
		System.out.println("\nCheck Equals");
		
		System.out.println("\nCheck Equals");
		
		System.out.println("\nCheck Equals");
		
	}
	
}
