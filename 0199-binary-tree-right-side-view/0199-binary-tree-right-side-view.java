/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    /*
        Time: o(n)
        Space: o(d) d = diameter of tree
    */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList();
        List<Integer> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        
        
        while (!queue.isEmpty()){
            
            int size = queue.size();
            for (int i=0; i<size; i++){
                
                TreeNode node = queue.poll();
                
                //only add the right side node aka the last node in the queue for each level
                if (i == size-1) result.add(node.val);
                
                if (node.left != null){
                    queue.offer(node.left);
                }
                
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
        }
     
        return result;
    }
}