package neeraja.algo;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * @author neera
 *
 */
public class QuickSortAlgo {

	private int COMPCOUNT;
	
	/**
	 * This method calls method where quick sort logic resides
	 * @param mainArr
	 * @return
	 */
	public int[] quickSort(int[] mainArr) {
		Long beforeTime = System.nanoTime();
		int[] sortedArr = sortArray(mainArr, 0, mainArr.length-1);
		
		Long afterTime = System.nanoTime();
		
		System.out.println("Total time taken = " + ((afterTime - beforeTime)/1E6) + " ms");
		System.out.println("Number of Key comparisons : COMPCOUNT = " + COMPCOUNT);
		 
		return sortedArr;
	}
	
	/**
	 * This method picks a random pivot and sort both sides of pivot and then sorts each side recursively
	 * @param mainArr
	 * @param left
	 * @param right
	 * @return
	 */
	public int[] sortArray(int[] mainArr, int left, int right) {
		
		if (left >= right) {
			return mainArr;
		}
		
		// Pick a random pivot
		int pivotIndex = ThreadLocalRandom.current().nextInt(left, right + 1);
		
		// Swap pivot element and first element and pivot
		swapElemets(mainArr, left, pivotIndex);
		
		int pivot = mainArr[left];
		int lPointer = left + 1;
		int rPointer = right;
		
		while (lPointer <= rPointer) {
			
			// call compare method where each element is compared with pivot on both sides
			lPointer = compare(lPointer, rPointer, mainArr, pivot, "Left");
			rPointer = compare(lPointer, rPointer, mainArr, pivot, "Right");
			
			if (lPointer < rPointer) {
				// Swap element less than pivot to left side of array from right side and element more than pivot to right side from left side
				swapElemets(mainArr, lPointer, rPointer);
				lPointer++;
				rPointer--;
			}
		}
		// swap pivot element from first position to its original position
		swapElemets(mainArr, left, rPointer);
		
		// Sort each side recursively
		sortArray(mainArr, left, rPointer-1);
		sortArray(mainArr, rPointer + 1, right);
		
		return mainArr;
	}
	
	/**
	 * This method compares each element to pivot and moves the pointer accordingly
	 * @param lPointer
	 * @param rPointer
	 * @param mainArr
	 * @param pivot
	 * @param left
	 * @return
	 */
	private int compare(int lPointer, int rPointer, int[] mainArr, int pivot, String left) {
		
		COMPCOUNT++;
		
		if ("Left".equals(left)) {
			// Increment the pointer and move to next element as long as element is less than pivot
			while (lPointer <= rPointer && mainArr[lPointer] <= pivot) {
				lPointer++;
			}
			return lPointer;
		} else {
			// Decrement the pointer and move to previous element as long as element is greater than pivot
			while (lPointer <= rPointer && mainArr[rPointer] >= pivot) {
				rPointer--;
			}
			return rPointer;
		}
	}
	
	/**
	 * This element swaps the given elements in the provided array
	 * @param array
	 * @param firstElementIndex
	 * @param secElementIndex
	 * @return
	 */
	private int[] swapElemets(int[] array, int firstElementIndex, int secElementIndex) {
		int temp = 0;
		
		temp = array[firstElementIndex];
		array[firstElementIndex] = array[secElementIndex];
		array[secElementIndex] = temp;
		
		return array;
	}
	
}
