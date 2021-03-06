import java.util.Scanner;  // Import the Scanner class


// This class represent the Rational Number class
// with all its methods as required in the Exercise
public class Rational {

	private int _pNumerator;
	private int _qDenominator;

	// constructor with validations
	public Rational(int pNumerator, int qDenominator) {
		
		// Assign the parameters - if not valid - throw exception
		try {
			
			_pNumerator = pNumerator;
			_qDenominator = qDenominator;
			
		} catch (IllegalArgumentException error) {}
	}
	
	// Get the Numerator of this Rational number
	public int getNumerator() {
		return _pNumerator;
	}
	
	// Get the Denominator of this Rational number
	public int getDenominator() {
		return _qDenominator;
	}
	
	// Print the Rational Number
	public String toString() {
		
		return _pNumerator +"/"+_qDenominator;
	}
	
	// Check if this rationalNumber is bigger than the param RationalNumber - using 2 private methods
	public boolean greaterThan(Rational rationalToCompare) {
		
		boolean result = false;
		
		int leftSide, rightSide;
		
		// Calculate the left side and right side of the equation 
		leftSide = calcLeftSide(this, rationalToCompare);
		rightSide =  calcRightSide(this, rationalToCompare);
		
		// Check the 2 sides - if left is bigger than right
		result = leftSide > rightSide ? true : false;
		
		return result;
		
	}
	
	// checks if the 2 rational numbers are equal in value - using 2 private methods
	public boolean equals(Object obj) {
		
		boolean result = false;
		
		int leftSide, rightSide;
		
		if (obj == null || !(obj instanceof Rational))
			return false;
		
		// Calculate the left side and right side of the equation 
		leftSide = calcLeftSide(this, (Rational)obj);
		rightSide =  calcRightSide(this, (Rational)obj);
		
		// Check the 2 sides - if left is bigger than right
		result = leftSide == rightSide ? true : false;
		
		return result;
	}
	
	//Calculate the Addition of the 2 Rational numbers
	public Rational plus(Rational rationalToAdd) {
		
		return calcPlusOrMinus('+', this, rationalToAdd);
	}
	
	// Calculate the substraction of the 2 Rational Numbers
	public Rational minus(Rational rationalToSubstract) {
		
		return calcPlusOrMinus('-', this, rationalToSubstract);
	}

	// Calculate the multiplication of 2 Rational Numbers
	public Rational multiply(Rational rationalToMult) {
	
		Rational result;
		int newNumerator, newDenominator;
		
		newNumerator = _pNumerator * rationalToMult._pNumerator;
		newDenominator = _qDenominator * rationalToMult._qDenominator;
		
		result = new Rational(newNumerator, newDenominator);
		
		return result;
	}

	//Open
	// Calculate the devision of 2 Rational Numbers
	public Rational divide(Rational rationalToDiv) {
		
		Rational result;
		int newNumerator, newDenominator;
		
		newNumerator = calcLeftSide(this, rationalToDiv);
		newDenominator = calcRightSide(this, rationalToDiv);
			
		result = new Rational(newNumerator, newDenominator);
		
		return result;
	}
	
	// Calculate the gcd of the rational and return the new Rational Number after reducing
	public Rational reduce() {
		
		int gcdResult = 0, newNumerator, newDenominator;
		Rational rationalToReturn = null;
		
		if (_pNumerator > _qDenominator)
			gcdResult = gcdEuclids(_pNumerator, _qDenominator);
		else
			gcdResult = gcdEuclids(_qDenominator, _pNumerator);

		
		newNumerator = _pNumerator / gcdResult;
		newDenominator = _qDenominator / gcdResult;
		
		
		rationalToReturn = new Rational(newNumerator, newDenominator);

		return rationalToReturn;
	}
	
	// Calcaulte the left side - when comparing 2 rational numbers
	private int calcLeftSide(Rational rat1, Rational rat2) {
		
		return rat1._pNumerator * rat2._qDenominator; 
	}
	
	// Calcaulte the right side - when comparing 2 rational numbers
	private int calcRightSide(Rational rat1, Rational rat2) {
		
		return rat2._pNumerator * rat1._qDenominator; 
	}
	
	// Calculate the common ground of the 2 rational numbers
	private int calcCommonGround(Rational rat1, Rational rat2) {
		
		return rat1._qDenominator * rat2._qDenominator;
	}
	
	// Private method that will get the char of Minus or plus and 2 rationalNumbers 
	// the method returns the final rational number after calculation and creation
	private Rational calcPlusOrMinus(char signalToCalculate, Rational rat1, Rational rat2) {
		
		int leftSide, rightSide, commonGroundDenominator, finalNumerator ;
		Rational result;
		
		finalNumerator = 0;
		leftSide = calcLeftSide(rat1, rat2);
		rightSide = calcRightSide(rat1, rat2);
		commonGroundDenominator = calcCommonGround(rat1, rat2);
		
		// depends on the signalToCalculate Value
		switch (signalToCalculate) {
		case '+':
			finalNumerator = leftSide + rightSide;
			break;
		case '-':
			finalNumerator = leftSide - rightSide;
			break;
		default:
			break;
		}	
		
		// Create the new RationalNumber
		result = new Rational(finalNumerator,commonGroundDenominator );
		
		return result;
	}
	
	
	// Private method to find the biggest common dividor by the Euclids algorithm
	private int gcdEuclids(int n1, int n2) {
		
		if(n2 == 0) {
			return n1;
		}
		return gcdEuclids(n2, n1 % n2);
	}

	
}
