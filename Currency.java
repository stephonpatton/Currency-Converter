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
//		this(0.0, (char)36);
	}
	
	public Currency(double value) {
//		this.amount =  value;
		this(value, (char)36);
	}
	public Currency(char unit) {
//		this.unit = unit;
		this(0.0, (char)unit);
	}
	
	public Currency(double value, char unit) {
		this.setAmount(value);
		this.setUnit((char)unit);
//		this.amount = value;
//		this.unit = unit;
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
		 else if(unit == YEN) return amount*120.07;
		 else System.out.println("Invalid unit to convert to dollars");
		return getDollars();
	}
	
	public double getPounds() {
		if(unit == POUND) return amount;
		else if(unit == DOLLAR) return amount*.68;
		else if(unit  == YEN) return getDollars()*.68;
		else System.out.println("Invalid unit to convert");
		return getPounds();
	}
	
	public double getYen() {
		if(unit == YEN) return amount;
		else if(unit == DOLLAR) return amount*120.07;
		else if(unit  == POUND) return getDollars()*120.07;
		else System.out.println("Invalid unit to convert");
		return getYen();
	}
	
	public boolean equals(Currency otherAmount) {
		char tempUnit1 = this.unit;
		char tempUnit2 = otherAmount.unit;
		double tempAmount1 = this.amount;
		double tempAmount2 = otherAmount.amount;
		
		if(tempUnit1 == DOLLAR) {
			tempAmount2 = getDollars();
				return tempAmount1 == tempAmount2;
		}
		else if(tempUnit1 == POUND){
			tempAmount2 = getPounds();
			return tempAmount1 == tempAmount2;
		}
		else if(tempUnit1 == YEN) {
			tempAmount2 = getYen();
			return tempAmount1 == tempAmount2;
		}
		return this.equals(otherAmount);
	}
	
	public boolean lessThan(Currency otherAmount) {
		double temp1 = this.amount;
		double temp2 = otherAmount.amount;
		
		if(!equals(otherAmount)) {
			
			
		}
		return true;
	}
	
	public boolean greaterThan(Currency otherAmount) {
		return true;
	}
	
	public void deposit(Currency amount) {
		
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
	
	public void unitConversion(Currency otherAmount) {
		Currency tu = otherAmount;
		char tempUnit1 = this.unit;
		char tempUnit2 = otherAmount.unit;
		double tempAmount1 = this.amount;
		double tempAmount2 = otherAmount.amount;
		boolean sameUnit = tempUnit1 == tempUnit2;
		boolean sameAmount = tempAmount1 == tempAmount2;
		
		if(!sameUnit && !sameAmount) {
			if(tempUnit1 == DOLLAR) 
				tu.getDollars();
			else if(tempUnit1 == POUND)
				tu.getPounds();
			else if(tempUnit1 == YEN)
				tu.getYen();
		} 
	}
}
