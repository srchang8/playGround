/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        
        
        //understanding BS template 2
        //https://leetcode.com/explore/learn/card/binary-search/136/template-analysis/935/
        
        // 0  1 2 3 4 5
        // 0  0 0 1 1 1
        // L    M     R
        //        L M R
        //       LM R
        //       LMR
        
        //Template
        /*
            left = 0;
            right = nums.length-1;
            
            while (left < right){
                int mid = left + (right - left)/2;
                
                if (target is on the right of mid){
                    left = mid + 1;
                }else{
                    right = mid
                }
            }
            
            return left;
        */
        List<Integer> dim = binaryMatrix.dimensions();
        
        //[y,x]
        //y rows, x col
        int rows = dim.get(0);
        int cols = dim.get(1);
        
        //IMPORTANT: leftmost is all the way to the right starting
        int leftMost = cols;
        
        for (int i = 0; i<rows; i++){
            
            int left = 0;
            int right = cols-1;
            
            while (left < right){
                int mid = left + (right-left)/2;
                
                if (binaryMatrix.get(i, mid) != 1){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            
            //save only if smaller & not 00000
            if (binaryMatrix.get(i,left) == 1){
                leftMost = Math.min(leftMost, left);
            }
            
        }
        
        return leftMost == cols ? -1 : leftMost;
    }
}