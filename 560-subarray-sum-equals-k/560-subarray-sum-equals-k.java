class Solution {
    
    /*
     1,2,3
     1,3,6
        
         6            -  3  then theres a sum == k
        cumulativeSum - currSum == k then count++
     
     time: o(n)
     space: o(n)
     
    https://www.youtube.com/watch?v=fFVZt-6sgyo
    
    
 
    */
    public int subarraySum(int[] nums, int k) {
        
        //currSum, num of occur    -- counting sums
        HashMap<Integer, Integer> map = new HashMap();
        
        map.put(0, 1);
        
        int currSum = 0;
        int count = 0;
        
        for (int i=0; i<nums.length; i++){
            currSum += nums[i];
            
            //is there something we can chop to make k
            int missingSum = currSum - k;
            
            if (map.containsKey(missingSum)){
                count += map.get(missingSum);
            }
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        
        return count;
    }
}


/*
    
    https://www.youtube.com/watch?v=fFVZt-6sgyo
 Similar to 3 sum, we found sum when currSum - k == 0
    [3,4,7,2,-3,1,4,2]
    
    [3,4]
    [7]
    [3,7,-3]
    [1,4,2]
    
    Map<currSum, num of occurance >
    
    currSum - k = 0 --- we increase count
    14 - k = 7 -- search 7
    
    - - - - - - trace - - -
    [3,4,7,2,-3,1,4,2]  k = 7
    
    0,1
    3,1
    7,1
    14,1
    
    count = 2

*/



/*
- - - - - - -- new Explanation - - - -- - - -- - 

    k = 26
                                                    
    sum - k = 76 - 26 = 50, search for 50
    
    index 14-16 sum = 26
    index 11-16 sum = 26
    basically currSum = 76, what can we chop to make 26
                        10    
    [0,0,0,0,0,0,0,0,0, 0 , 8 , -5 , -3 , 10, 15 , 1 ]
                        50           50            76  




- - - - - -- old notes - - - -- - -- - 


 [1,2,3]
    [0,1,3,6]
    
    1 1
    3 1
    6 1
    */
    /*
    think [1,1,1]
    similar to 2 sum, you search backward for missingSum
    
    1. count rolling sum
    
               [1,1,1] k=2
 rolling sum  0,1,2,3
                  
                  found sum 2
    
    
    2. keep track of old sums
                 [1,1,1] k=2
   rolling sum  0,1,2,3
            look backwards
              3 - k = 1
              
              
    3. just keep adding to count
    
    HashMap<rollingSum, num of Sum>
    
    
     - -- - - -- - -- - -- - -- - - - 
     
*/










