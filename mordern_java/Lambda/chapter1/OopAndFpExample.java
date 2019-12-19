package mordern_java.Lambda.chapter1;

public class OopAndFpExample {
	public static void main(String[] args) {
		// OOP 방식!!!
		final CalculatorService calculatorService = new CalculatorService();

		calculatorService.setCalculation(new Addition());
		final int additionResult = calculatorService.calculate(5, 5);
		System.out.println("addition: " +additionResult);

		calculatorService.setCalculation(new Subtraction());
		final int subtractionResult = calculatorService.calculate(5, 5);
		System.out.println("subtraction: " +subtractionResult);
		
		calculatorService.setCalculation(new Multiplication());
		final int multiplicationResult = calculatorService.calculate(5, 5);
		System.out.println("multiplication: " +multiplicationResult);
		
		calculatorService.setCalculation(new Division());
		final int divisionResult = calculatorService.calculate(5, 5);
		System.out.println("division: " +divisionResult);
		
		
		// FP 방식!!!!
		final FpCalculatorService fpCalculatorService = new FpCalculatorService();
//		System.out.println("addition: " + fpCalculatorService.calculate(new Addition(), 4, 2));
//		System.out.println("subtraction: " + fpCalculatorService.calculate(new Subtraction(), 4, 2));
//		System.out.println("multiplication: " + fpCalculatorService.calculate(new Multiplication(), 4, 2));
//		System.out.println("division: " + fpCalculatorService.calculate(new Division(), 4, 2));
		System.out.println("addition: " + fpCalculatorService.calculate((num1, num2 )-> num1+num2, 4, 2));
		System.out.println("subtraction: " + fpCalculatorService.calculate((num1, num2 )-> num1-num2, 4, 2));
		System.out.println("multiplication: " + fpCalculatorService.calculate((num1, num2 )-> num1*num2, 4, 2));
		System.out.println("division: " + fpCalculatorService.calculate((num1, num2 )-> num1/num2, 4, 2));
	}
}

interface Calculation {
	int calculate(int num1, int num2);
}

class Addition implements Calculation {

	@Override
	public int calculate(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 + num2;
	}

}

class Subtraction implements Calculation {

	@Override
	public int calculate(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 - num2;
	}

}

class Multiplication implements Calculation {

	@Override
	public int calculate(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 * num2;
	}

}

class Division implements Calculation {

	@Override
	public int calculate(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 / num2;
	}

}

class CalculatorService {
	private Calculation calculation; // composition 조립을 이용하여 dependency
	private Calculation calculation2; // injection으로 구현하였음.
	private Calculation calculation3;
	
	public CalculatorService() {
	}

	public CalculatorService(final Calculation calculation) {
		this.calculation = calculation;
	}
	
	public void setCalculation(Calculation calculation) {
		this.calculation = calculation;
	}
	
	public void setCalculation2(Calculation calculation) {
		this.calculation2 = calculation;
	}
	
	public void setCalculation3(Calculation calculation) {
		this.calculation3 = calculation;
	}

	public int calculate(int num1, int num2) {
		return calculation.calculate(num1, num2);
	}
	
	public int compute1(int num1, int num2) {
		if(num1 > 10 && num2 < num1) {
			return calculation2.calculate(num1, num2);
		}else {
			throw new IllegalArgumentException("Invalid input num1: " + num1 + " num2: " + num2);
		}
	}
	
	public int compute2(int num1, int num2) {
		if(num1 < 00 && num2 < num1) {
			return calculation3.calculate(num1, num2);
		}else {
			throw new IllegalArgumentException("Invalid input num1: " + num1 + " num2: " + num2);
		}
	}
}

class FpCalculatorService {
	public int calculate(Calculation calculation, int num1, int num2) {
		if(num2 > 0 && num2 < num1) {
			return calculation.calculate(num1, num2);
		}else {
			throw new IllegalArgumentException("Invalid input num1: " + num1 + ", num2: " + num2);
		}
	}
}
