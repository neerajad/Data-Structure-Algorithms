package neeraja.algo;

/**
 * 
 * @author neera
 *
 */
public class MergeSortAlgo {
	
	private int COMPCOUNT;
	
	public int[] callDivideAndMerge(int[] arr) {
		
		Long beforeTime = System.nanoTime();
		
		int[] sortedArr = DivideAndMergeArr(arr);
		
		Long afterTime = System.nanoTime();
		
		System.out.println("Total time taken = " + ((afterTime - beforeTime)/1E6) + " ms");
		System.out.println("Number of Key comparisons : COMPCOUNT = " + COMPCOUNT);
		
		return sortedArr;
	}
	
	/**
	 * This method divides the given array to two, sorts each halves separately, and then merge them
	 * @param arr
	 * @return
	 */
	public int[] DivideAndMergeArr (int[] arr) {
		
		if (arr.length == 1) {
			return arr;
		}
		
		int middleIndex = (arr.length/2) - 1;
		int[] leftArr = DivideAndMergeArr(createArr(0, middleIndex, arr));
		
		int[] rightArr = DivideAndMergeArr(createArr(middleIndex+1, arr.length-1, arr));
		
		int[] sortedArr = mergeArrays(leftArr,rightArr);
		
		return sortedArr;
	}
	
	/**
	 * This method creates left array and right array
	 * @param start
	 * @param end
	 * @param oldArr
	 * @return
	 */
	private int[] createArr(int start, int end, int[] oldArr) {
		int[] newArr = new int[end - start + 1];
		int index = 0;
		
		for (int i = start; i <= end; i++) {
			newArr[index] = oldArr[i];
			index ++;
		}
		return newArr;
	}
	
	/**
	 * This method merges two sorted arrays
	 * @param firstArray
	 * @param secArray
	 * @return
	 */
	public int[] mergeArrays(int[] firstArray, int[] secArray) {
		
		int[] sortedArr = new int[firstArray.length + secArray.length];
		int sortedIndex = 0;
		int firtArrIndex = 0;
		int secArrIndex = 0;
		
		while (firtArrIndex < firstArray.length || secArrIndex < secArray.length) {
			int smaller = 0;
			
			//If one of the array is completely copied, and there are elements still remaining in other array, directly copy those elements
			if (firtArrIndex >= firstArray.length) {
				sortedArr = copyRemainingElements(secArrIndex, secArray, sortedArr, sortedIndex);
				break;
			} else if(secArrIndex >= secArray.length) {
				sortedArr = copyRemainingElements(firtArrIndex, firstArray, sortedArr, sortedIndex);
				break;
			} else {
				// Compare elements in both array and copy the smallest to a new array to create a sorted array and increment pointer
				if (firstArray[firtArrIndex] < secArray[secArrIndex]) {
					smaller = firstArray[firtArrIndex];
					firtArrIndex++;
					COMPCOUNT++;
				} else {
					smaller = secArray[secArrIndex];
					secArrIndex++;
					COMPCOUNT++;
				}
				sortedArr[sortedIndex] = smaller;
				sortedIndex ++;
			}
		}
		return sortedArr;
	}
	
	/**
	 * This method directly copies the remaining elements to the sorted array since it is already sorted
	 * @param arrIndex
	 * @param array
	 * @param sortedArr
	 * @param sortArrIndex
	 * @return the merged array
	 */
	private static int[] copyRemainingElements(int arrIndex, int[] array, int[] sortedArr, int sortArrIndex) {
		
		for (int  i = arrIndex; i < array.length; i++) {
			sortedArr[sortArrIndex] = array[i];
			sortArrIndex++;
		}
		return sortedArr;
	}
	
	
}
