package gamma;

import java.util.Scanner;

public class Gamma {
	static Gamma gm;
	static double PI = 3.141592653589793;
	double E = 2.718281828459045;
	static double res = 1.0;
	static double last = 0.0;
	public static int ITERATIONS = 20;

	

	/**
	 * This functions calculates gamma value for only negative real numbers
	 * 
	 * @param x negative real number which is not negative integer
	 * @return gamma value for negative number
	 */
	public static double negativeGammaFunc(double x) {

		double n = -1 * x;
		double negGamma = -PI / (n * gamma(n) * sine(PI * n));
		// System.out.println("negative gamma: "+negGamma);
		return negGamma;

	}

	/**
	 * This function calculated the square root of the inputted number
	 *
	 * @param n a positive real number as input
	 * @return square root value of n
	 */
	public static double sqrt(double n) {
		if (n == 0)
			return 0;

		do {

			last = res;
			res = (res + n / res) / 2;
		} while (res != last);
		return res;
	}

	/**
	 * This function calculates the sine value of positive real number
	 * 
	 * @param x double value for which mathematical sine value to be returned
	 * @return sine value of x is returned
	 */
	public static double sine(double x) {
		x = x % (2 * PI);
		double sineVal = 0.0;
		double term = 1.0;

		int i = 1;
		while (term != 0.0) {
			term *= (x / i);
			if (i % 4 == 1) {
				sineVal += term;
			}
			if (i % 4 == 3) {
				sineVal -= term;
			}
			i = i + 1;
		}
		// System.out.println("Sine: "+sum);
		return sineVal;

	}
/**
 * This function calculates Math.exp(x) for double value x
 * @param n this is used for iterations
 * @param x a double value for which exponent is returned
 * @return exponential value of x
 */
	public static double exponential(int n, double x) {
		double expVal = 1.0d; // initialize sum of series

		for (int i = n - 1; i > 0; --i)
			expVal = 1 + x * expVal / i;

		return expVal;
	}
	
	/**
	 * This method return the power value of one double and one int value.
	 * 
	 * @param a base for the power function which is a double value
	 * @param b exponent value for the power function
	 * @return gives the power value of two inputted values
	 */
	public static double power(double x, int y) {
		if (y == 0)
			return 1;
		else if (y % 2 == 0)
			return power(x, y / 2) * power(x, y / 2);
		else
			return x * power(x, y / 2) * power(x, y / 2);
	}

	/**
	 * This function calculates the natural logarithm of a double value
	 * 
	 * @param lgx a double value for which natural log should be calculated
	 * @return natural logarithm of lgx
	 */
	public static double logarithm(double lgx) {
		double num2 = lgx + 1;
		double num1 = lgx - 1;
		double mix = num1 / num2;
		double result = 0;
		int iteration = 100;
		while (iteration > 0) {
			if (iteration % 2 != 0) {
				result += power(mix, iteration) / iteration;
			}
			iteration--;

		}

		return result * 2;
	}

	/**
	 * This function calculates the logarithmic values
	 * @param x a double value for which logarithmic value help is needed
	 * @return return a variable which gives value equal to logarithmic value
	 */
	public static double logGamma(double x) {
		double tmp = (x - 0.5) * logarithm(x + 4.5) - (x + 4.5);
		double ser = 1.0 + 76.18009173 / (x + 0) - 86.50532033 / (x + 1) + 24.01409822 / (x + 2) - 1.231739516 / (x + 3)
				+ 0.00120858003 / (x + 4) - 0.00000536382 / (x + 5);
		return tmp + logarithm(ser * sqrt(2 * PI));

	}
/**
 * This is the driver function to calculate gamma value of x, by calling all other support functions from this function.
 * 
 * @param x value for which gamma value is calculated
 * @return gamma value for the input specified by the user
 */
	public static double gamma(double n) {
		if (n <= 0) {
			n = n * -1;
			if (n % 1 == 0 || n == 0) {
				return Double.POSITIVE_INFINITY;
			} else {
				return negativeGammaFunc(-n);
			}

		}
		else
		
		return exponential(10000, logGamma(n));
	}

	public static void main(String[] args) {
		gm = new Gamma();
		System.out.println("Enter x value for Gamma function: ");
		Scanner sc = new Scanner(System.in);
		double n = 0.0;
		try {
			n = Double.parseDouble(sc.nextLine());
		} catch (Exception E) {
			System.out.println("Enter a valid double value for x");
			
		}
		sc.close();

		 
			System.out.println("Gamma Value: " + gm.gamma(n));
			
		
	}

	
	

}
