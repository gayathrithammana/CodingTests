package fangHardBytechlead;
/**
 * Solved using pivot and swapping 
 * https://www.youtube.com/watch?v=QGVCnjXmrNg
 */

public class KthLargest {
	
	private static int kthLargest(int[] arr, int k) {
		int n = arr.length;
		int low = 0;
		int high = n - 1;
		while(low <= high) {
			int pivotIndex = partition(arr, low, high);
			if(pivotIndex == n - k)
				return arr[pivotIndex];
			else if(pivotIndex > n - k)
				high = pivotIndex - 1;
			else
				low = pivotIndex + 1;
		}
		return -1;
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int index = low;
		
		for(int i=low;i<high;i++) {
			if(arr[i] <= pivot) {
				swap(arr, i, index);
				index++;
			}
		}
		
		swap(arr, index, high);
		
		return index;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		System.out.println(kthLargest(new int[] {5, 7, 2, 3, 4, 1, 6}, 3));
	}

}
