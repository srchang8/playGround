class Solution {
    public int[] findBuildings(int[] heights) {
        
        
        int max = heights[heights.length-1];
        List<Integer> result = new ArrayList();
        result.add(heights.length-1);
        
        
        for (int i=heights.length-2; i>=0; i--){
            
            if (heights[i] > max){
                max = heights[i];
                result.add(i);
            }
            
        }
        
        int[] res = new int[result.size()];
        int count = result.size()-1;
        for (Integer i : result){
            res[count--] = i;
        }
        
        return res;
    }
}