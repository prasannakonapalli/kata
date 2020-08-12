package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringCalcTester {
	@Test
	void testAddWithEmptyString() {
		// arrange-declare method inputs
		String temp = "";
		int expected = 0;

		// act-calling the method
		int actual = StringCalc.add(temp);

		// assert-JUnit test method
		assertEquals(expected, actual);

	}

	@Test
	void testAddWithOneNumberString() {
		// arrange-declare method inputs
		String temp = "1";
		int expected = 1;

		// act-calling the method
		int actual = StringCalc.add(temp);

		// assert-JUnit test method
		assertEquals(expected, actual);

	}

	@Test
	void testAddWithTwoNumberString() {
		// arrange-declare method inputs
		String temp = "1,2";
		int expected = 3;

		// act-calling the method
		int actual = StringCalc.add(temp);

		// assert-JUnit test method
		assertEquals(expected, actual);

	}

	@Test
	void testAddNewLinesBetweenNumberString() {
		// arrange-declare method inputs
		String temp = "1\n2,3";
		int expected = 6;

		// act-calling the method
		int actual = StringCalc.add(temp);

		// assert-JUnit test method
		assertEquals(expected, actual);

	}

	@Test
	void testAddWithUnknownAmountOfNumberString() {
		// arrange-declare method inputs
		String temp = "1,2,3,4,5";
		int expected = 15;

		// act-calling the method
		int actual = StringCalc.add(temp);

		// assert-JUnit test method
		assertEquals(expected, actual);

	}

	@Test
	void testAddWithDifferentDelimiterNumberString() {
		// arrange-declare method inputs
		String temp = "//;\n1;2";
		int expected = 3;

		// act-calling the method
		int actual = StringCalc.add(temp);

		// assert-JUnit test method
		assertEquals(expected, actual);

	}

	@Test
	void testAddWithNegativeNumbersString() {
		// arrange-declare method inputs
		ArithmeticException expected = new ArithmeticException("negatives not allowed -2");
		try {

			String temp = "-2";

			// act-calling the method
			StringCalc.add(temp);
		} catch (ArithmeticException actual) {
			// assert-JUnit test method
			assertEquals(expected.getMessage(), actual.getMessage());
		}
	}

	@Test
	void testAddWithMultipleNegativeNumbersString() {
		// arrange-declare method inputs
		String temp = "-2,-4,5";
		ArithmeticException expected = new ArithmeticException("negatives not allowed -2 -4");

		try { 

			// act-calling the method
			StringCalc.add(temp);
		} catch (ArithmeticException actual) {
			// assert-JUnit test method
			assertEquals(expected.getMessage(), actual.getMessage());
		}

	}

	@Test
	void testAddWithMoreThan1000NumberString() {
		// arrange-declare method inputs
		String temp = "1,2,2000";
		int expected = 3;

		// act-calling the method
		int actual = StringCalc.add(temp);

		// assert-JUnit test method
		assertEquals(expected, actual);

	}

	@Test
	void testAddWithAnyLengthDelimiterNumberString() {
		// arrange-declare method inputs
		String temp = "//***\n1***2***3";
		int expected = 6;

		// act-calling the method
		int actual = StringCalc.add(temp);

		// assert-JUnit test method
		assertEquals(expected, actual);

	}

	@Test
	void testAddWithMultipleDelimiterNumberString() {
		// arrange-declare method inputs
		String temp = "//*%\n1*2%3";
		int expected = 6;

		// act-calling the method
		int actual = StringCalc.add(temp);

		// assert-JUnit test method
		assertEquals(expected, actual);

	}
}
