/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        
        /*
        
        Time: o(n)
        Space: o(n)
        
        
        IMPORTANT: its guaranteed that P and Q will exist in tree
        
        LCA - you want the deepest node
        */
        if (root == null) return root;
        
        //child, parent
        HashMap<TreeNode, TreeNode> parentMap = new HashMap();
        
        //use queue when doing bfs, level traversal
        //we can make stack work too
        Queue<TreeNode> queue = new LinkedList();
        
        parentMap.put(root, null);
        queue.offer(root);
        
        while(!parentMap.containsKey(p) || !parentMap.containsKey(q)){
            
            TreeNode node = queue.poll();
            
            if (node.left != null){
               parentMap.put(node.left, node);
               queue.offer(node.left);
            }
            if (node.right != null){
               parentMap.put(node.right, node);
               queue.offer(node.right);
            }
   
        }
        
        
        // using less space slow and fast runner
        TreeNode pStart = p;
        TreeNode qStart = q;
        
        while (p != q){
            p = parentMap.get(p) == null ? qStart : parentMap.get(p);
            q = parentMap.get(q) == null ? pStart : parentMap.get(q);
        }
        
        return p;
        
        //we add q itself because q can also be the LCA
//         HashSet<TreeNode> qAncestors = new HashSet();
//         while (q != null){
//             qAncestors.add(q);
//             q = parentMap.get(q);
//         }
        
//         //iterate through p ancestors until we find common one
//         //the order is least because map goes child up parent, so it will always check from bottom up
//         while (!qAncestors.contains(p)){
//             p = parentMap.get(p);
//         }
        
        
        
//         return p;
    }
}

