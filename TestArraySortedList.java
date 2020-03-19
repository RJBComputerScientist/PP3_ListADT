package Sorted;

import car.Car;
import Sorted.ArraySortedList;

public class TestArraySortedList {

public static void main(String[] args) {
		
		Car MainCar = new Car("Infiniti", "Q50", 2018);
		Car Mini = new Car("Mini", "S Wagon", 2020);
		Car PrizeCar = new Car("Suzuki", "Grand Luxe", 2014);
		Car ThrowBack = new Car("ASA", "1000 GT", 1967);
		Car BackUpCar = new Car("Jaguar", "Sports Sedan", 2015);
		Car OldCar = new Car("Daytona", "Triumph", 2005);
		
		ArraySortedList<Car> CarOrder = new ArraySortedList();
		
		Car car1 = BackUpCar;
		Car car2 = PrizeCar;
		
		CarOrder.add(MainCar);
		CarOrder.add(Mini);
		CarOrder.add(PrizeCar);
		CarOrder.add(ThrowBack);
		CarOrder.add(BackUpCar);
		CarOrder.add(OldCar);
		CarOrder.remove(Mini);
		CarOrder.contains(MainCar);
		CarOrder.size();
		CarOrder.isEmpty();
		CarOrder.resetIterator();
		CarOrder.resetBackIterator();
		CarOrder.find(PrizeCar);
		CarOrder.find2(OldCar);
		CarOrder.getNextItem();
		CarOrder.getPrevItem();
		/*
		if (car1.equals(car2)) {
			System.out.println(car1 + " is equal to " + car2);
		}
		else {
			System.out.println(car1 + " is not equal to " + car2);
		}
		
		if (car1.compareTo(car2) == 0) {
			System.out.println(car1 + " is equal to " + car2);
		}
		else {
			if (car1.compareTo(car2) < 0) {
				System.out.println(car1 + " was made before " + car2);
			}
			else {
				System.out.println(car1 + " made more recently than " + car2);
			}*/
			
		}

		
		
		
		

	}


