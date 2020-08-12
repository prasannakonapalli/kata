package test;

import java.util.Arrays;

public class StringCalc {
	public static void main(String[] args) {
		// String numbers[]= {1,2,3};
		// System.out.println();
//		System.out.println(add("1,2,"));
//		System.out.println(add("1\n2,3"));
//
//		System.out.println(add("1,\n"));
//		// System.out.println(add("1,,3"));
//		System.out.println(add("//;\n1;5"));
// 
		// System.out.println(add("-2,-4,5"));
// 
//		System.out.println(add("2,3,1002"));
// 
		System.out.println(add("//***\n1***2***3"));

		// System.out.println(add("//*%\n1*2%9"));

	}

	public static int add(String numbers) {
		// try {

		// default delimiter
		String delimiter = ",";
		String num = "";
		String newDelimiter = "";
		String negativeNumbers = "";
		boolean isNegative = false;
		int sum = 0;

		if (numbers.equals("")) {
			return 0;
		}

		int indexSlash = numbers.indexOf("//");
		int indexNewLine = numbers.indexOf("\n");

		// find if there is any new delimiter
		if (numbers.startsWith("//")) {
			newDelimiter = numbers.substring(indexSlash + 2, indexNewLine);
			// get the remaining string from /n onwards
			num = numbers.substring(indexNewLine + 1);
		} else {
			num = numbers.replace("//", "");
		}

		// if new delimiter is not empty then replace the newdelimiter with actual
		// delimeter
		if (!newDelimiter.isEmpty()) {
			delimiter = newDelimiter;
		}

		// replace \n with delimiter in between numbers
		num = num.replace("\n", delimiter);

		// check for multiple delimiters and format as regex string and assign to actual
		// delimiter

		if (delimiter.length() > 1) {
			// check for same delimiters values like ***
			if (delimiter.charAt(0) != delimiter.charAt(1)) {
				String multiDelimiter = "";
				for (int i = 0; i < delimiter.length(); i++) {
					multiDelimiter += Character.toString(delimiter.charAt(i)) + "|";
				}
				multiDelimiter = "[" + multiDelimiter + "]";
				delimiter = multiDelimiter;
			}

		}

		// if delimeter contains * add escape characters
		if (delimiter.contains("*")) {
			delimiter = delimiter.replace("*", "\\*");
		}

		// split the num with delimiter
		String parts[] = num.split(delimiter);
		;
		for (int j = 0; j < parts.length; j++) {

			if (!parts[j].isBlank()) {
				int tempInt = Integer.parseInt(parts[j]);

				// to handle negative number scenerios
				if (tempInt < 0) {
					negativeNumbers += " " + tempInt;
					isNegative = true;
				}
				// to handle negative number >1000
				if (tempInt > 1000) {
					tempInt = 0;
				}
				sum += tempInt;
			}

		}

		if (isNegative) {
			throw new ArithmeticException("negatives not allowed" + negativeNumbers);

		} else {
			return sum;
		}

		// }

//		catch (Exception e) {
//			System.out.println(e);
//			// System.exit(0);
//		}
		// return 0;
	}
}