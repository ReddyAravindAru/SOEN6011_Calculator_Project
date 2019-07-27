package gamma;

import java.util.Scanner;

public class Gamma {
	double PI= 3.141592653589793;
	double E = 2.718281828459045;
	double res = 1.0;
    double last = 0.0;
    
    public double power( double a,  double b) {
         int x = (int) (Double.doubleToLongBits(a) >> 32);
         int y = (int) (b * (x - 1072632447) + 1072632447);
         return Double.longBitsToDouble(((long) y) << 32);
    }
	public double gammaVal(double x){
		
		if(x<0) {
			return negativeGammaFunc(x);
		}
		else {
			
		return sqrt(2*PI/x)*power((x/E), x);
		}
	}
 
	public double negativeGammaFunc(double x) {
		
		double n=-1*x;
		double negGamma= -PI/(n*gammaVal(n)*sine(PI*n));
		//System.out.println("negative gamma: "+negGamma);
		return negGamma;
		
		
	}

	public double sqrt(double n) {
	    if (n == 0) return 0;

	    do {
	    
	        last = res;
	        res = (res + n/ res) / 2;
	    }while (res != last) ;
	    return res;
	}
	

	public double sine(double x) {
        x = x % (2 * PI);

        double term = 1.0;      
        double sum  = 0.0;      // sum of first i terms in taylor series
int i=1;
        while(term != 0.0) {
        	term *= (x / i);
            if (i % 4 == 1) {
            	sum += term;
            }
            if (i % 4 == 3) {
            	sum -= term;
            }
        	i=i+1;
        }
       // System.out.println("Sine: "+sum);
		return sum;
        
		/*
		 * for (int i = 1; term != 0.0; i++) { term *= (x / i); if (i % 4 == 1) sum +=
		 * term; if (i % 4 == 3) sum -= term; } System.out.println("Sine: "+sum); return
		 * sum;
		 */
	}
 
	public static void main(String[] args) {
		Gamma gm = new Gamma();
		System.out.println("Enter x value for Gamma function: ");
		Scanner sc = new Scanner(System.in);
		
		double n=Double.parseDouble(sc.nextLine());
		if(n<0) {
			n=n*-1;
			if(n%1==0) {
			System.out.println(Double.POSITIVE_INFINITY);
			}
			else {
				System.out.println("Gamma Value with Stirling's approximation: "+gm.gammaVal(-n));
			}
				
		}
		else {
			
		
		System.out.println("Gamma Value with Stirling's approximation: "+gm.gammaVal(n));
		//System.out.println("Sqrt: "+gm.sqrt(4));
		//System.out.println("Power: "+gm.power(2, 3));
		//System.out.println("POsitive gamma: "+gm.gammaVal(-130.9));
		//System.out.println("Gamma: "+gm.gammaVal(n));
		//System.out.println("Sine: "+gm.sine(1.2));
		}
	}
}