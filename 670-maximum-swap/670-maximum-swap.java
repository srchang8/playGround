class Solution {
    public int maximumSwap(int num) {
        
        //similar to next permutation
        //8,5,4,3,6,7 
        //1. split nums in half by finding the first increasing element
        //[left][right]
        //2. Find max position and element on the right
        //3. swap with the first element on the left that is 
        //smaller than maxElement from right
        
        
        /*
        
        
        Algorithm:
                1. find Mod: first increasing from left to right =
                2. find max from mod to right
                3. find min from left to mod
                4. swap min and max
                
                
                [2       7    3    6]
                [ left][mod]
                       [  right     ]
                       
                       
        first increasing num because that means we can do a swap
            we just dont know if that swap is the biggest
            
        */
        
        char[] digits = String.valueOf(num).toCharArray();
        int mod = 1;
        
        //find first increasing num from left to right
        while (mod < digits.length && digits[mod-1] >= digits[mod]) mod++;
        
        //54321, if sorted greatest to smallest,no swap
        if (mod == digits.length) return num;
        
        int rightStart = mod;
        char max = digits[mod];
        int maxPos = mod;
        
        //find biggest element from right of mod
        for (int i=rightStart; i<digits.length; i++){
            if (digits[i] >= max){
                max = digits[i];
                maxPos = i;
            }
        }
        
        //find first smallest element from left and swap with biggest element on right
        for (int i=0; i<rightStart; i++){
            if (max > digits[i]){
                swap(digits, i, maxPos);
                return Integer.parseInt(new String(digits));
                
            }
        }
        
        return num;
    }
    
    public void swap(char[] num, int i, int j){
        char temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}