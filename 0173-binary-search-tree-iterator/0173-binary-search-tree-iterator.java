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

class BSTIterator {

    //same as iterative inorder
    //first while condition is the hasNext
    //inside the second while, thats the next
    Stack<TreeNode> stack;
    TreeNode node;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack();
        node = root;
        
    }
    
    public int next() {
        
        while(node != null){
            stack.push(node);
            node = node.left;
        }
        
        node = stack.pop();
        int val = node.val;
        
        node = node.right;
        
        return val;
    }
    
    public boolean hasNext() {
        
        if (!stack.isEmpty() || node != null) return true;
        return false;
    }
}


//
/*
//this does not pass follow up, need to do in o(h) memory
//h is the height of tree
class BSTIterator {

    List<Integer> result;
    private int next;
    
    public BSTIterator(TreeNode root) {
        //initializer
        
        result = new ArrayList();
        
        Stack<TreeNode> stack = new Stack();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            result.add(root.val);
            
            root = root.right;
        }
        
        if (!result.isEmpty()) next = 0;
        
    }
    
    public int next() {
        int val = result.get(next);
        if (next != result.size()) next++;
        return val;
        
    }
    
    public boolean hasNext() {
        //check if there is next
        
        int testNext = next;
        if (next == result.size()) return false;
        return true;
    }
}

*/

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */