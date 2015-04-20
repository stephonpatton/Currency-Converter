
public class Program {
	public static void main(String[] args) {
		Currency curr = new Currency(15.03, (char)36);
		Currency curr2 = new Currency(11.33, (char)163);
		System.out.println(curr.equals(curr2));
		System.out.println(curr.lessThan(curr2));
		curr.printInPounds();
		curr2.printInYen();
	}

}
