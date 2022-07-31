class Solution {
    
    //      [4,    7,  9,10]
    // 1,2,3   5,6   8
    //                 9 - 3(start);
    //                   9-3 = 6 - index(num of elem up to this point) = 3 missing num
    // k > # missing num shift left over
    
    
    /*
        


[4,7,9,10]   k= 3   ans = 8     target = 4 + 3 = 7
   L      R
     M
   L R
   M
   
   7 
     7 + 2 - 1 = 8
     
     7 + 2 - 1 = 8
    */
    public int missingElement(int[] nums, int k) {
        
        int left = 1;
        int right = nums.length;
        
        //target is what we are seaching for, we basically need the target th number
        int target = nums[0] + k;
     
        
        while (left < right){
            int mid = left + (right-left)/2;
            if (nums[mid] <= target + mid - 1){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        
        //once we found the target, add the seen numbers(left) then off by 1 array
        return target + left - 1;
    }
}