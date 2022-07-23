class Solution {
    public int findPeakElement(int[] nums) {
        
        
        /*
        
        search for / until doesnt /
        search for \ now
        
        
        
        IMPORTANT: BS works because the "ledges" [ and ] are considered to be negative
        
        we assume no duplicates next to each other. we will never get [1,2,2,3]
        
        nums[mid] < nums[mid+1]
        
        search for / if \ then we complete /\
        if / / then keep searching for \
        
        [5,1,1]
        [1,1,5]
        
        */
        
        
        //BS template 2
        
        //think about invariants
        // left - 1 < left && right > right + 1
        
        //invariant
        //nums[left-1] < nums[left] ------- nums[right] > nums[right + 1]
        //left LEFT right r..
        //..l LEFT RIGHT
        // . . .. . . l LEFT
        
        //if / then we check for \ or /
        //if \ we complete /\ else if / /, then we keep searching
        
        int left = 0;
        int right = nums.length-1;
        
        while (left < right){
            int mid = left + (right - left)/2;
            if (nums[mid] < nums[mid+1]){
                left = mid + 1;
            }else{
                right = mid;
            }
            
        }
        return left;
    }
}

/*

explanation on why it works

Binary search works here because we need to return any local peak, not necessarily the global peak.
Therefore, say we take the middle value. If the number to its left is smaller than it, then if the number to its right is also smaller than it, the middle value is a local peak. If the number to its right is higher than the middle value, then somewhere on the right there must be a peak - either the numbers ascend and then descend, in which case there would be a peak where the change from ascent to descent happens, or the numbers continue to ascend until the end of the array, in which case the last value in the array would be a local peak.
The same with the other way. If the value on the left on the middle value is bigger than the middle value, then it must be that either the middle value itself is a peak or that there is definitely a peak on the left side of the middle value. This is because if the number on the left is bigger than the middle value, there are two options: either the numbers continue ascending in the left direction until the end, in which case the first value of the array would be a peak, or the values increase to the left until a point at which they start decreasing, and that point would be a peak.

So by seeing what happens at the middle and choosing the continuation accordingly, we can be sure to eventually arrive at a peak.

*/


