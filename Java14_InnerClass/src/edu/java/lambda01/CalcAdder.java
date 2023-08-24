package edu.java.lambda01;



import edu.java.lambda01.Calculator.Calculable;

public class CalcAdder implements Calculable {

	@Override
	public double calculate(double x, double y) {  // 계산 규칙! Adder라는 애는 + 기능이 있어~ 
		return x + y;
	}
}
