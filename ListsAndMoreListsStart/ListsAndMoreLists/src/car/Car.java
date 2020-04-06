package car;

public class Car implements Comparable<Car> {
	
	private String make;
	private String model;
	private int year;
	private boolean allElectric;
	
	public Car() {
		
	}
	
	public Car(String make, String model, int year) {
		this.make = make;
		this.model = model;
		this.year = year;
	}

	public Car(String make, String model, int year, boolean allElectric) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.allElectric = allElectric;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isAllElectric() {
		return allElectric;
	}

	public void setAllElectric(boolean allElectric) {
		this.allElectric = allElectric;
	}
	
	
	public void beep() {
		/*
		for (int i=0; i < 10; i++) {
			System.out.print("\007");
		}
		*/
		System.out.println("\nBEEP!\n");
	}
	
	@Override
	public int compareTo(Car other) {
		
		return this.year - other.year;
				
		/*
		if (this.year == other.year) {
			return 0;
		}
		else {
			if (this.year > other.year) {
				return 1;
			}
			else {
				return -1;
			}
		}
		*/
	}
	
	@Override
	public boolean equals(Object other) {
		boolean result = false;
		if (other instanceof Car) {
			Car otherCar = (Car) other;
			if (this.year == otherCar.year) {
				result = true;
			}
			else {
				result = false;
			}
		}
		return result;
	}
	
	
	
	
	
	
	
	
	public String toString() {
		String carStr = make + " " + model + "  year: " + year;
		if (allElectric) {
			carStr = carStr + "  an all-eletric vehicle";
		}
		return carStr;
	}

}
