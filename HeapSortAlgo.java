package neeraja.algo;

/**
 * 
 * @author neera
 *
 */
public class HeapSortAlgo {
	private int COMPCOUNT;
	
	/**
	 * This method creates a max heap and then sort the array
	 * @param mainArr
	 * @return
	 */
	public int[] callBuildHeap(int[] mainArr) {
		Long beforeTime = System.nanoTime();
		
		// Create a max heap
		int[] maxHeap = buildHeap(mainArr, mainArr.length, 1);
		// Sort the array
		int[] sortedArr = sortArrInAsc(maxHeap, maxHeap.length);
		
		Long afterTime = System.nanoTime();
		
		System.out.println("Total time taken = " + ((afterTime - beforeTime)/1E6) + " ms");
		System.out.println("Number of Key comparisons : COMPCOUNT = " + COMPCOUNT);
		
		return sortedArr;
	}
	
	/**
	 * This method builds max heap and does push down
	 * @param mainArr
	 * @param arrSize
	 * @param node
	 * @return
	 */
	public int[] buildHeap(int[] mainArr, int arrSize, int node) {
		
		if (2*node > arrSize) {
			return mainArr;
		}
		// Recursive call to create left heap
		buildHeap(mainArr, arrSize, 2*node);
		// Recursive call to create right heap
		buildHeap(mainArr, arrSize, 2*node + 1);
		// Pushdown the node to satisfy max heap property
		pushDown(mainArr, arrSize, node);
		
		return mainArr;
	}
	
	/**
	 * This method sorts the array in assenting order
	 * @param maxHeapArr
	 * @param arraySize
	 * @return
	 */
	private int[] sortArrInAsc(int[] maxHeapArr, int arraySize) {
		
		if (arraySize == 1) {
			return maxHeapArr;
		}
		
		int temp = 0;
		
		// Swap first and last element
		temp = maxHeapArr[0];
		maxHeapArr[0] = maxHeapArr[arraySize - 1];
		maxHeapArr[arraySize - 1] = temp;
		
		// Pushdown the first element to satisfy max heap property
		maxHeapArr = pushDown(maxHeapArr, arraySize - 1, 1);
		
		sortArrInAsc(maxHeapArr, arraySize - 1);
		return maxHeapArr;
	}
	
	private int[] pushDown(int[] mainArr, int arrSize, int node) {
		
		int largerVal = 0;
		
		if (2 * node > arrSize) {
			return mainArr;
		}
		
		if ((2 * node == arrSize) || mainArr[2 * node - 1] > mainArr[2 * node]) {
			largerVal =  2 * node - 1;
			COMPCOUNT++;
		} else {
			largerVal =  2 * node;
			COMPCOUNT++;
		}
		
		if (mainArr[node-1] < mainArr[largerVal]) {
			int temp = mainArr[node-1];
			mainArr[node-1] = mainArr[largerVal];
			mainArr[largerVal] = temp;
			COMPCOUNT++;
			
			pushDown(mainArr, arrSize, largerVal + 1);
		} else {
			COMPCOUNT++;
		}
		
		return mainArr;
	}
	
}
