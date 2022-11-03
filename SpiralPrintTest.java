import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/*
 * SpiralPrintTest has a test which checks whether given input array traversed in spiral order or not.
 * 1,2,3,4
 * 12,13,14,5
 * 11,16,15,6
 * 10,9,8,7
 * traversed as 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16
 * 
 * @author hbozkurt
 * */
public class SpiralPrintTest {

	@Test
	public void testSpiralPrinfOfArray() {
		// null check
		assertEquals(0, printInSpiralOrder(null).size());

		// zero checks
		int[][] nullArray = new int[0][5];
		assertEquals(0, printInSpiralOrder(nullArray).size());
		int[][] zeroArray = new int[5][0];
		assertEquals(0, printInSpiralOrder(zeroArray).size());

		// check n*n array
		int[][] input = { { 1 } };
		List<Integer> expectedResult = new ArrayList<>(Arrays.asList(1));
		List<Integer> result = printInSpiralOrder(input);
		assertEquals(1, result.size());
		assertEquals(expectedResult, result);

		int[][] input2 = { { 1, 2 }, { 4, 3 }, };
		expectedResult = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		result = printInSpiralOrder(input2);
		assertEquals(4, result.size());
		assertEquals(expectedResult, result);

		int[][] input3 = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
		expectedResult = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		result = printInSpiralOrder(input3);
		assertEquals(9, result.size());
		assertEquals(expectedResult, result);

		int[][] input4 = { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, { 10, 9, 8, 7 } };
		expectedResult = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
		result = printInSpiralOrder(input4);
		assertEquals(16, result.size());
		assertEquals(expectedResult, result);

		// check 1*2 array
		int[][] input5 = { { 1 }, { 2 } };
		expectedResult = new ArrayList<>(Arrays.asList(1, 2));
		result = printInSpiralOrder(input5);
		assertEquals(2, result.size());
		assertEquals(expectedResult, result);

		// check 4*6 array
		int[][] input6 = { { 1, 2, 3, 4, 5, 6 }, { 16, 17, 18, 19, 20, 7 }, { 15, 24, 23, 22, 21, 8 },
				{ 14, 13, 12, 11, 10, 9 } };
		expectedResult = new ArrayList<>(
				Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24));
		result = printInSpiralOrder(input6);
		assertEquals(24, result.size());
		assertEquals(expectedResult, result);

		// check 5*8 array
		int[][] input7 = { { 1, 2, 3, 4, 5 }, { 22, 23, 24, 25, 6 }, { 21, 36, 37, 26, 7 }, { 20, 35, 38, 27, 8 },
				{ 19, 34, 39, 28, 9 }, { 18, 33, 40, 29, 10 }, { 17, 32, 31, 30, 11 }, { 16, 15, 14, 13, 12 } };
		expectedResult = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
				19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40));
		result = printInSpiralOrder(input7);
		assertEquals(40, result.size());
		assertEquals(expectedResult, result);
	}

	/**
	 * Traverse given input array in spiral order
	 * 
	 * @param input is array of int which will be traversed in spiral order.
	 * @return spiral order of given array as List.
	 */
	private List<Integer> printInSpiralOrder(int[][] input) {
		// prepare empty list to keep return value
		List<Integer> solution = new ArrayList<Integer>();
		// check input value
		if (input != null && input.length != 0 && input[0].length != 0) {
			// start from row 0
			int startRow = 0;
			// calculate last row number
			int endRow = input.length - 1;
			// start from column 0
			int startColumn = 0;
			// calculate last column
			int endColumn = input[0].length - 1;
			// iterate until all elements are in the list
			while (solution.size() < input.length * input[0].length) {
				// visit from left to right
				for (int i = startColumn; i <= endColumn; i++) {
					solution.add(input[startRow][i]);
				}
				startRow++;

				// visit from up to bottom
				for (int i = startRow; i <= endRow; i++) {
					solution.add(input[i][endColumn]);
				}
				endColumn--;

				// check to not go further
				if (startRow <= endRow) {
					// visit from right to left
					for (int i = endColumn; i >= startColumn; i--) {
						solution.add(input[endRow][i]);
					}
					endRow--;
				}

				// check to not go further
				if (startColumn <= endColumn) {
					// visit from bottom to up
					for (int i = endRow; i >= startRow; i--) {
						solution.add(input[i][startColumn]);
					}
					startColumn++;
				}
			}
		}
		return solution;
	}

}
