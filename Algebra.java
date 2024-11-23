// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(-5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(-12,3));   // 12 / 3    
   		System.out.println(div(5,-5));    // 5 / 5  
   		System.out.println(div(-25,-7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		
		if (x2 >= 0){
			for (int i = 0; i < x2; i++){
				x1 ++;
			}
		}
		else {
			for (int i = 0; i > x2; i--) {
				x1 --;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {

		if (x2 >= 0){
			for (int i = 0; i < x2; i++){
				x1 --;
			}
		}
		else {
			for (int i = 0; i > x2; i--){
				x1 ++;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int add = 0;
		if ((x1 >= 0 && x2 >= 0)){
			for (int i = 0; i < x2; i++) {
				add = plus(add,x1);
				}
		}
		if ((x1 <= 0 && x2 <= 0)){
			for (int i = 0; i > x2; i--){
				add = plus(add, x1);
			}
			add = minus(minus(add,add),add); 
		} 
		if (x1 <= 0 && x2 >= 0){
			for (int i = 0; i < x2; i ++){
				add = plus(add,x1);
			}
		}
		if (x1 >= 0 && x2 <= 0){
			for (int i = 0; i > x2; i --){
				add = minus(add,x1);
			}
		}
		return add;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int multiply = 1;
		for (int i = 0; i < n; i++){
			multiply = times(multiply, x);
		}
		return multiply;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int numerator = x1;
		int denominator = x2;
		int factor = 0;

		if (numerator < 0 && denominator < 0) {
			while (numerator <= denominator) {
				numerator -= denominator;
				factor ++;
			}
		}
		if (numerator > 0 && denominator > 0){
			while (numerator >= denominator) {
				numerator -= denominator;
				factor ++;
			}
		}
		if (numerator < 0 && denominator > 0){
			denominator -= times(2,denominator);
			while (numerator <= denominator) {
				numerator -= denominator;
				factor ++;
			}
			factor -= times(2,factor);
		}
		if (numerator > 0 && denominator < 0){
			denominator -= times(2,denominator);
			System.out.println(denominator);
			while (numerator >= denominator) {
				numerator -= denominator;
				factor ++;
			}
			factor -= times(2,factor);
		}
		return factor;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int factor = div(x1,x2);
		int multiplier = times(factor,x2);
		int remainder = minus(x1,multiplier);
		return remainder;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int g = 0;
		int count = 0;

		while(times(g,g) < x) {
			g ++;
			count ++;
		}
		return count;
	}	  	  
}