class Solution {
    
    /*
        space 
            construct prefix = o(n)
            pickIndex = o(n)
            
        
        time
            construct prefix = o(n)
            pickIndex  = o(n) or log(n) if binary search is used
            
            
    */
    
    int totalSum;
    int[] prefixSum;
    
    public Solution(int[] w) {
        
        //get prefixSum arr
        for (int i=1; i<w.length; i++){
            //add left to right
            w[i] += w[i-1];
        }
        
        this.totalSum = w[w.length-1];
        
        this.prefixSum = w;
    }
    
    public int NonBspickIndex() {
        
        //get a random int then scale it
        double target = totalSum * Math.random();
        
        //see where it lands after scaling
        for (int i=0; i<prefixSum.length; i++){
            if (target < prefixSum[i]){
                return i;
            }
        }
        
        return -1;
    }
    
    
    //speed up using binary search
    public int pickIndex(){
        
        double target = totalSum * Math.random();
        
        int left = 0;
        int right = prefixSum.length-1;
        
        while (left < right){
            
            int mid = left + (right - left) / 2;
            
            //search for the first target < preSum
            if (prefixSum[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        
        return left;
    }
}

/*

     [1,3,6]
    0,1,1,1,2,2,2,2,2,2
      1     4          10

preSum  1,4,10
   
   
   total sum to scale

    Algo:
        1. create presum arr for ranges
        2. scale random: random * totalSum
        3. iterate through presum arr to see where random lands on
        
        
        PreSum = add from left to right     arr[i] += arr[i-1]
        
    1/totalSum
    
    random = .7
    .7 * totalSum = 7
    
    [1,3,6]  pSum = [1,4,10]
    [0,1,1,1,2,2,2,2,2,2]
    
    
    */
    
    //think of throwing soccer ball over ranges
    //prefix is useful because it tells you the range
    //given [1,3,6] presum = [1,4,10]
    //       0,1,2            0,1, 2
    // [0,1,1,1,2,2,2,2,2,2]
    //    pSum  pSum       pSum
    
    //hence pSum(index 2), anything smaller than will be index 2
    
    //prefix sum: sum up to including current index
    //Input  : givenArra[] = {10, 20, 10, 5, 15}
    //Output : prefixSum[] = {10, 30, 40, 45, 60}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */