import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://aonecode.com/amazon-online-assessment-oa2-shopkeeper-sale
 * Check Aditya Verma stack playlist
 * This problem is similar to finding NearestSmallestElementToRight
 */
public class ShopKeeperSale {
	
	private static void solve(int[] arr) {
		int n = arr.length;
		int smallestToRight[] = new int[n];
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=n-1;i>=0;i--) {
			
			int currentElement = arr[i];
			
			if(stack.isEmpty())
				smallestToRight[i] = -1;
			
			else if(stack.size() > 0 && stack.peek() <= currentElement) 
				smallestToRight[i] = stack.peek();
			
			else if(stack.size() > 0 && stack.peek() > currentElement) {
				
				while(stack.size() > 0 && stack.peek() > currentElement)
					stack.pop();
				
				if(stack.isEmpty())
					smallestToRight[i] = -1;
				else
					smallestToRight[i] = stack.peek();
				
			}
			
			stack.push(currentElement);
			
		}
		
//		for(int num : arr)
//			System.out.print(num + " ");
//		System.out.println();
//		for(int num : smallestToRight)
//			System.out.print(num + " ");
		
		int cost = 0;
		List<Integer> indexes = new ArrayList<>();
		for(int i=0;i<n;i++) {
			if(smallestToRight[i] == -1) {
				indexes.add(i);
				cost += arr[i];
			}
			else {
				cost += arr[i] - smallestToRight[i];
			}
		}
		
		System.out.println(cost);
		System.out.println(indexes);
		
	}

	public static void main(String[] args) {
		solve(new int[] {2, 3, 1, 2, 4, 2});	//8, {2, 5}
		solve(new int[] {5, 1, 3, 4, 6, 2});	//14, {1, 5}
		solve(new int[] {1, 3, 3, 2, 5});		//9, {0, 3, 4}
	}

}
