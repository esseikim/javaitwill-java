package edu.java.modifier03;

public class Test {

	// field
	private int number;
	private String name;
	private double pressure;
	private boolean married;
	
	public Test(int number, String name, double pressure, boolean married) { //여기서 초기화 해주지 않은 값은 항상 기본값으로 채워짐. 
		this.number = number;
		this.name = name;
		this.pressure = pressure;
		this.married = married;
	}

	public Test() {
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}
	
	
	
}
