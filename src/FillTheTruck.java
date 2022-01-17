import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://aonecode.com/interview-question/load_cargo
 * https://algo.monster/problems/fill_the_truck
 * 
 * https://leetcode.com/discuss/interview-question/1065561/Amazon-OA-2021-Question
 * 
 * Leetcode 1710. Maximum Units on a Truck
 * https://leetcode.com/problems/maximum-units-on-a-truck/
 * 
 * Use MaxHeap to keep largest units at top
 * step1: add all pairs to maxHeap
 * step2: pick top pair(with largest units)
 * step3: add to result and remove top pair
 */

public class FillTheTruck {
	
	private static int findMax(int num, int[] boxes, int unitsSize, int[] unitesPerBox, int truckSize) {
		//keep larger units in heap
		Queue<MaxHeapPair> maxHeap = new PriorityQueue<MaxHeapPair>(new MaxHeapPair());

		for (int i=0;i<num;i++) {
			maxHeap.add(new MaxHeapPair(unitesPerBox[i], boxes[i]));
		}
		
		int limit = truckSize;
		int result = 0;
		//add remaining elem left in heap
		while (!maxHeap.isEmpty() && limit > 0){
			MaxHeapPair pair = maxHeap.poll();
			System.out.println(pair.key + " " + pair.value + " ");
			if(pair.value > limit)		//suppose last entry units exceeds limit
				result += pair.key * limit;
			else
				result += pair.key * pair.value;
			
			limit -= pair.value;
		}
		
		return result;
	}

	public static void main(String[] args) {
		System.out.println(findMax(3, new int[] {1, 2, 3}, 3, new int[] {3, 2, 1}, 3));
		System.out.println(findMax(3, new int[] {3, 1, 2}, 3, new int[] {1, 2, 3}, 4));
	}

}

class MaxHeapPair implements Comparator<MaxHeapPair> {
	int key; // units per box
	int value; // boxes

	MaxHeapPair() {

	}

	MaxHeapPair(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public int compare(MaxHeapPair p1, MaxHeapPair p2) {
		return p2.key - p1.key;		//min heap

	}

	public String toString() {
		return String.valueOf(key);
	}

}
