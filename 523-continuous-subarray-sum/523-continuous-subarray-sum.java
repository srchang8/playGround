class Solution {
    
    /*
    
        Space: o(n)
        Time: o(n)
        
        
--- - - - - - Best explanation  - - - -- - -      

         //when map contains mod, it means that there exist an 
    //subarray from 0~j (j=map.get(mod)) where its sum%k==mod.
      //which means that subarray sum( j~i) %k==0. 
      
      
      nums = [23,2,4,6,7], k = 6
             [5][1,5]
  
      0,-1
      5,0   23 % 6 = 3 x 6 = 18  = 23-18 = 5
      1,1
      5,2   29 % 6 = 4 x 6 = 24  = 29-24 = 5
      
      
      |  A   |     D    |B|
      
      D = B-A
      

        
    */
   
      public boolean checkSubarraySum(int[] nums, int k) {
        
        //rolling sum%k, index
        HashMap<Integer, Integer> modMap = new HashMap();
        
        /* case [1,2,3] k=6
    
        0,-1
        1,0
        3,1
         
        */
        modMap.put(0,-1);
        
        int sum = 0;
        int mod = 0;
          
          
        for (int i=0; i<nums.length; i++){
          
          //calculate running sum % k
          sum += nums[i];
          mod = sum % k;
          
          modMap.putIfAbsent(mod, i);
            
            //if mod exist and if its subArray contains at least 2 elemenets
          if (modMap.containsKey(mod) && i - modMap.get(mod) > 1){
              return true;
      
          }
          
        }
          
        return false;
      }
    
    
  }

/*presum

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n+1];
        for(int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for(int i = 2; i <= n; i++) {
            set.add(sum[i-2] % k);
            if(set.contains(sum[i] % k)) return true;
        }
        return false;
    }
}

*/



    /*
    
    
    
     Algorithm
        Traverse nums and fill map<rollingSum % k, index>
        
        1. base case 0, -1
        
        2. add rollingSUm%k, index to map
           rolling sum sum + nums[i]
           mod =  sum % k
           putIfAbsent
           
        3. if map contains mod and its more than 2 index return true
        
        
        4. return false
        
    
    IMPORTANT!!! PUT IF ABSENT!
    
    
    
 - - - --  Terminology - - - -- -
     
    MULTIPLE: - - -- - -
    
    6x1=6
    6x2=12
    
    multiples of 6 = 6,12,18,24
    
    multiple of 6 is when num % 6 = 0
    
    
    SUBARAY: - - - -- - 
    
    what is a subarray? array = [1,2,3,4] ORDER MATTERS
    
        1 
        1 2 
        1 2 3 
        1 2 3 4 
        2 
        2 3 
        2 3 4 
        3 
        3 4 
        4
    
    MOD: - - -- - - -- - - -- 
    
     1%6 = 1
     5%6 = 5
    
    
    
    - - - - - -  Math proof - - - - - -
      
      |  A   |     D    |B|
      
      D = B-A
      
      looking for:
      D % k = 0
      
      replace
      
      (B - A) % k = 0
      B%k - A%k = 0
      
      B%K = A%K
  
      A%k goes into map, check B%k    when k = 0
      
      nums = [23,2,4,6,7], k = 6
      
      
      0,-1
      5,0   23 % 6 = 3 x 6 = 18  = 23-18 = 5
      1,1
      5,2   29 % 6 = 4 x 6 = 24  = 29-24 = 5
      
      
      
      23 % 6 = 5 --- 18 + 5 = 23
      
      */