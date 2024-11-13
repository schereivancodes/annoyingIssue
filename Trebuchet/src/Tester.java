
public class Tester extends Trebuchet{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] keys = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		String wilder = "hellonetwothree";
		for (String s : keys) {
			if (wilder.indexOf(s) > -1) {
				System.out.println("Found " + s);
			}
		}
	}
	public static int calibrate() {
		return 0;
	}
	
}
