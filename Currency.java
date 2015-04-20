/*Conversion rates:
 * 1 USD = .68 Pounds, 120.07 yen
 * 1 Pound = 1.49 USD, 177.88 yen
 * 1 Yen = .0084 USD, .0056 Pounds
 */


import java.text.DecimalFormat;
public class Currency {
	DecimalFormat df = new DecimalFormat("#.00");
	
	private double amount;
	private char unit;	
	
	private final static char DOLLAR = 36;
	private final static  char POUND = 163;
	private final static char YEN = 165;
	
	public Currency() {
		this.set(5.0, DOLLAR);
	}
	
	public Currency(double value) {
		this(value, (char)36);
	}
	public Currency(char unit) {
		this(0.0, (char)unit);
	}
	
	public Currency(double value, char unit) {
		this.setAmount(value);
		this.setUnit((char)unit);
	}
	
	public Currency(Currency amount) {
		this.amount = amount.amount;
	}
	
	public void setUnit(char unit) {
		this.unit = unit;
	}
	
	public void setAmount(double value) {
		this.amount = value;
	}

	public void set(double value, char unit) {
		this.setAmount(value);
		this.setUnit(unit);
	}
	
	public double getDollars() {
		if(unit == DOLLAR) return amount;
		 else if(unit == POUND) return amount*1.49;
		 else if(unit == YEN) return amount*.0084;
		 else System.out.println("Invalid unit to convert to dollars");
		return getDollars();
	}
	
	public double getPounds() {
		if(unit == POUND) return amount;
		else if(unit == DOLLAR) return amount*.68;
		else if(unit  == YEN) return amount*.0056;
		else System.out.println("Invalid unit to convert");
		return getPounds();
	}
	
	public double getYen() {
		if(unit == YEN) return amount;
		else if(unit == DOLLAR) return amount*120.07;
		else if(unit  == POUND) return amount*177.88;
		else System.out.println("Invalid unit to convert");
		return getYen();
	}
	
	public boolean equals(Currency otherAmount) {
		double tempAmount1 = this.amount;
		double tempAmount2 = otherAmount.amount;
		
		if(otherAmount.unit == DOLLAR) {
			tempAmount1 = getDollars();
				return tempAmount1 == tempAmount2;
		}
		else if(otherAmount.unit == POUND){
			tempAmount1 = getPounds();
			return tempAmount1 == tempAmount2;
		}
		else if(otherAmount.unit == YEN) {
			tempAmount1 = getYen();
			return tempAmount1 == tempAmount2;
		}
		return this.equals(otherAmount);
	}
	
	public boolean lessThan(Currency otherAmount) {
		double temp1 = this.amount;
		double temp2 = otherAmount.amount;
		
			if(otherAmount.unit == DOLLAR) {
				temp1 = getDollars();
				return temp1 < temp2;
			}
			else if(otherAmount.unit == POUND) {
				temp1 = getPounds();
				return temp1 < temp2;
			} else if(otherAmount.unit == YEN) {
				temp1 = getYen();
				return temp1 < temp2;
			}
		return this.lessThan(otherAmount);
	}
	
	public boolean greaterThan(Currency otherAmount) {
		double temp1 = this.amount;
		double temp2 = otherAmount.amount;
		
			if(otherAmount.unit == DOLLAR) {
				temp1 = getDollars();
				return temp1 > temp2;
			}
			else if(otherAmount.unit == POUND) {
				temp1 = getPounds();
				return temp1 > temp2;
			} else if(otherAmount.unit == YEN) {
				temp1 = getYen();
				return temp1 > temp2;
			}
		return this.greaterThan(otherAmount);
	}
	
	public void deposit(Currency amount) {
		boolean sameUnit = this.unit == amount.unit;
		double tempAmount1 = this.amount;
		double tempAmount2 = amount.amount;
		
			if(amount.unit == DOLLAR) {
				tempAmount1 = getDollars();
				tempAmount1 += tempAmount2;
				return;
			}else if(amount.unit == POUND) {
				tempAmount1 = getPounds();
				tempAmount1 += tempAmount2;
				return;
			}else if(amount.unit == YEN) {
				tempAmount1 = getYen();
				tempAmount1 += tempAmount2;
				return;
			} else {
				tempAmount1 += tempAmount2;
				return;
			}
	}
	
	public void withdraw(Currency amount) {
		
	}
	
	public void printInDollars() {
		System.out.println(DOLLAR + "" + df.format(getDollars()));
	}
	
	public void printInPounds() {
		System.out.println(POUND + "" + df.format(getPounds()));
	}
	
	public void printInYen() {
		System.out.println(YEN + "" + df.format(getYen()));
	}
	
}