package quickSort;

import java.util.ArrayList;
/**
 * @author Sam Malpass
 * @version 1.0
 * @since 1.0
 */
public class Algorithm {
	/**
	 * data holds the numbers during and after sorting
	 */
	private ArrayList<Double> data;
	/**
	 * Function definition for sort()
	 * <p>
	 * Checks whether the inputData is empty, returning if so.
	 * Otherwise, dumps the inputData into data and runs quickSort()
	 * <p>
	 * @param inputData is the data to be sorted
	 */
	public void sort(ArrayList<Double> inputData) {
		/*If the inputData is empty*/
		if (inputData.size() == 0 || inputData == null) {
			/*Return*/
			return;
			/*Otherwise*/
		} else {
			/*Dump the inputData in the data ArrayList*/
			this.data = inputData;
			/*Runs quickSort function*/
			quickSort(0, this.data.size() - 1);
		}
	}
	/**
	 * Function definition for quickSort()
	 * <p>
	 * Sets the i and j to the higher and lower indexes before finding the
	 * pivot in the ArrayList and beginning the sorting process, recursively calling
	 * quickSort until ArrayList is sorted
	 * <p>
	 * @param lowerIndex is the lower index of the ArrayList
	 * @param higherIndex it the upper index of the ArrayList
	 */
	private void quickSort(int lowerIndex, int higherIndex) {
		/*Creates and sets i to the lowerIndex*/
		int i = lowerIndex;
		/*Creates and sets j to the higherIndex*/
		int j = higherIndex;
		/*Creates and sets the pivot value*/
		double pivot = data.get(lowerIndex + (higherIndex - lowerIndex) / 2);
		/*While i is smaller or equal to j*/
		while (i <= j) {
			/*While the value at index i is smaller than the pivot*/
			while (data.get(i) < pivot) {
				/*Increment i*/
				i++;
			}
			/*While the value at index j is greater than the pivot*/
			while (data.get(j) > pivot) {
				/*Decrement j*/
				j--;
			}
			/*If i is less than or equal to j*/
			if (i <= j) {
				/*Swap the values at indexes i and j*/
				swap(i, j);
				/*Increment i*/
				i++;
				/*Increment j*/
				j--;
			}
		}
		/*If the lowerIndex is less than j*/
		if (lowerIndex < j) {
			/*Run quickSort on the lowerIndex and j*/
			quickSort(lowerIndex, j);
		}
		/*If i is less than the higherIndex*/
		if (i < higherIndex) {
			/*Run quickSort on i and the higherIndex*/
			quickSort(i, higherIndex);
		}
	}
	/**
	 * Function definition for swap()
	 * <p>
	 * Swaps two values at different indexes i and j
	 * <p>
	 * @param i is an index to have its value swapped
	 * @param j is another index to have its value swapped
	 */
	private void swap(int i, int j) {
		/*Create a temporary variable to store a variable*/
		double tmp = data.get(i);
		/*Set one value to equal the other*/
		data.set(i, data.get(j));
		/*Set the other value to equal the temporary variable*/
		data.set(j, tmp);
	}
}
