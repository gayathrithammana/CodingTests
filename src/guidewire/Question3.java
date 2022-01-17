package guidewire;

public class Question3 {
	
	public static int[] solution(int n) {
		int[] ans = new int[n];
		int len = n;

		for (int i = 0; i < len - 1; i += 2) {
			ans[i] = n;
			ans[i + 1] = -n;
			n--;
		}

		if (len % 2 != 0)
			ans[len - 1] = 0;

		return ans;
	}

	public static void main(String[] args) {
		int[] arr = solution(4);
		for(int i:arr)
			System.out.print(i + " ");
	}

}
