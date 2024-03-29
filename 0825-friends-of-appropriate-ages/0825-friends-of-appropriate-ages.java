class Solution {
    
    /*
        Basic idea: get total possible friend requests
                    then subtract by conditions that remove possible friend request
                    
        1. Count age occurance
        2. get preSum
        3. preSum[i] * numAge[i] = Answer(ages that can friend each other) but before you do that:
            remove ages: 0.5 * age[x] + 7
            remove self: - numAge[i]
        
        
        
   -- - -- - - Explanation - - - -- - 
       You can reverse the conditions from:
    y <= 0.5x + 7
    y > x (third one included in this)

    to:
    y > 0.5x + 7 and y <x

    This means
    x>y>0.5x+7

    Min x that holds this equation:
    x>0.5x+7 and
    0.5x > 7
    x > 14

    min x is 15

    preSumInAge[i]
    This will give you how many people in this bracket and below.

    int count = preSumInAge[i] - preSumInAge[i / 2 + 7];
    This will give you how many requests can you send from this age. 
    
    There could be multiple people in this age group so we need to multiply
    count * numInAge[i]

    You need to account for not sending to itself so you substract
    count * numInAge[i] - numInAge[i]
    gives total
    */
    
    public int numFriendRequests(int[] ages) {
        int res = 0;
        int[] numInAge = new int[121];
        int[] preSumInAge = new int[121];
        
        for(int i : ages) 
            numInAge[i] ++;
        
        for(int i = 1; i<numInAge.length; i++) 
            preSumInAge[i] = numInAge[i] + preSumInAge[i - 1];
        
        for(int i = 15; i<numInAge.length; i++) {
            if(numInAge[i] == 0) continue;
            
            // remove ages <= 0.5 * age[x] + 7
            int count = preSumInAge[i] - preSumInAge[i / 2 + 7];
            
            //people will not friend request themselves, so  - numInAge[i]
            res += (count * numInAge[i]) - numInAge[i]; 
        }
        return res;
    }
}