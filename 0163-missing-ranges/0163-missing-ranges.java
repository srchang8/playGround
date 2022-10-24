class Solution {
    
    /**
    trick test
    [1,3]
    0
    9
    
    Dont forget empty nums, just return range
    
    nums = [1,3,50,75]    lower = 0    upper = 99
    
     - - - -- - 4 gaps you need to fill - - - -
     
     lower -> [1,3,50,75] -> upper
     
    lower -> first nums     | gaps -> between nums |    last nums -> upper
    
    4th case is empty nums
    
 -- - - - - - - - -- - - - - - -- - - -- - -- -- - -- - -- - -- 
 
    IMPORTANT: include lower and upper but not nums!!
    
    
          [4,    50,      75]
      2                            99
        2,3  5,49    51,74    76,99
    
    
    **/
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        List<String> result = new ArrayList();
        
        //empty
        if (nums.length == 0){
            result.add(getRange(lower, upper));
            return result;
        }
        
        
        //include lower but not first nums
        if (nums[0] > lower){
            result.add(getRange(lower, nums[0]-1));
        }
        
        //get middle ranges but do not include nums
        for (int i=0; i<nums.length-1; i++){
            if (nums[i] < nums[i+1]-1){
                result.add(getRange(nums[i]+1, nums[i+1]-1));
            }
        }
        
        //do not include last num but do include upper
        if (nums[nums.length-1] < upper){
            result.add(getRange(nums[nums.length-1] + 1, upper));
        }
        
        return result;
        
    }
    
    /*
        function is really to string
        
        test -> [1,3]  input -> [2]  output -> [2]
        
        test -> [3,50] input -> [4,49]  ouput -> [4,49]
        
    
    */
    public String getRange(int lower, int higher){
        
        if (lower == higher) return Integer.toString(lower);
        
        return Integer.toString(lower) + "->" + Integer.toString(higher);
    }
}