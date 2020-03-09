package apps;

import adts.*;

public class PrimeChecker {
	
	private static void primeCheck(int n, ArraySortedList<Integer> p) {
		if (p.contains(n)) {
			System.out.println(">>> " + n + " is on the list of primes\n");
		}
		else {
			System.out.println("--- " + n + " is not on the list of primes\n");
		}
	}

	public static void main(String[] args) {
		
        ArraySortedList<Integer> primes = new ArraySortedList<Integer>();

        primes.add(2);   primes.add(3);   primes.add(5);   primes.add(7);
        primes.add(41);  primes.add(43);  primes.add(47);
        primes.add(11);  primes.add(13);  primes.add(17);  primes.add(19);
        primes.add(107); primes.add(109); primes.add(113);
        primes.add(23);  primes.add(29);  primes.add(31);  primes.add(37);
        primes.add(89);  primes.add(97);  primes.add(101); primes.add(103);
        primes.add(71);  primes.add(73);  primes.add(79);  primes.add(83);
        primes.add(53);  primes.add(59);  primes.add(61);  primes.add(67);
        
        System.out.println("Number of primes on this list: " + primes.size());
        System.out.println(primes);
        
        primeCheck( 19, primes);
        primeCheck( 24, primes);
        primeCheck( 55, primes);
        primeCheck( 47, primes);
        primeCheck( 79, primes);
        primeCheck(113, primes);
        primeCheck( 17, primes);
        primeCheck(  2, primes);
        
	}
      
}
