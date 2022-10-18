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
    
        space: o(n)
        time:  o(n)
    */
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        Stack<TreeNode> stack  = new Stack();
        stack.push(root);
        
        int sum = 0;
        
        while (!stack.isEmpty()){
            
            TreeNode node = stack.pop();
            if (node == null) continue;
            
            if (node.val >= low && node.val <= high) sum += node.val;
            
            if (node.val > low) stack.push(node.left);
            if (node.val < high) stack.push(node.right);
        }
     
        return sum;
    }
}

//inorder to array is too easy. interviwer wants  O(h) space where h is tree hight
    /*
    
    Instead of Inorder we use ROOT LEFT RIGHT
    
    Root Left Right
    make decisions based on root
    

    
    IMPORTANT: root left right, traversing depending on root value
    
    low = 7 high = 15
    
    10 > low = go left, possible numbers to add
    vice versa right
    10 < high = go right, possible numbers to add
    
   
    */

/*

recursive for fun
class Solution {
    
    int sum = 0;
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        sum(root, low, high);
        return sum;
    }
    
    public void sum(TreeNode root, int low, int hi){
        
        if (root == null) return;
        
        if (root.val >= low && root.val <= hi){
            sum += root.val;
        }
        
        if (root.val >= low){
            sum(root.left, low, hi);
        }
        
        if (root.val <= hi){
            sum(root.right, low, hi);
        }
    }
}

*/







