public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideNodes = new ArrayList<>();
        dfs(root, rightSideNodes, 0);
        return rightSideNodes;
    }

    void dfs(TreeNode x, List<Integer> rightSideNodes, int level) {
        if (x == null) return;
        if (level == rightSideNodes.size()) {
            rightSideNodes.add(root.val);
        }
        dfs(root.right, rightSideNodes, level+1);
        dfs(root.left, rightSideNodes, level+1);
    }
}