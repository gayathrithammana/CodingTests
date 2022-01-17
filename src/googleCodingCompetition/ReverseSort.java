package googleCodingCompetition;
class ReverseSort {
	
	private static int cost(int N, int[] arr) {
		int cost = 0;
		for(int i=0;i<N-1;i++) {
			int j = findMinPosition(i, N, arr);
			reverse(i, j+1, arr);
			cost += j-i+1;
		}
		for(int num : arr)
			System.out.println(num);
		return cost;
	}
	
	private static int findMinPosition(int i, int N, int[] arr) {
		int min = arr[i];
		int position = i;
		for(int j=i;j<N;j++) {
			if(arr[j] < min) {
				min = arr[j];
				position = j;
			}
		}
		System.out.println("position = " + position);
		return position;
	}
	
	private static void reverse(int start, int end, int[] arr) {
		for(int i=start;i<end/2;i++) {
			int temp = arr[i];
			arr[i] = arr[end-i-1];
			arr[end-i-1] = temp;
		}
//		System.out.println("after reversing");
//		for(int num : arr)
//			System.out.println(num);
	}

	public static void main(String[] args) {
//		System.out.println(cost(4, new int[] {4, 2, 1, 3}));			//6
//		System.out.println(cost(2, new int[] {1, 2}));					//1
//		System.out.println(cost(7, new int[] {7, 6, 5, 4, 3, 2, 1}));	//12
//		System.out.println(cost(1, new int[] {1}));						//0
		System.out.println(cost(10, new int[] {7, 6, 5, 4, 3, 2, 1, 10, 9, 8}));
	}

}
