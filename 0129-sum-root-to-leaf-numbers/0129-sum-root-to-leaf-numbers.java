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

/*


    Time: o(n)
    space: o(h)
    
algo: traverse from top down 
        4,9,5
        4,9,1
        4,0
        
        this is root left right = preOrder
        
        keep going ROOT, until left leaf , then go up, then right
    */
    // to achive currSum * 10 + root.val
    // 4 9 5
    //you want to hit root first, then left then right
    //inorder = left root right
    //preOrder = root left right
    //postOrder = left right root

class Solution { 
    
    int sum;
    public int sumNumbers(TreeNode root) {
        
     sum = 0;
     preOrder(root, 0);
     return sum;  
    }
    
    //root, left, right
    
    public void preOrder(TreeNode node, int currSum){
        
        if (node == null) return;
        
        //create the sum 4 * 10 = 40+ 9 = 49... until 495
        currSum = currSum * 10 + node.val;
        
        //sum only if you have reached bottom
        if (node.left == null && node.right == null){
            sum += currSum;  
            return;
        } 
        
        
        //495 
        preOrder(node.left, currSum);
        
        //491
        preOrder(node.right, currSum);
        
    }
}









