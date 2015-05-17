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
	/**
	 * Default constructor <br>
	 * Sets the currency object to 5 dollars
	 */
	public Currency() {
		this.set(5.0, DOLLAR);
	}
	/**
	 * Constructor that sets the currency objects amount and 
	 * sets the unit to dollars (char)36
	 * @param value
	 */
	public Currency(double value) {
		this(value, (char)36);
	}
	/**
	 * Constructor that sets the currency objects unit and 
	 * sets the amount to 0
	 * @param unit
	 */
	public Currency(char unit) {
		this(0.0, (char)unit);
	}
	/**
	 * Constructor that sets the currency objects amount and unit
	 * @param value
	 * @param unit
	 */
	public Currency(double value, char unit) {
		this.setAmount(value);
		this.setUnit((char)unit);
	}
	/**
	 * Copy constructor
	 * @param amount
	 */
	public Currency(Currency amount) {
		this.set(amount.amount, amount.unit);
	}
	/**
	 * Sets the currency unit. 
	 * @param unit
	 */
	public void setUnit(char unit) {
		this.unit = unit;
	}
	/**
	 * Sets the currency amount <br>
	 * Must use (char) before unit
	 * @param value
	 */
	public void setAmount(double value) {
		this.amount = value;
	}
	/**
	 * Sets the currency amount and currency unit<br> 
	 * Must use (char) before unit
	 * @param value
	 * @param unit
	 */
	public void set(double value, char unit) {
		this.setAmount(value);
		this.setUnit(unit);
	}
	/**
	 * Converts the objects amount from pounds or yen
	 * to dollars
	 * @return The amount converted into dollars
	 */
	public double getDollars() {
		switch(this.unit) {
			case DOLLAR:return amount;
			case POUND: return amount/.68;
			case YEN: return amount/120.07;
			default: System.out.println("Invalid unit");
				break;
		}
		return getDollars();
	}
	/**
	 * Converts the objects amount from
	 * dollars or yen to pounds
	 * @return The amount converted into pounds
	 */
	public double getPounds() {
		switch(this.unit) {
			case DOLLAR: return amount*.68;
			case POUND: return amount;
			case YEN: return (amount/120.07)*.68;
			default: System.out.println("Invalid unit");
				break;
		}
		return getPounds();
	}
	/**
	 * Converts the objects amount from
	 * pounds or dollars to yen
	 * @return The amount converted into yen
	 */
	public double getYen() {
		switch(this.unit) {
			case DOLLAR: return amount*120.07;
			case POUND: return amount/.68*120.07;
			case YEN: return amount;
			default: System.out.println("Invalid unit");
				break;
		}
		return 0;
	}
	/**
	 * Determines if two Currency objects are
	 * equal in amount.<br>
	 * This method converts the two objects to
	 * the same unit then checks for equivalence
	 * @param otherAmount
	 * @return True or false
	 */
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
		default: System.out.println("Invalid unit");
			break;
		}
		return this.equals(otherAmount);
	}
	/**
	 * Determines if the <i>object</i> is less than
	 *  <i>otherObject</i>.<br>
	 * This method converts the two objects to the 
	 * same unit then checks to see if <i>object1 < otherAmount</i>
	 * @param otherAmount
	 * @return True or false
	 */
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
		default: System.out.println("Invalid unit");
			break;
		}
		return this.lessThan(otherAmount);
	}
	/**
	 * Determines if the <i>object</i> is greater than 
	 * <i>otherObject</i>.<br>
	 * This method converts the two objects to the same unit then 
	 * checks to see if <i>object1 > otherAmount</i>
	 * @param otherAmount
	 * @return True or false
	 */
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
		default: System.out.println("Invalid unit");
			break;
		}
		return this.greaterThan(otherAmount);
	}
	/**
	 * Deposits the <i>otherObject</i> into the <i>object</i>. <br>
	 * Converts the <i>otherObject</i> to the same unit as <i>object</i>.
	 * @param amount
	 */
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
			} else
				System.out.println("Invalid unit");
		} else 
			this.amount += amount.amount;
	}
	/**
	 * Withdraws <i>otherObject</i> from <i>object</i>.<br>
	 * Converts the <i>otherObject</i> to the same unit as <i>object</i>.
	 * @param amount
	 */
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
			} else
				System.out.println("Invalid unit");
		} else
			this.amount -= amount.amount;
	}
	/**
	 * Prints the <i>object</i> in dollars, rounding to the nearest tenth decimal.
	 */
	public void printInDollars() {
		System.out.println(DOLLAR + "" + df.format(getDollars()));
	}
	/**
	 * Prints the <i>object</i> in pounds, rounding to the nearest tenth decimal.
	 */
	public void printInPounds() {
		System.out.println(POUND + "" + df.format(getPounds()));
	}
	/**
	 * Prints the <i>object</i> in yen, rounding to the nearest tenth decimal.
	 */
	public void printInYen() {
		System.out.println(YEN + "" + df.format(this.getYen()));
	}
	
}