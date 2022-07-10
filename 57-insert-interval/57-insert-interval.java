class Solution {
    /*
    
    kind of similar to merge but not really
            
    - - - - -- - -Algorith: - - -- - - -- - - - -
           
           compare prevInt with currInt 1 by 1 with each and decide on 3 possible procedures
           
           1. prevInt comes before curr
                add to result
                set new prevInt
           2. prevInt comes after curr
           3. merge them
           
           
    -- - - - - - - Examples - - - - - - -- - -- - - - --
            [1,2],[3,5], [4,8], [6,7],[8,10],[12,16]
            
            [[1,2],[3,10],[12,16]]
            
            
            
             [1,2],[3,5], [6,7],[8,10],[12,16]
             
             [4,8], [3,10]
            
            [1,2], 
            
        */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> result = new ArrayList();
        
        int[] prevInt = newInterval;
        
        for (int[] currInt : intervals){
            
            //no overlap, currInt comes first
            if (currInt[1] < prevInt[0]){
                result.add(currInt);
            
            //no overlap, prevInt comes first
            }else if (prevInt[1] < currInt[0]){
                result.add(prevInt);
                prevInt = currInt;
            //merge
            }else{
                prevInt[0] = Math.min(prevInt[0], currInt[0]);
                prevInt[1] = Math.max(prevInt[1], currInt[1]);
            }
        }
            
        result.add(prevInt);
        return result.toArray(new int[result.size()][]);
        
    }
}
