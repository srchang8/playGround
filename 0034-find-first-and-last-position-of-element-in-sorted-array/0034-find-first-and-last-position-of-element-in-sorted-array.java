class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        
        //BS template 2
        //https://leetcode.com/explore/learn/card/binary-search/136/template-analysis/935/
        
        //in BS we can choose to just shrink R or L
        //to find left most, we keep shrinking R when its == or <
        int[] result = {-1,-1};
        if (nums.length == 0 || nums == null) return result;
        
        
        int left =0;
        int right =nums.length-1;
        
        
        
        while (left < right){
            
            int mid = left + ((right - left)/2);
            
            //left will move until it finds the first occurence from left
            //left will basically move 1 by 1 until it finds first occurrence
            //traverse left until we find first occurence
            //once left is at its first occurrence, it will not move,
            //right will keep shrinking and shrinking until left==right
            if (target > nums[mid]){
                left = mid + 1;
            }else{
                //if right >= target, shift right <-
                right = mid;
            }
        }
        
        if (nums[left] != target) return result;
        
        result[0] = left;
        
        left = 0;
        right = nums.length-1;
        
        while (left < right){
            
            //we mid + 1 because mid is usually offset to the left by 1
            //in this case we want to do right
            int mid = left + ((right-left)/2) + 1;
            
            if (target < nums[mid]){
                right = mid - 1;
            }else{
                left = mid;
            }
        }
        //remember when we do left < right
        //left == right
        //we can do result[1] = right or left
        result[1] = right;
        return result;
    }
}