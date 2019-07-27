package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import gamma.Gamma;

public class GammaTest {
	Gamma gm = new Gamma();
	
	@Before
	public void set() {
		double PI= 3.141592653589793;
		double E = 2.718281828459045;
	}
	
	@Test
	public void squareRoot() {

		double sqrtVal= gm.sqrt(4.0);
		assertEquals(2.0, sqrtVal,0);

	}
	
	
	  @Test 
	  public void power() {
	  
	  double powerVal= gm.power(2.0,3.0);
	  assertEquals(8.927749633789062, powerVal,0);
	  
	  }
	  @Test
	  public void sine() {
		
		  double sinVal= gm.sine(1.2);
		  assertEquals(0.9320390859672263, sinVal,0);
	  }
	 
	
	@Test
	public void gammaValue() {

		double gammaValue= gm.gammaVal(75);
		assertEquals(2.7589146994992928E107, gammaValue,0);

	}
	@Test
	public void negativeGammaVal() {
		double negGammaVal = gm.negativeGammaFunc(-25.1);
		assertEquals(4.2696165602701385E-25, negGammaVal,0);
	}
}
