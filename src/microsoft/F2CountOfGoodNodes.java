package microsoft;

public class F2CountOfGoodNodes {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(5);
		
		System.out.println(goodNodes(root));
	}
	
	public static int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }
	
	public static int dfs(TreeNode root, int maxInPath) {
		if(root == null)
			return 0;
		
		int res = (root.val >= maxInPath) ? 1 : 0;
		
		res += dfs(root.left, Math.max(root.val, maxInPath));
		res += dfs(root.right, Math.max(root.val, maxInPath));
		
		return res;
					
	}
	

}

