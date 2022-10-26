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
       inorder to array is too slow probably, they want better
       
       since its BST, we can do an inorder
       
       IMPORTANT!!!: return prev for edge case
       [1]
       4.428571
       if only 1 number, that means that number is the closest to target

       
       - - - - - -- - - -- - - - - -- - - -- - 
       1. find the low and high (between which 2 nodes?) ex:
       
       low node = 3   target = 3.714286  high node = 4
       
       int prev        target            node.val
       
       - - - - - - - -- - - -- - - - - -- - - -- - 
       2. check whos closer
        
         absolute val of low node    vs.   absolute val of high nove
         
       
    
    */
    public int closestValue(TreeNode root, double target) {
        
        Stack<TreeNode> stack = new Stack();
        
        int prev = Integer.MIN_VALUE;
        
        while ( !stack.isEmpty() || root != null){
            
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            
            if (prev <= target && target < root.val){
                
                return Math.abs(prev - target) < Math.abs(root.val - target) ? prev : root.val;
            }
            
            prev = root.val;
            
            
            
            root = root.right;
        }
        
        /*
        [1]
        4.428571
        */
        return prev;
    }
}














