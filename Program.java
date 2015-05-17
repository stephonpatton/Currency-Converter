import java.util.Scanner;
public class Program {
	public static void main(String[] args) {
		//Examples from word document
		Currency c1 = new Currency(15.03, (char)36);
		Currency c2 = new Currency(11.33, (char)163);
		System.out.println(c1.equals(c2));
		System.out.println(c1.lessThan(c2));
		c1.printInPounds();
		c2.printInYen();
		//////////////////
		
		//Part Two
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many currency objects would you like?");
		int size = keyboard.nextInt();
		Currency[] currs = new Currency[size];
		
		//for loop that creates Currency objects and then 
		//prints the values in the other units back out
		for(int i = 0; i<size; i++) {
			System.out.println("What is the value of Currency " + i + "? \n(Amount first separated by space; 36 for dollars, 163 for pounds, 165 for yen");
			double value = keyboard.nextDouble();
			int unit = keyboard.nextInt();
			if(unit == 36) {
				currs[i] = new Currency(value, (char)unit);
				System.out.println("You entered: $" + value);
				System.out.println("This is equivalent to: ");
				currs[i].printInDollars(); currs[i].printInPounds(); currs[i].printInYen();
			}
			else if(unit == 163) {
				currs[i] = new Currency(value, (char)unit);
				System.out.println("You entered: " + (char)unit + value);
				System.out.println("This is equivalent to: ");
				currs[i].printInPounds(); currs[i].printInDollars(); currs[i].printInYen();
			}
			else if(unit == 165) {
				currs[i] = new Currency(value, (char)unit);
				System.out.println("You entered: " + (char)unit + value);
				System.out.println("This is equivalent to: ");
				currs[i].printInYen(); currs[i].printInDollars(); currs[i].printInPounds();
			}
			else {
				System.out.println("Invalid unit");
				System.exit(0);
			}
		}//end of for loop
		keyboard.close();
	}
}
