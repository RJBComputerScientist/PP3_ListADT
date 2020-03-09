package apps;

import car.Car;

public class CarTestProgram {

	public static void main(String[] args) {
		
		Car myCar = new Car("Mazda", "3", 2018);
		
		System.out.println(myCar);
		
		myCar.beep();
		
		Car teslaModelS = new Car("Tesla", "Model S", 2020);
		System.out.println(teslaModelS);
		teslaModelS.setAllElectric(true);
		System.out.println(teslaModelS);

	}

}
