package quickSort;

import java.util.ArrayList;

public class Algorithm {
	private ArrayList<Double> data;

	public void sort(ArrayList<Double> inputData) {
		if (inputData.size() == 0 || inputData == null) {
			return;
		} else {
			this.data = inputData;
			quickSort(0, this.data.size() - 1);
		}
	}

	private void quickSort(int lowerIndex, int higherIndex) {
		int i = lowerIndex;
		int j = higherIndex;
		double pivot = data.get(lowerIndex + (higherIndex - lowerIndex) / 2);
		while (i <= j) {
			while (data.get(i) < pivot) {
				i++;
			}
			while (data.get(j) > pivot) {
				j--;
			}
			if (i <= j) {
				swap(i, j);
				i++;
				j--;
			}
		}
		if (lowerIndex < j) {
			quickSort(lowerIndex, j);
		}
		if (i < higherIndex) {
			quickSort(i, higherIndex);
		}
	}

	private void swap(int i, int j) {
		double tmp = data.get(i);
		data.set(i, data.get(j));
		data.set(j, tmp);
	}
}
