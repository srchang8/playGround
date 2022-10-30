class Solution {
    /*
    
        time: nlogn + o(n^2)
        space: o(n)
        
        time complexity explanation:
        time: (fastest sort = n log n )+ (two pointer below o(n^2))
    
    */
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new LinkedList();
        if (nums.length == 0) return result;
        Arrays.sort(nums);
        
        int start = 0;
        int end = nums.length-1;
        
        for (int i=0; i<nums.length-2; i++){
            
            //check if the new iteration is the same as before
            //you cant do this when i==0 because theres nothing before it
            if (i != 0 && nums[i] == nums[i-1]) continue;
            
             start = i + 1;
             end = nums.length-1;
            
            while (start < end){
                if (nums[i] + nums[start] + nums[end] == 0){
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    
                    start++;
                    end--;
                    while (start < end && nums[start] == nums[start - 1]) start++;
                    while (start < end && nums[end] == nums[end + 1]) end--;
                    
                } else if (nums[start] + nums[end] + nums[i] > 0){
                    end--;
                }else{
                    start++;
                }
            }
        }
        
        return result;
    }
}