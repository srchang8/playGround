class Solution {
   
    /*
        
         This is EXACT SAME as https://leetcode.com/problems/binary-tree-vertical-order-traversal/
         Except there will be nodes that are in the same y and x colum/row, you need to sort those
         
         
    sort by col first, row, if node on the same row and column then sort by smallest to greatest
    
    
     col  List<NodeInfo>
       -1, 9
        0, 3,15
        1  20
        2  7
        
    
    
    */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        //Map<col, List<nodes>
        Map<Integer,List<NodeInfo>> map = new TreeMap();//TreeMap! sorted keys
        Queue<NodeInfo> queue = new LinkedList();

        queue.add(new NodeInfo(root,0,0));
        
        while ( !queue.isEmpty() ) {
            NodeInfo n =  queue.poll();
            
            int col = n.col;
            
            if (n.node != null){
                
                if (!map.containsKey(col)){
                    map.put(col, new ArrayList());
                }
                map.get(col).add(n);
                
                queue.offer(new NodeInfo(n.node.left,n.col-1,n.row+1));
                queue.offer(new NodeInfo(n.node.right,n.col+1,n.row+1));
            }

          }
        
     
        //1. Sort by map keys( aka cols)
        List<Integer> keys = new ArrayList(map.keySet());
        Collections.sort(keys);

        
        //2.sort the list of nodes by VALUES
        for (Integer col : map.keySet()){
            List<NodeInfo> sortList = map.get(col);
            
            Collections.sort(sortList, new NodeInfoComparator());    
            
            //3. extract List<node> to List<Int>
            List<Integer> sortedList = new ArrayList();
            for (NodeInfo n : sortList){
                sortedList.add(n.node.val);
            }
            result.add(sortedList);
        }

        return result;
    }
    
    /***
    The map already stores the list in the way of {col,List}. Hence, col number is already taken care of.

    Now, within a list, we need to care about two things
        1. Depth should be in ascending order for ex: [3,1,4,0,2,2]
        2. If depth is same, make sure the lower number is first
    **/                                         
    public class NodeInfoComparator implements Comparator<NodeInfo> {
        public int compare(NodeInfo n1, NodeInfo n2){
            if(n1.row < n2.row) return -1;
            if(n1.row > n2.row) return 1;
            return n1.node.val - n2.node.val;
        }
    }
    
    class NodeInfo{
        private TreeNode node;        
        private int col; //(left decreasing. right increating)
        private int row; //Horizontal distancde from root (top to bottom increasing)
        
        public NodeInfo(TreeNode _node, int _col, int _row){
            this.node = _node;
            this.col = _col;
            this.row = _row;
        }
    }
}