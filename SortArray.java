package neeraja.algo;

import java.util.Random;

public class SortArray {

	/**
	 * This method creates a random array
	 * @return randomly generated array
	 */
	public static int[] generateRandomArr(int size) {
		
		int[] randomArr = new int[size];
		Random random = new Random();
		int index = 0;
		
		for (int i = 0; i < size; i++) {
			randomArr[index] = random.nextInt(size);
			index++;
		}
		return randomArr;
	}
	
	/**
	 * Display the sorted array
	 * @param sortedArr
	 */
	private static StringBuffer displaySortedArr(int[] sortedArr) {
		
		StringBuffer sb = new StringBuffer("[");
		
		for (int i = 0 ; i< sortedArr.length; i++) {
			sb.append(sortedArr[i] + ", ");
			sb.append("\n");
		}
		sb.delete(sb.length() - 2, sb.length());
		sb.append("]");
		
		return sb;
	}
	
	public static void main(String[] args) {
		
		// Generate a random array of size 32 to sort. Change 32 to 1024, 32768 or 1048576 to generate random array of those size for part 2 of question
		int[] arr = generateRandomArr(32);
		
		// Comment the above line and uncomment one of below lines to give sorted array or reversely sorted array as input
		//int[] arr = {18, 24, 0, 14, 17, 9, 13, 1, 19, 20, 15, 13, 14, 8, 11, 3, 22, 4, 20, 18, 6, 2, 17, 20, 5, 9};
		//int[] arr = {32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
		
		//System.out.println("Input Array is " + displaySortedArr(arr));
		
		// Sort array by merge sort algorithm
		MergeSortAlgo mergeSortAlgo = new MergeSortAlgo();
		int[] mergeSortedArr = mergeSortAlgo.callDivideAndMerge(arr);
		System.out.println("Array after Merge sort is " + displaySortedArr(mergeSortedArr));
		
		// Sort array by Heap Sort algorithm
		HeapSortAlgo heapSortAlgo = new HeapSortAlgo();
		int[] heapSortedArr = heapSortAlgo.callBuildHeap(arr);
		System.out.println("Array after Heap sort is " + displaySortedArr(heapSortedArr));
		
		// Sort array by Quick Sort algorithm
		QuickSortAlgo quickSortAlgo = new QuickSortAlgo();
		int[] quickSortedArr = quickSortAlgo.quickSort(arr);
		System.out.println("Array after Quick sort is " + displaySortedArr(quickSortedArr));
		
	}
	
}
