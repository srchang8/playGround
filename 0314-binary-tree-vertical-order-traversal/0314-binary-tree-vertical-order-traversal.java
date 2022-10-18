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
    
    Level traversal give it in order already
    
    NodeInfo storing row makes this code more reusable
    
    Really good question, basically have access to all nodes
    
    General BFS traversal using queue
    Algo: traverse left = col - 1, traverse right = col + 1
    
    Map< col List<Integer>
    TreeMap = sorted key;
    
   -1 9
    0 3,15
    1 20
    2 7
    
    
    */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        
        if (root == null) return new ArrayList();
        Map<Integer, List<Integer>> map = new TreeMap();
        Queue<NodeInfo> queue = new LinkedList();
        queue.offer(new NodeInfo(root, 0, 0));
        
        while (!queue.isEmpty()){
            NodeInfo nI = queue.poll();
            
            int col = nI.col;
            
            if (!map.containsKey(col)) map.put(col, new ArrayList());
            map.get(col).add(nI.node.val);
            
            if (nI.node.left != null) {
                queue.offer(new NodeInfo(nI.node.left, nI.col-1, nI.row+1));
            }
            
            if (nI.node.right != null){
                queue.offer(new NodeInfo(nI.node.right, nI.col+1, nI.row+1));    
            }
            
        }
        
        //to sort
        List<Integer> sortedKeys = new ArrayList(map.keySet());
        Collections.sort(sortedKeys);
        
        //since level travesal, map keys will be sorted already but not guaranteed
        List<List<Integer>> result = new ArrayList();
        for (Integer col :sortedKeys){
            List<Integer> nList = map.get(col);
            result.add(nList);
        }

        return result;
    }
    
    
    class NodeInfo {
        TreeNode node;
        int col;
        int row;
        public NodeInfo(TreeNode n, int c, int r){
            this.node = n;
            this.col = c;
            this.row = r;
        }
    }
}