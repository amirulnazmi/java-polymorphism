
import java.util.Scanner;

public class calculateBMR {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		char selection;

		BMR newBMR = new BMR();
		newBMR.WelcomeTo();
		BMR userProfile;

		System.out.println("\n");
		System.out.print("\tAre you a man or women? (m/w): ");
		selection = input.next().charAt(0);
		System.out.println("\n");

		if (selection == 'm')
			userProfile = new ManBMR();
		else
			userProfile = new WomenBMR();

		System.out.println("\n");
		userProfile.WelcomeTo();

		System.out.println("\n");
		System.out.print("\tEnter your age: ");
		userProfile.age = input.nextInt();

		System.out.print("\tEnter height in cm: ");
		userProfile.height = input.nextDouble();

		System.out.print("\tEnter weight in kg: ");
		userProfile.weight = input.nextDouble();
		userProfile.calculation();
		System.out.println("\n");
		userProfile.showResult();
		System.out.println("\n\n");

	}
}

class BMR {
	public int age;
	public double weight, height, BMR, result;

	BMR() {
		System.out.println("(Background) BMR engine is running from Base Constructor in BMR");
	}

	public void WelcomeTo() {
		System.out.println("\tWelcome to BMR System (Base class)");
	}

	public void calculation() {
		result = 0;

	}

	public void showResult() {
		System.out.println("\tYour Basal Metabolic Result is: " + result + "(From Base class in class BMR)");
	}

}

class ManBMR extends BMR {

	ManBMR() {
		System.out.println("(Background) BMR is initialized to man in class ManBMR");
	}

	public void WelcomeTo() {
			super.WelcomeTo();
		System.out.println("\tBMR System for man (child class)");
	}

	public void calculation() {
		result = 66 + (13.7 * weight) + (5 * height) - (6.8 * age);
	}

	public void showResult() {
		System.out.println("\tYour Basal Metabolic Result is: " + result + " daily burned calories");
		System.out.println("\t(Calculate using Harris Benedict Equation formula for man)");
	}

}

class WomenBMR extends BMR {

	WomenBMR() {
		System.out.println("(Background) BMR is initialized to women in class WomenBMR");
	}

	public void WelcomeTo() {
		super.WelcomeTo();
		System.out.println("BMR System for women (child class)");
	}

	public void calculation() {
		result = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * age);
	}

	public void showResult() {
		System.out.println("\tYour Basal Metabolic Result is: " + result + " daily burned calories");
		System.out.println("\t(Calculate using Harris Benedict Equation formula for women)");
	}

}