class Solution {
    public boolean validPalindrome(String s) {
        /*
    
    
    IMPORTANT! dont get triped up on "aabcaa"
    
    
    Algorithm: check outside i->  <-j until i != j, then call function to check inside

    
    
    aabcaa
      ij
      
      without i or j - algo still returns true
      aabaa
      aacaa
       
    -   -   -   -   -   -   --  -   --  
    
    move in until i!=j
    
    a a b b c a a
    i           j
    
    a a b b c a a
        i   j
        
    a a [b b c] a a
         i   j
         2.   4
         
    if either side is pali, return true

    a a [b b] c a a
    
    a a b [b c] a a

    */
        
        int i=0;
        int j = s.length()-1;
        
        while (i<j){
            if (s.charAt(i) != s.charAt(j)){
                //if either is true return true
                return isPali(s,i+1,j) || isPali(s, i, j-1);
            }
            i++;
            j--;
        }
        return true;   
    }
    
    public boolean isPali(String s, int start, int end){
        int i = start;
        int j = end;
        
        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
    
    
}

/* Idea:
left pointer right pointer
keep moing inside if left == right
when string char left != right
    check if either right or left window are pali

*/