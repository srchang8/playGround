class Solution {
    /*
            
    - - - - -- - -Algorith: - - -- - - -- - - - -
           
           compare newInt 1 by 1 with each and decide on 3 possible procedures
           
           1. currInt comes before intervals y
           2. currInt comes after intervals y
           3. merge them
           
           
    -- - - - - - - Examples - - - - - - -- - -- - - - --
            [1,2],[3,5], [4,8], [6,7],[8,10],[12,16]
            
            [[1,2],[3,10],[12,16]]
            
            
            
             [1,2],[3,5], [6,7],[8,10],[12,16]
             
             [4,8],
            
            [1,2], 
            
        */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
            List<int[]> result = new ArrayList();
            int[] currInt = newInterval;
            
            for (int y=0; y<intervals.length; y++){
    
                //no overlap, currInt comes before intervals y
                if (currInt[1] < intervals[y][0]){
                    result.add(currInt);
                    currInt = intervals[y];
                    
                //no overlap currInt comes after intervals y
                }else if (currInt[0] > intervals[y][1]){
                    result.add(intervals[y]);
                    
                //overlap merge
                }else{
                    currInt[0] = Math.min(currInt[0], intervals[y][0]);
                    currInt[1] = Math.max(currInt[1], intervals[y][1]);
                }
            }
            result.add(currInt);
            
            return result.toArray(new int[result.size()][]);
        
    }
}
