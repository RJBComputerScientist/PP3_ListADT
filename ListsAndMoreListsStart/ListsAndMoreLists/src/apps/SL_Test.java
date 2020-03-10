package apps;
import adts.SortedList;

public class SL_Test {

	public static void main(String[] args) {
		
        SortedList<Integer> primes = new SortedList<Integer>();

        System.out.println("aaaaaaaaaaaaaaaa");
        primes.find();
        
        
        primes.add(2); 
        primes.add(5);   //it's stopping here for some reason, the second thing added to the list breaks it
        primes.add(1);   
        primes.add(7);
        primes.add(41);  
        primes.add(43);  
        primes.add(47);
        primes.add(11);  
        primes.add(13);  
        primes.add(17);  
        primes.add(19);
        primes.add(107);
        primes.add(109); 
        primes.add(113);
        primes.add(23);  
        primes.add(29);  
        primes.add(31);  
        primes.add(37);
        primes.add(89);  
        primes.add(97);  
        primes.add(101); 
        primes.add(103);
        primes.add(71);  
        
        System.out.println(primes.size());
  
        System.out.println(primes); 
        
        
        
        System.exit(0);
        
        
        
        
        
	}
}
