import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

final class indexAndValue {
	private final int index;
	private final String value;
	
	public indexAndValue(int index, String value) {
		this.index = index;
		this.value = value;
	}
	
	public int getIndex() {
		return index;
	}
	
	public String getVal() {
		return value;
	}
}

public class Trebuchet {

	/**
	 * 	This method uses the Scanner class to read input from a File, then sends
	 * 	that data to the calibrate and recalibrate methods. Finally, it prints the 
	 * 	results from those method calls.
	 * 
	 * 	Precondition:
	 * 		There is a text file at filepath "src/calibrate.txt"
	 * 
	 * 	Postcondition:
	 * 		Data has been calibrated, and then re-calibrated, and results are printed to the console.		
	 * 
	 * 	Algorithm:
	 * 		Create a new File object called file, and pass it the file path of your calibration document as a String
	 * 		Create a new Scanner object called fin, and pass it a reference to your file object
	 * 	
	 * 		Print a message that concatenates a String "The calibration value is..." with the result of invoking
	 * 			the calibrate method, passing it a reference to fin
	 * 
	 * 		Reassign fin with a new Scanner object, and pass it a reference to your file object
	 * 
	 * 		Print a message that concatenates a String "The recalibration value is..." with the result of invoking
	 * 			the recalibrate method, passing it a reference to fin
	 * 		
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO: Implement this method
		File file = new File("data/calibration.txt"); // REMINDER TO CHANGE THIS BACK TO OUR CALIBRATION FILE
		Scanner fin = new Scanner(file);
		
		System.out.println("The calibration value is... " + calibrate(fin));
		
		fin = new Scanner(file);
		
		System.out.println("The recalibration value is... " + recalibrate(fin));
	}

	
	
	/**
	 * 	This method finds the sum of the document's calibration values and returns the sum. 
	 * 
	 * 	Precondition:
	 * 		Scanner input is set up to read from the calibration document.
	 * 
	 * 	Postcondition:
	 * 		Every line in the document has been processed and all calibration values have
	 * 		been added together and returned.
	 * 
	 * 	Algorithm:
	 * 		Declare and initialize an int variable called result
	 * 		Use the Scanner class' hasNext() method to continue iterating until there is no more data
	 * 			...Get the current line
	 * 			...Starting from the beginning of the line, find the first part of the calibration value
	 * 			...Starting from the end of the line, find the last part of the calibration value
	 * 			...Calculate the line's calibration value and add it to result
	 * 		Return the result
	 * 
	 * @param input
	 * @return
	 */
	public static indexAndValue findFirstDigit(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (Character.isDigit(input.charAt(i))) {
				return new indexAndValue(input.indexOf(i), input.substring(i, i + 1));
			}
		}
		return new indexAndValue(-1, "0");
	}
	
	public static indexAndValue findSecondDigit(String input) {
		for (int j = input.length() - 1; j > 0; j--) {
			if (Character.isDigit(input.charAt(j))) {
				return new indexAndValue(input.indexOf(j), input.substring(j, j + 1));
			}
		}
		return new indexAndValue(-1, "0");
	}
	
	public static indexAndValue findFirstString(String input) {
		String[] keys = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		for (int i = 0; i < input.length(); i++) {
			for (String s : keys) {
				if (input.substring(i, i + s.length()).equals(s)) {
					return new indexAndValue(input.indexOf(s), input.substring(i, i + s.length()));
				}	
			}
		}
		return new indexAndValue(-1, "0");
	}
	
	public static indexAndValue findSecondString(String input) {
		String[] keys = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		for (int j = input.length() - 1; j > 0; j--) {
			System.out.println("j: " + j);
			for (String s : keys) {
				System.out.println("key: " + s);
				System.out.println("length of s: " + s.length());
				if (input.substring(j - s.length() + 1, j + 1).equals(s)) {
					return new indexAndValue(input.indexOf(s), input.substring(j - s.length() + 1, j + 1));
				}
			}
		}
		return new indexAndValue(-1, "0");
	}
	
	public static int calibrate(Scanner input) {
	// TODO: Implement this method
	int result = 0;
	String firstCalibrationVal = "";
	String secondCalibrationVal = "";
	String currentLine = "";
	String calibrationVal = "";
	int parsedCalibrationVal = 0;
	
	while (input.hasNext()) {
		currentLine = input.next();
		for (int i = 0; i < currentLine.length(); i++) {
			if (Character.isDigit(currentLine.charAt(i))) {
				firstCalibrationVal = currentLine.substring(i, i + 1);
				break;
			}
		}
		for (int j = currentLine.length() - 1; j > 0; j--) {
			if (Character.isDigit(currentLine.charAt(j))) {
				secondCalibrationVal = currentLine.substring(j, j + 1);
				break;
			}
		}
		calibrationVal = firstCalibrationVal + secondCalibrationVal;
		parsedCalibrationVal = Integer.parseInt(calibrationVal);
		result += parsedCalibrationVal;
	}
	return result;
}
	
	 /* 	This method finds the sum of the document's calibration values, accounting for both numerical (i.e. "1") and 
	 * 	text (i.e. "one") values, and returns the result.
	 * 
	 * 	Precondition:
	 * 		Scanner input is set up to read from the calibration document.
	 * 
	 * 	Postcondition:
	 * 		Every line in the document has been processed and all calibration values have
	 * 		been added together and returned.
	 * 
	 * 	Algorithm:
	 * 		Modify your code from the calibrate method to also account for the text values "one", "two", "three", "four", 
	 * 		"five", "six", "seven", "eight", and "nine".
	 * 		Return the sum of the calibration values.
	 * 
	 * @param input
	 * @return
	 */
	public static int recalibrate(Scanner input) {
		int result = 0;
		
		String firstDigitCalibrationVal = "";
		int firstDigitCalibrationIndex = 0;
		
		indexAndValue firstDigit = null;
		
		String secondDigitCalibrationVal = "";
		int secondDigitCalibrationIndex = 0;
		
		indexAndValue secondDigit = null;
		
		String firstStringCalibrationVal = "";
		int firstStringCalibrationIndex = 0;
		
		indexAndValue firstString = null;
		
		String secondStringCalibrationVal = "";
		int secondStringCalibrationIndex = 0;
		
		indexAndValue secondString = null;
		
		String firstCalibrationVal = "";
		String secondCalibrationVal = "";
		
		String currentLine = "";
		String calibrationVal = "";
		
		int parsedCalibrationVal = 0;
		
		while (input.hasNext()) {
			currentLine = input.next();
			firstDigit = findFirstDigit(currentLine);
			firstString = findFirstString(currentLine);
			secondDigit = findSecondDigit(currentLine);
			secondString = findSecondString(currentLine);
			
			String firstDigitVal = firstDigit.getVal();
			int firstDigitIndex = firstDigit.getIndex();
			
			String firstStringVal = firstString.getVal();
			int firstStringIndex = firstString.getIndex();
			
			String secondDigitVal = secondDigit.getVal();
			int secondDigitIndex = secondDigit.getIndex();
			
			String secondStringVal = secondString.getVal();
			int secondStringIndex = secondString.getIndex();
			
			if (firstDigitIndex < firstStringIndex) {
				firstCalibrationVal = firstDigitVal;
			}
			else {
				firstCalibrationVal = firstStringVal;
			}
			
			if (secondDigitIndex < secondStringIndex) {
				secondCalibrationVal = secondDigitVal;
			}
			else {
				secondCalibrationVal = secondStringVal;
			}
			
			if (firstCalibrationVal.equals("one")) {
				firstCalibrationVal = "1";
			}
			else if (firstCalibrationVal.equals("two")) {
				firstCalibrationVal = "2";
			}
			else if (firstCalibrationVal.equals("three")) {
				firstCalibrationVal = "3";
			}
			else if (firstCalibrationVal.equals("four")) {
				firstCalibrationVal = "4";
			}
			else if (firstCalibrationVal.equals("five")) {
				firstCalibrationVal = "5";
			}
			else if (firstCalibrationVal.equals("six")) {
				firstCalibrationVal = "6";
			}
			else if (firstCalibrationVal.equals("seven")) {
				firstCalibrationVal = "7";
			}
			else if (firstCalibrationVal.equals("eight")) {
				firstCalibrationVal = "8";
			}
			else if (firstCalibrationVal.equals("nine")) {
				firstCalibrationVal = "9";
			}
			else {
				continue;
			}
			
			if (secondCalibrationVal.equals("one")) {
				secondCalibrationVal = "1";
			}
			else if (secondCalibrationVal.equals("two")) {
				secondCalibrationVal = "2";
			}
			else if (secondCalibrationVal.equals("three")) {
				secondCalibrationVal = "3";
			}
			else if (secondCalibrationVal.equals("four")) {
				secondCalibrationVal = "4";
			}
			else if (secondCalibrationVal.equals("five")) {
				secondCalibrationVal = "5";
			}
			else if (secondCalibrationVal.equals("six")) {
				secondCalibrationVal = "6";
			}
			else if (secondCalibrationVal.equals("seven")) {
				secondCalibrationVal = "7";
			}
			else if (secondCalibrationVal.equals("eight")) {
				secondCalibrationVal = "8";
			}
			else if (secondCalibrationVal.equals("nine")) {
				secondCalibrationVal = "9";
			}
			else {
				continue;
			}
			calibrationVal = firstCalibrationVal + secondCalibrationVal;
			parsedCalibrationVal = Integer.parseInt(calibrationVal);
			result += parsedCalibrationVal;
		}
		return result;
	} 
}