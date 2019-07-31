package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import gamma.Gamma;

public class GammaTest {
	Gamma gm = new Gamma();
	/**
	 * This method is used to store constants which can be used for computation
	 */
	@Before
	public void set() {
		double PI= 3.141592653589793;
		double E = 2.718281828459045;
	}
	/**
	 * This method tests the square root values from the implemented function with Math.sqrt
	 */
	@Test
	public void squareRoot() {

		double sqrtVal= gm.sqrt(4.0);
		assertEquals(Math.sqrt(4.0), sqrtVal,0);

	}
	
	/**
	 * This method tests power functionality which is compared with Math.pow(x,y)
	 */
	  @Test 
	  public void power() {
	  
	  double powerVal= gm.power(2,3);
	  assertEquals(Math.pow(2, 3), powerVal,0);
	  
	  }
	  /**
	   * This method tests the sine implemented function with Math.sin(x)
	   */
	  @Test
	  public void sine() {
		
		  double sinVal1= gm.sine(1.2);
		  double sinVal2= gm.sine(2.2);
		  assertEquals(Math.sin(1.2), sinVal1,0);
		  assertEquals(Math.sin(2.2), sinVal2,0);
	  }
	  /**
	   * This method tests the natural logarithm value returned from function to Math.log()
	   */
	  @Test
	  public void logarithm() {
		  double log = gm.logarithm(2.2);
		  
		  assertEquals(Math.log(2.2), log,0);
		  
	  }
	 /**
	  * This method tests the exponential function value with Mth.exp(x)
	  */
	  @Test
	  public void exponential() {
		  double exp = gm.exponential(1000, 10);
		  assertEquals(Math.exp(10), exp,0);
	  }
	/**
	 * This method is used to test the gamma value returned from the developed function
	 *  for positive real number (x)
	 */
	@Test
	public void gammaValue() {
		
		  double gammaValue1= gm.gamma(1);
		  assertEquals(0.9465968605432701, gammaValue1,0);  //Requirement-1 Test case
		 double gammaValue2 = gm.gamma(0.5); //Input is 1/2
		 assertEquals(1.2692772074995358, gammaValue2,0); //Requirement-2 Test case
		  double gammaValue3= Gamma.gamma(30.0); 
		  assertEquals(8.724266626229632E30,gammaValue3,0); //Requirement-4 Test case
		 
		 

	}
	
	/**
	 * This method is used to test the gamma value returned from the developed function for
	 *  negative real numbers except negative integers
	 */
	@Test
	public void negativeGammaVal() {
		double negGammaVal1 = gm.negativeGammaFunc(-25.1);
		double negGammaVal2 = gm.gamma(-25);
	
		assertEquals(4.757708074569399E-25, negGammaVal1,0); //Requirement-5 Test case
		assertEquals(Double.POSITIVE_INFINITY, negGammaVal2,0); //Requirement-3 Test case
	}
}
