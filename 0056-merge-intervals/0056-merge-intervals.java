class Solution {
    public int[][] merge(int[][] intervals) {
        
        
        /*
        
        Time: n log n for sort
        Space: o(logn) for sort + o(1)
        
        Facebook Follow-Up
Question: How do you add intervals and merge them for a large stream of intervals? (Facebook Follow-up Question)
            sort by first
            
            iterate through intervals
                check if merge?
                    merge
                        
                iterate next int
                add to result
                
        
        */
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
        
        List<int[]> result = new ArrayList();
        int[] currInt = intervals[0];
        result.add(currInt);
        
        for (int y=1; y<intervals.length; y++){
            
            if (currInt[1] >= intervals[y][0]){
                currInt[1] = Math.max(currInt[1], intervals[y][1]);
            }else{
                currInt = intervals[y];
                result.add(currInt);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}