
/*
    space: o(h)  h=height of tree
    time: o(n)

*/
class Solution {
    public Node treeToDoublyList(Node root) {
        
        if (root == null) return root;
        
        Node dummy = new Node(-1);
        
        
        Stack<Node> stack = new Stack();
        
        Node prev = dummy;
        
        while (!stack.isEmpty() || root != null){
            
            //left
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            
            //root
            root = stack.pop();
    
            prev.right = root; // prev -> root
            root.left = prev;  // prev  <- root
            prev = root;       
                
            //right
            root = root.right;
        }
        
        //dummy.right = 1
        //sow the head with tail, creating cycle
        dummy.right.left = prev;//    5 <- 1
        prev.right = dummy.right;// 5 -> 1
        
        return dummy.right;
        
    }
}
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/


/*

IMPORTANT: 
    - use prev node pointer
    - dont forget to sow the end


simple inorder traversal just need a prevNode
    
    -- 3 steps for prev Node --
    prevNode <- currNode
    prevNode -> currNode
    prevNode = currNode
    
    --Lastly create a cycle with last Node

*/
//Inorder on a BST will always give you sorted
//prev will end as the last node
//dummy is always used to point to head





