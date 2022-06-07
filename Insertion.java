package sortcomparison;

public class Insertion {

	public void insertionSort(String[] inputDatas, int startIndex, int elementsToSort) {

		String tempData;

		for (int i = startIndex + 1; i < startIndex + elementsToSort; i++) {
			tempData = inputDatas[i];
			int j = i;
			while (j > startIndex && tempData.compareTo(inputDatas[j - 1]) < 0) {
				inputDatas[j] = inputDatas[j - 1];
				j--;
			}
			inputDatas[j] = tempData;
		}
	}

}