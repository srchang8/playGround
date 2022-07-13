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

class Solution {
    public Node treeToDoublyList(Node root) {
        
        if (root == null) return root;
        
        Stack<Node> stack = new Stack();
        
        Node dummy = new Node(-1);
        dummy.right = root;
        Node prevNode = dummy;
        
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            
            prevNode.right = root;
            root.left = prevNode;
            
            prevNode = root;
            
            
            root = root.right;
        }
        
        prevNode.right = dummy.right;
        dummy.right.left = prevNode;
        
        return dummy.right;
    }
}