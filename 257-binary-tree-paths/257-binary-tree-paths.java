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
    Space: o(n)
    
    IMPORTANT: sb is global even if you pass it through function
    
    To make algo simpler:
        only when not a leaf node we add node.val ->


    we need to use sb len because of unknown size like negative nums:
    [37,-34,-48,null,-100,-100,48,null,null,null,null,-54,null,-71,-22,null,null,null,8]


    Algo:
        0.Trick part is deleting -> within recursion
            use int len for before append so we can remove "5->"
        1. use StringBuilder to build 1->2->5 and remove last as needed
            Need to remove leaf and non leaf nodes
            
            1
            
        2       3
        
           5
        
        -- we need to remove 2 after processing 5
        
        
        2. go until we find base case aka leaf Node  node.left == null && node.right == null
        3. write 5, remove 5
        
        Idea: some kind of 
        root
        left
        right
        
        
        IMPORTANT: stringBuilder.delete(fromIndex, toIndex) since we have "->"
        
    
    */
    
    StringBuilder sb;
    List<String> res;
    
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList();
        sb = new StringBuilder();
        
        getPaths(root);
        
        return res;
        
    }
    
    public void getPaths(TreeNode node){
        
        if (node == null) return;
        
        //length before append, makes it easy to remove "5->"
        int len = sb.length();
        
        //reach an end
        if (node.left == null && node.right == null){
            sb.append(node.val);
            res.add(sb.toString());
            
            sb.delete(len, sb.length());
            return;
        }
        
        
        sb.append(node.val + "->");
        getPaths(node.left);
        getPaths(node.right);
        
        //remove 2 after left and right
        sb.delete(len, sb.length());
    }
}

/*
iteratively BFS

public class Solution {
//BFS - Queue
public List<String> binaryTreePaths(TreeNode root) {
    List<String> list=new ArrayList<String>();
    Queue<TreeNode> qNode=new LinkedList<TreeNode>();
    Queue<String> qStr=new LinkedList<String>();
    
    if (root==null) return list;
    qNode.add(root);
    qStr.add("");
    while(!qNode.isEmpty()) {
        TreeNode curNode=qNode.remove();
        String curStr=qStr.remove();
        
        if (curNode.left==null && curNode.right==null) list.add(curStr+curNode.val);
        if (curNode.left!=null) {
            qNode.add(curNode.left);
            qStr.add(curStr+curNode.val+"->");
        }
        if (curNode.right!=null) {
            qNode.add(curNode.right);
            qStr.add(curStr+curNode.val+"->");
        }
    }
    return list;
}}


*/







