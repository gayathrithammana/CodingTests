package microsoft.OA;
/**
 * https://leetcode.com/discuss/interview-question/546683/OA-Microsoft-2020
 * https://leetcode.com/discuss/interview-question/306379/dropbox-quality-engineer-phone-screen
 * A[0] = 1
A[1] = 4
A[2] = -1
A[3] = 3
A[4] = 2
- Head has value of 1
- 1 has value of 4
- 4 has value of 2
- 2 has value of -1 which ends the LL

Finding the length of a linked list, given the head.
 */

public class ArrayIndexedLinkedList {
	
	private static int solve(int a[]) {
		if (a == null || a.length == 0 || a[0] == -1)
            return 0;

        int count = 0;
        int index = a[0];
        while (index != -1) {
            index = a[index];
            count++;
        }
        return count;
	}

	public static void main(String[] args) {
		System.out.println(solve(new int[] {1, 4, -1, 3, 2}));	//3
	}

}
