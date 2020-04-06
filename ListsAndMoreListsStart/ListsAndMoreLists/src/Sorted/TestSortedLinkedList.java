package Sorted;

import car.Car;
import Sorted.SortedLinkedList;
import java.lang.*;

public class TestSortedLinkedList {

public static void main(String[] args) {
		
		Car MainCar = new Car("Infiniti", "Q50", 2018);
		Car Mini = new Car("Mini", "S Wagon", 2020);
		Car PrizeCar = new Car("Suzuki", "Grand Luxe", 2014);
		Car ThrowBack = new Car("ASA", "1000 GT", 1967);
		Car BackUpCar = new Car("Jaguar", "Sports Sedan", 2015);
		Car OldCar = new Car("Daytona", "Triumph", 2005);
		Car Bootleg = new Car("BMW", "320", 1938);
		
		SortedLinkedList<Car> CarOrder = new SortedLinkedList();
		
		//Car Sets Out Of Order
		Car car1 = BackUpCar;
		Car car2 = PrizeCar;
		Car car3 = OldCar;
		Car car4 = ThrowBack;
		Car car5 = MainCar;
		Car car6 = Mini;
		Car car7 = Bootleg;
		
		//equals & compareTo Test
		if (car3.equals(car2)) {
			System.out.println(car3 + " is equal to " + car2);
		}
		else {
			System.out.println(car3 + " is not equal to " + car2);
		}
		
		if (car3.compareTo(car2) == 0) {
			System.out.println(car3 + " is equal to " + car2);
		}
		else {
			if (car3.compareTo(car2) < 0) {
				System.out.println(car3 + " was made before " + car2);
			}
			else {
				System.out.println(car3 + " made more recently than " + car2);
			}
		}
	/*===============================================================================================
	  ===============================================================================================	
	  							"SortedLinkedList" Method Testing
	  
	  ===============================================================================================
	  ===============================================================================================
	 */
		
			
		//Individual find & find2 test 100% DONE 
		/*CarOrder.add(car1);
		System.out.println("-----------");
		CarOrder.find(car1);
		System.out.println(System.nanoTime());
		CarOrder.add(car2);
		System.out.println("-----------");
		CarOrder.find2(car2);
		System.out.println(System.nanoTime());*/
		
		/*----------------------------------------------------------------*/
		
		//Individual add test 100% DONE
		/*CarOrder.add(car4);
		CarOrder.add(car3);
		CarOrder.add(car1);
		CarOrder.add(car4);
		CarOrder.add(car4);*/
		
		/*----------------------------------------------------------------*/
		
		//Individual remove & middle add test 100% DONE
		/*CarOrder.add(car6);
		CarOrder.add(car3);
		CarOrder.add(car1);
		CarOrder.add(car2);
		CarOrder.add(car4);
		System.out.println(CarOrder);
		CarOrder.add(car4);
		CarOrder.remove(car3);
		System.out.println(CarOrder.contains(car3) ? "Its in there" : "its not there" 
				+ CarOrder.toString());*/
		
		/*----------------------------------------------------------------*/

		//Individual size & contains test 100% DONE
		/*CarOrder.size();
		CarOrder.add(car1);
		CarOrder.size();
		CarOrder.add(car7);
		System.out.println(CarOrder);
		System.out.println(CarOrder.contains(car1) ? "Its in there" : "Or not" 
				+ CarOrder.toString());*/
		
		/*----------------------------------------------------------------*/
		
		//Individual isEmpty test 100% DONE
		/*System.out.println(CarOrder.isEmpty() ? "My lot is empty?": "Tell me my size" 
				+ CarOrder.toString());
		CarOrder.add(car3);
		CarOrder.add(car1);
		System.out.println(CarOrder.isEmpty() ? "My lot is empty?": "Tell me my size" + "\n" 
				+ CarOrder.toString());*/
		
		/*----------------------------------------------------------------*/
		
		//Individual get, resetIterator & getNextitem test 100% DONE
		/*CarOrder.resetIterator();
		CarOrder.add(car1);
		CarOrder.get(car1);
		System.out.println(CarOrder.contains(car2) ? "Its in there" : "It aint here " 
				+ CarOrder.toString());*/
		/*CarOrder.add(car5);
		CarOrder.getNextItem();
		CarOrder.resetIterator();
		System.out.println(CarOrder);*/
		
		/*----------------------------------------------------------------*/
		
		//Individual BackresetIterator & getPrevitem test  100% DONE
				/*CarOrder.resetBackIterator();
				CarOrder.add(car3);
				CarOrder.add(car2);
				CarOrder.getPrevItem();
				CarOrder.resetBackIterator();*/
		}

	}


