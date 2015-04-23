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
	
	private final char DOLLAR = 36;
	private final char POUND = 163;
	private final char YEN = 165;
	
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
		this.unit = amount.unit;
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
		switch(this.unit) {
			case DOLLAR:return amount;
			case POUND: return amount/.68;
			case YEN: return amount/120.07;
		}
		return getDollars();
	}
	
	public double getPounds() {
		switch(this.unit) {
			case DOLLAR: return amount*.68;
			case POUND: return amount;
			case YEN: return (amount/120.07)*.68;
		}
		return getPounds();
	}
	
	public double getYen() {
		switch(this.unit) {
			case DOLLAR: return amount*120.07;
			case POUND: return amount/.68*120.07;
			case YEN: return amount;
		}
		return getYen();
	}
	
	public boolean equals(Currency otherAmount) {
		double tempAmount1 = this.amount;
		double tempAmount2 = otherAmount.amount;

		switch(otherAmount.unit) {
		case DOLLAR: tempAmount1 = getDollars();
			return tempAmount1 == tempAmount2;
		case POUND: tempAmount1 = getPounds();
			return tempAmount1 == tempAmount2;
		case YEN: tempAmount1 = getYen();
			return tempAmount1 == tempAmount2;
		}
		return this.equals(otherAmount);
	}
	
	public boolean lessThan(Currency otherAmount) {
		double temp1 = this.amount;
		double temp2 = otherAmount.amount;
		
		switch(otherAmount.unit) {
		case DOLLAR: temp1 = getDollars();
			return temp1 < temp2;
		case POUND: temp1 = getPounds();
			return temp1 < temp2;
		case YEN: temp1 = getYen();
			return temp1 < temp2;
		}
		return this.lessThan(otherAmount);
	}
	
	public boolean greaterThan(Currency otherAmount) {
		double temp1 = this.amount;
		double temp2 = otherAmount.amount;
		
		switch(otherAmount.unit) {
		case DOLLAR: temp1 = getDollars();
			return temp1 > temp2;
		case POUND: temp1 = getPounds();
			return temp1 > temp2;
		case YEN: temp1 = getYen();
			return temp1 > temp2;
		}
		return this.greaterThan(otherAmount);
	}
	
	public void deposit(Currency amount) {
		if(this.unit != amount.unit) {
			if(this.unit == DOLLAR) {
				double temp = amount.getDollars();
				this.amount += temp;
			}else if(this.unit == POUND) {
				double temp = amount.getPounds();
				this.amount += temp;
			}else if(this.unit == YEN) {
				double temp = amount.getYen();
				this.amount += temp;
			}
		} else 
			this.amount += amount.amount;
	}
	
	public void withdraw(Currency amount) {
		
		if(this.unit != amount.unit) {
			if(this.unit == DOLLAR) {
				double temp = amount.getDollars();
				this.amount -= temp;
			}else if(this.unit == POUND) {
				double temp = amount.getPounds();
				this.amount -= temp;
			}else if(this.unit == YEN) {
				double temp = amount.getYen();
				this.amount -= temp;
			}
		} else
			this.amount -= amount.amount;
	}
	
	public void printInDollars() {
		System.out.println(DOLLAR + "" + df.format(getDollars()));
	}
	
	public void printInPounds() {
		System.out.println(POUND + "" + df.format(getPounds()));
	}
	
	public void printInYen() {
		System.out.println(YEN + "" + df.format(this.getYen()));
	}
	
}