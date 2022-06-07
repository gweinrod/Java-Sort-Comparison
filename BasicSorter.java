package sortcomparison;

import java.util.*;

public class BasicSorter implements Sorter {

	@Override
	public void insertionSort(ArrayList<String> data, int firstIndex, int numberToSort) {

		String tempData;
		for (int i = firstIndex + 1; i < firstIndex + numberToSort; i++) {
			tempData = data.get(i);
			int j = i;
			while (j > firstIndex && tempData.compareTo(data.get(j - 1)) < 0) {
				data.set(j, data.get(j - 1));
				j--;
			}
			data.set(j, tempData);
		}
	}


	@Override
	public void quickSort(ArrayList<String> data, int firstIndex, int numberToSort) {
		if (numberToSort < 16 && numberToSort > 1) {
			insertionSort(data, firstIndex, numberToSort);
			return;
		}
		if (numberToSort > 1) {
			int partitionIndex = partition(data, firstIndex, numberToSort);
			quickSort(data, firstIndex, partitionIndex - firstIndex);
			quickSort(data, partitionIndex + 1, numberToSort - (partitionIndex - firstIndex + 1));
		}
	}


	@Override
	public int partition(ArrayList<String> data, int firstIndex, int numberToPartition) {

		setMedianPivot(data, firstIndex, numberToPartition);

		String pivot = data.get(firstIndex);

		int tooBigIndex = firstIndex + 1;
		int tooSmallIndex = firstIndex + numberToPartition - 1;

		while (tooBigIndex < tooSmallIndex) {
			while (tooBigIndex < tooSmallIndex && data.get(tooBigIndex).compareTo(pivot) <= 0) {
				tooBigIndex++;
			}
			while (tooSmallIndex > firstIndex && data.get(tooSmallIndex).compareTo(pivot) > 0) {
				tooSmallIndex--;
			}
			if (tooBigIndex < tooSmallIndex) {
				swapValues(data, tooSmallIndex, tooBigIndex);
			}
		}

		if (pivot.compareTo(data.get(tooSmallIndex)) >= 0) {
			swapValues(data, tooSmallIndex, firstIndex);
			return tooSmallIndex;
		} else {
			return firstIndex;
		}

	}


	private void setMedianPivot(ArrayList<String> data, int firstIndex, int numberToPartition) {

		int middleIndex = (firstIndex + firstIndex + numberToPartition) / 2;
		int lastIndex = firstIndex + numberToPartition - 1;

		if (data.get(firstIndex).compareTo(data.get(middleIndex)) > 0) {
			swapValues(data, firstIndex, middleIndex);
		}

		if (data.get(firstIndex).compareTo(data.get(lastIndex)) > 0) {
			swapValues(data, firstIndex, lastIndex);
		}

		if (data.get(middleIndex).compareTo(data.get(lastIndex)) > 0) {
			swapValues(data, middleIndex, lastIndex);
		}

		swapValues(data, firstIndex, middleIndex);

	}


	private void swapValues(ArrayList<String> data, int firstIndex, int secondIndex) {
		String tempData = data.get(firstIndex);
		data.set(firstIndex, data.get(secondIndex));
		data.set(secondIndex, tempData);
	}


	@Override
	public void mergeSort(ArrayList<String> data, int firstIndex, int numberToSort) {
		String[] temp = new String[data.size()];
		mergeSort(data, temp, firstIndex, numberToSort);
	}


	private void mergeSort(ArrayList<String> data, String[] temp, int firstIndex, int numberToSort) {

		if (numberToSort < 16 && numberToSort > 1) {
			insertionSort(data, firstIndex, numberToSort);
			return;
		}

		if (numberToSort > 1) {
			int leftSize = numberToSort / 2;
			int rightSize = numberToSort - leftSize;
			mergeSort(data, temp, firstIndex, leftSize);
			mergeSort(data, temp, firstIndex + leftSize, rightSize);
			if (data.get(firstIndex + leftSize - 1).compareTo(data.get(firstIndex + leftSize)) > 0) {
				merge(data, temp, firstIndex, leftSize, rightSize);
			}
		}

	}


	@Override
	public void merge(ArrayList<String> data, int firstIndex, int leftSegmentSize, int rightSegmentSize) {

		String[] temp = new String[data.size()];
		merge(data, temp, firstIndex, leftSegmentSize, rightSegmentSize);

	}


	public void merge(ArrayList<String> data, String[] temp, int firstIndex, int leftSegmentSize,
			int rightSegmentSize) {

		int i = 0;
		int j = 0;
		int k = firstIndex;
		int rightIndex = firstIndex + leftSegmentSize;

		while (i < leftSegmentSize && j < rightSegmentSize) {
			if (data.get(firstIndex + i).compareTo(data.get(rightIndex + j)) <= 0) {
				temp[k] = data.get(firstIndex + i);
				i++;
			} else {
				temp[k] = data.get(rightIndex + j);
				j++;
			}
			k++;
		}

		while (i < leftSegmentSize) {
			temp[k] = data.get(firstIndex + i);
			i++;
			k++;
		}

		while (j < rightSegmentSize) {
			temp[k] = data.get(rightIndex + j);
			j++;
			k++;
		}

		for (k = firstIndex; k < (firstIndex + leftSegmentSize + rightSegmentSize); k++) {
			data.set(k, temp[k]);
		}

	}


	@Override
	public void heapSort(ArrayList<String> data) {
		// TODO Auto-generated method stub

	}


	@Override
	public void heapify(ArrayList<String> data) {
		// TODO Auto-generated method stub

	}


	private void setRandomMedianPivot(ArrayList<String> data, int firstIndex, int numberToPartition) {
		int randomIndex[] = new int[3];
		ArrayList<String> randomValues = new ArrayList<>();
		HashMap<String, Integer> randomMap = new HashMap<>();
		for (int i = 0; i < 3; i++) {
			randomIndex[i] = (int) Math.floor(Math.random() * ((firstIndex + numberToPartition - 1) - firstIndex + 1))
					+ firstIndex;
		}
		for (int i : randomIndex) {
			String s = data.get(i);
			randomValues.add(s);
			randomMap.put(s, i);
		}
		insertionSort(randomValues, 0, 3);
		int medianIndex = randomMap.get(randomValues.get(1));
		String tempValue = data.get(medianIndex);
		data.set(medianIndex, data.get(firstIndex));
		data.set(firstIndex, tempValue);
	}


	private void setRandomPivot(ArrayList<String> data, int firstIndex, int numberToPartition) {
		int randomIndex = (int) Math.floor(Math.random() * ((firstIndex + numberToPartition - 1) - firstIndex + 1))
				+ firstIndex;
		String tempValue = data.get(randomIndex);
		data.set(randomIndex, data.get(firstIndex));
		data.set(firstIndex, tempValue);
	}

}
