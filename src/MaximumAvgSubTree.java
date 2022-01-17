/**
 * Leetcode 1120. Maximum Average Subtree
 * 
 * https://leetcode.com/problems/maximum-average-subtree/solution/
 * https://leetcode.com/discuss/interview-question/1031926/Amazonor-OA2or-New-Grad
 * 
 * DFS Tree
 * 
 * Bottom up approach or Post Order traversal
 */
public class MaximumAvgSubTree {
	
	public double maxAvg(TreeNode root) {
		return solve(root).avg;
	}

	private Summary solve(TreeNode root) {
		if(root == null)
			return new Summary(0, 0, 0);
		
		Summary left = solve(root.left);
		Summary right = solve(root.right);
		
		int sum = left.sum + right.sum + root.val;
		int count = left.count + right.count + 1;
		
		double maxAvg = Math.max((1.0 * sum) / count, Math.max(left.avg, right.avg));
		return new Summary(sum, count, maxAvg);
	}

	public static void main(String[] args) {

	}

}

class Summary{
	int sum;
	int count;
	double avg;
	
	Summary(int sum, int count, double avg){
		this.sum = sum;
		this.count = count;
		this.avg = avg;
	}
	
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
};
