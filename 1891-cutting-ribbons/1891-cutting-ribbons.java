class Solution {
    
    
    /*
    
    speed: n log(max length)
    space: o(1)
    
    
    similar to find first bad version, but you have to write your own function
    
    Algorithm:
    
        1. find if any length is a possible cut
        2. after a possible cut, try to find the largest, possible cut
        
        use binary search to find a range of possible cuts
        if possible, try to find bigger by shifting left
        if not possible, try finding smaller by shifting right
    
    
    
    
    find first possible answer from the right
    
    5 , 7, 9,   k = 3


    1 2 3 4 5 6 7 8 9
    L       M       R

    1 2 3 4 5 6 7 8 9
              L M   R

    1 2 3 4 5 6 7 8 9
              L MR  

    1 2 3 4 5 6  7 8 9
              LM R

    1 2 3 4 5  6  7 8 9
              LMR

    
    */
     public int maxLength(int[] ribbons, int k) {
        
         
        //find max length
        int max = 0;
        for (int i=0; i<ribbons.length; i++){
            max = Math.max(ribbons[i], max);
        }
        
        int left = 1;
         
         //+ 1 to search within bounds when max is given
         /*
         [10,10,10]
            3
         
         */
        int right = max+1;
        
        while (left < right){
            
            //lenth candidate
            int mid = left +(right-left)/2;
            
            //not possible cut? then keep shorting the length
            if (!canCut(ribbons, mid, k)){
                right = mid;
                
            //possible cut, try to see if we can find bigger
            }else{
                left = mid + 1;
            }
        }
        
         //get first possible answer from right, upper bound
        return left - 1;
    }
    
    
    /*
    
    find cut is possible, try to increase by doing left = mid + 1
    not possible, shrink size of length by doing right = mid;
    */
    
    
    //can length be cut k times given ribbons
    public boolean canCut(int[] ribbons, int length, int k){
        int count = 0;
        
        for (int i=0; i<ribbons.length; i++){
            count += ribbons[i] / length;
        }
        
        return count >= k;
    }
    

  
}

/*

[9,7,5] k = 3
    
    1,2,3,4,5,6,7,8,9
    L       M       R
              L M   R
              L
              R
              M
             R 
    
    if count >= k , we found, that means we should search right
    because we want bigger
    
    if count < k, go left until we can find one
    
    possible cut with length and k
    
    count += ribbons[i] / length
    
    */
    
    /*
    
    1. you want to binary search 1 -> max Ribbon length
    2. The max is the first found but on the right since its sorted
    
            Ribbons: 5 , 7, 9
             
    ex: k = 4
       possible answers:
       
        [1 2 3 4] 5 6 7 8 9
        
       max answer:
       
       [1 2 3 [4]] 5 6 7 8 9
    
    
    ex: k = 3
       possible answers:
       
        [1 2 3 4 5] 6 7 8 9
        
       max answer:
       
       [1 2 3 4 [5]] 6 7 8 9
    
    Pretty Hard problem
    
    understand that your ribbon can be cut a ribbon to any size from 1 to maxSize ribbon
    
    Idea: Binary search ribbon sizes
    
    
    break down the problem
    
    1. find arbitraty length that we can cut k times
    
    2. find max length that we can cut k times
    
 - - - - - - upper bound  - --  --
    
    5 , 7, 9,   k = 3
    
    1 2 3 4 5 6 7 8 9
    L       M       R
    
    1 2 3 4 5 6 7 8 9
              L M   R
    
    1 2 3 4 5 6 7 8 9
              L 
              R
              M
              
    1 2 3 4 5 6 7 8 9
              L 
            R  
              M
              
              
              
  - - -- - - - -- Lower bound - - - -- - - - -
  
       5 , 7, 9,   k = 4
    
    1 2 3 4 5 6 7 8 9
    L       M       R

    1 2 3 4 5 6 7 8 9
    L M   R
    
    1 2  3  4 5 6 7 8 9
        LM  R 
        
    1 2  3  4   5 6 7 8 9
            LR  
            M

*/

//     /*
    
//     1.cut k of the same size ribbon
//     2. max possible ribbon
    
    
//         get biggest number that goes into all
        
//         get number that fits into all
//          subtract from all like a circle to reach k
//          does not reach
//         subtract 1 from selected number
        
        
//         ribbons [ 9, 7, 5 ]
//                   L  M  R
                  
//       max = 9
//       R = 9
//       L = 1
//     */