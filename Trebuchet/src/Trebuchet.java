//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class Trebuchet {
//
//	/**
//	 * 	This method uses the Scanner class to read input from a File, then sends
//	 * 	that data to the calibrate and recalibrate methods. Finally, it prints the 
//	 * 	results from those method calls.
//	 * 
//	 * 	Precondition:
//	 * 		There is a text file at filepath "src/calibrate.txt"
//	 * 
//	 * 	Postcondition:
//	 * 		Data has been calibrated, and then re-calibrated, and results are printed to the console.		
//	 * 
//	 * 	Algorithm:
//	 * 		Create a new File object called file, and pass it the file path of your calibration document as a String
//	 * 		Create a new Scanner object called fin, and pass it a reference to your file object
//	 * 	
//	 * 		Print a message that concatenates a String "The calibration value is..." with the result of invoking
//	 * 			the calibrate method, passing it a reference to fin
//	 * 
//	 * 		Reassign fin with a new Scanner object, and pass it a reference to your file object
//	 * 
//	 * 		Print a message that concatenates a String "The recalibration value is..." with the result of invoking
//	 * 			the recalibrate method, passing it a reference to fin
//	 * 		
//	 * @param args
//	 * @throws FileNotFoundException
//	 */
//	public static void main(String[] args) throws FileNotFoundException {
//		// TODO: Implement this method
//		File file = new File("data/bruh.txt"); // REMINDER TO CHANGE THIS BACK TO OUR CALIBRATION FILE
//		Scanner fin = new Scanner(file);
//		
//		System.out.println("The calibration value is... " + calibrate(fin));
//		
//		fin = new Scanner(file);
//		
//		System.out.println("The recalibration value is... " + recalibrate(fin));
//	}
//
//	
//	/**
//	 * 	This method finds the sum of the document's calibration values and returns the sum. 
//	 * 
//	 * 	Precondition:
//	 * 		Scanner input is set up to read from the calibration document.
//	 * 
//	 * 	Postcondition:
//	 * 		Every line in the document has been processed and all calibration values have
//	 * 		been added together and returned.
//	 * 
//	 * 	Algorithm:
//	 * 		Declare and initialize an int variable called result
//	 * 		Use the Scanner class' hasNext() method to continue iterating until there is no more data
//	 * 			...Get the current line
//	 * 			...Starting from the beginning of the line, find the first part of the calibration value
//	 * 			...Starting from the end of the line, find the last part of the calibration value
//	 * 			...Calculate the line's calibration value and add it to result
//	 * 		Return the result
//	 * 
//	 * @param input
//	 * @return
//	 */
//	public static int calibrate(Scanner input) {
//		// TODO: Implement this method
//		int result = 0;
//		String firstCalibrationVal = "";
//		String secondCalibrationVal = "";
//		String currentLine = "";
//		String calibrationVal = "";
//		int parsedCalibrationVal = 0;
//		
//		while (input.hasNext()) {
//			currentLine = input.next();
//			for (int i = 0; i < currentLine.length(); i++) {
//				if (Character.isDigit(currentLine.charAt(i))) {
//					firstCalibrationVal = currentLine.substring(i, i + 1);
//					break;
//				}
//			}
//			for (int j = currentLine.length() - 1; j > 0; j--) {
//				if (Character.isDigit(currentLine.charAt(j))) {
//					secondCalibrationVal = currentLine.substring(j, j + 1);
//					break;
//				}
//			}
//			calibrationVal = firstCalibrationVal + secondCalibrationVal;
//			parsedCalibrationVal = Integer.parseInt(calibrationVal);
//			result += parsedCalibrationVal;
//		}
//		return result;
//	}
//	
//	
//	/**
//	 * 	This method finds the sum of the document's calibration values, accounting for both numerical (i.e. "1") and 
//	 * 	text (i.e. "one") values, and returns the result.
//	 * 
//	 * 	Precondition:
//	 * 		Scanner input is set up to read from the calibration document.
//	 * 
//	 * 	Postcondition:
//	 * 		Every line in the document has been processed and all calibration values have
//	 * 		been added together and returned.
//	 * 
//	 * 	Algorithm:
//	 * 		Modify your code from the calibrate method to also account for the text values "one", "two", "three", "four", 
//	 * 		"five", "six", "seven", "eight", and "nine".
//	 * 		Return the sum of the calibration values.
//	 * 
//	 * @param input
//	 * @return
//	 */
//	/**public static int recalibrate(Scanner input) {
//		String[] keys = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
//		int result = 0;
//		String firstCalibrationVal = "";
//		String secondCalibrationVal = "";
//		String currentLine = "";
//		String calibrationVal = "";
//		int parsedCalibrationVal = 0;
//		
//		while (input.hasNext()) {
//			currentLine = input.next();
//			for (int i = 0; i < currentLine.length(); i++) {
//				if (Character.isDigit(currentLine.charAt(i))) {
//					firstCalibrationVal = currentLine.substring(i, i + 1);
//					System.out.println("shut up");
//					break;
//				}
//				else {
//					for (String s : keys) {
//						if (currentLine.substring(i, i + s.length()).equals(s)) {
//							System.out.println("Current key: " + s);
//							System.out.println("Current i position: " + i);
//							firstCalibrationVal = currentLine.substring(i, i + s.length());
//							System.out.println("First calibration val: " + firstCalibrationVal);
//							break;
//						}
//					}
//				}
//				System.out.println("Next index of " + i);
//			}
//			for (int j = currentLine.length() - 1; j > 0; j--) {
//				if (Character.isDigit(currentLine.charAt(j))) {
//					secondCalibrationVal = currentLine.substring(j, j + 1);
//					break;
//				}
//				else {
//					for (String s : keys) {
//						if (currentLine.substring(j - s.length() + 1, j + 1).equals(s)) {
//							secondCalibrationVal = currentLine.substring(j - s.length() + 1, j + 1);
//							break;
//						}
//					}
//				}
//			}
//			if (firstCalibrationVal.equals("one")) {
//				firstCalibrationVal = "1";
//			}
//			else if (firstCalibrationVal.equals("two")) {
//				firstCalibrationVal = "2";
//			}
//			else if (firstCalibrationVal.equals("three")) {
//				firstCalibrationVal = "3";
//			}
//			else if (firstCalibrationVal.equals("four")) {
//				firstCalibrationVal = "4";
//			}
//			else if (firstCalibrationVal.equals("five")) {
//				firstCalibrationVal = "5";
//			}
//			else if (firstCalibrationVal.equals("six")) {
//				firstCalibrationVal = "6";
//			}
//			else if (firstCalibrationVal.equals("seven")) {
//				firstCalibrationVal = "7";
//			}
//			else if (firstCalibrationVal.equals("eight")) {
//				firstCalibrationVal = "8";
//			}
//			else if (firstCalibrationVal.equals("nine")) {
//				firstCalibrationVal = "9";
//			}
//			else {
//				continue;
//			}
//			
//			if (secondCalibrationVal.equals("one")) {
//				secondCalibrationVal = "1";
//			}
//			else if (secondCalibrationVal.equals("two")) {
//				secondCalibrationVal = "2";
//			}
//			else if (secondCalibrationVal.equals("three")) {
//				secondCalibrationVal = "3";
//			}
//			else if (secondCalibrationVal.equals("four")) {
//				secondCalibrationVal = "4";
//			}
//			else if (secondCalibrationVal.equals("five")) {
//				secondCalibrationVal = "5";
//			}
//			else if (secondCalibrationVal.equals("six")) {
//				secondCalibrationVal = "6";
//			}
//			else if (secondCalibrationVal.equals("seven")) {
//				secondCalibrationVal = "7";
//			}
//			else if (secondCalibrationVal.equals("eight")) {
//				secondCalibrationVal = "8";
//			}
//			else if (secondCalibrationVal.equals("nine")) {
//				secondCalibrationVal = "9";
//			}
//			else {
//				continue;
//			}
//			calibrationVal = firstCalibrationVal + secondCalibrationVal;
//			parsedCalibrationVal = Integer.parseInt(calibrationVal);
//			result += parsedCalibrationVal;
//			System.out.println("Let's check that next line, bucko!");
//		}
//		return result;
//	} */
//	public static int recalibrate(Scanner input) {
//		HashMap<String, Integer> keys = new HashMap<String, Integer>();
//		keys.put("one", -1);
//		keys.put("two", -1);
//		keys.put("three", -1);
//		keys.put("four", -1);
//		keys.put("five", -1);
//		keys.put("six", -1);
//		keys.put("seven", -1);
//		keys.put("eight", -1);
//		keys.put("nine", -1);
//		int result = 0;
//		String firstCalibrationVal = "";
//		String firstDigitVal = "";
//		int firstDigitIndex = 0;
//		String secondCalibrationVal = "";
//		String secondDigitVal = "";
//		int secondDigitIndex = 0;
//		String currentLine = "";
//		String calibrationVal = "";
//		int parsedCalibrationVal = 0;
//		
//		while (input.hasNext()) {
//			currentLine = input.next();
//			for (int i = 0; i < currentLine.length(); i++) {
//				if (Character.isDigit(currentLine.charAt(i))) {
//					firstDigitVal = currentLine.substring(i, i + 1);
//					firstDigitIndex = currentLine.indexOf(i);
//					break;
//				}
//			}
//			for (int j = currentLine.length() - 1; j > 0; j--) {
//				if (Character.isDigit(currentLine.charAt(j))) {
//					secondDigitVal = currentLine.substring(j, j + 1);
//					secondDigitIndex = currentLine.indexOf(j);
//					break;
//				}
//			}
//			for (String s : keys.keySet()) {
//				if (currentLine.indexOf(s) > -1) {
//					keys.put(s, currentLine.indexOf(s));
//				}
//			}
//			calibrationVal = firstCalibrationVal + secondCalibrationVal;
//			parsedCalibrationVal = Integer.parseInt(calibrationVal);
//			result += parsedCalibrationVal;
//		}
//		return result;
//	}
//}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Trebuchet {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("data/bruh.txt"); // REMINDER TO CHANGE THIS BACK TO OUR CALIBRATION FILE
        Scanner fin = new Scanner(file);

        System.out.println("The calibration value is... " + calibrate(fin));

        fin = new Scanner(file);

        System.out.println("The recalibration value is... " + recalibrate(fin));
    }

    public static int calibrate(Scanner input) {
        int result = 0;
        while (input.hasNextLine()) {
            String currentLine = input.nextLine();
            String firstNumber = "";
            String secondNumber = "";

            for (int i = 0; i < currentLine.length(); i++) {
                if (Character.isDigit(currentLine.charAt(i))) {
                    firstNumber = String.valueOf(currentLine.charAt(i));
                    break;
                }
            }
            for (int j = currentLine.length() - 1; j >= 0; j--) {
                if (Character.isDigit(currentLine.charAt(j))) {
                    secondNumber = String.valueOf(currentLine.charAt(j));
                    break;
                }
            }

            if (!firstNumber.isEmpty() && !secondNumber.isEmpty()) {
                result += Integer.parseInt(firstNumber + secondNumber);
            }
        }
        return result;
    }

    public static int recalibrate(Scanner input) {
        HashMap<String, String> textToDigit = new HashMap<>();
        textToDigit.put("one", "1");
        textToDigit.put("two", "2");
        textToDigit.put("three", "3");
        textToDigit.put("four", "4");
        textToDigit.put("five", "5");
        textToDigit.put("six", "6");
        textToDigit.put("seven", "7");
        textToDigit.put("eight", "8");
        textToDigit.put("nine", "9");

        int result = 0;
        while (input.hasNextLine()) {
            String currentLine = input.nextLine();
            String firstNumber = "";
            String secondNumber = "";
            boolean isFirstFound = false;

            for (int i = 0; i < currentLine.length(); i++) {
                if (Character.isDigit(currentLine.charAt(i))) {
                    if (!isFirstFound) {
                        firstNumber = String.valueOf(currentLine.charAt(i));
                        isFirstFound = true;
                    } else {
                        secondNumber = String.valueOf(currentLine.charAt(i));
                        break;
                    }
                } else {
                    for (String key : textToDigit.keySet()) {
                        if (currentLine.substring(i).startsWith(key)) {
                            if (!isFirstFound) {
                                firstNumber = textToDigit.get(key);
                                isFirstFound = true;
                            } else {
                                secondNumber = textToDigit.get(key);
                                break;
                            }
                            i += key.length() - 1; // Move past the word
                        }
                    }
                }
            }

            if (!firstNumber.isEmpty() && !secondNumber.isEmpty()) {
                result += Integer.parseInt(firstNumber + secondNumber);
            }
        }
        return result;
    }
}