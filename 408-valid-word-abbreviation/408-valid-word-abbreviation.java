class Solution {
    
    /*
    
    Time: o(n)
    Space: o(1)
    
    
    THIS IS EDGE CASE QUESTION, see below test cases
     
    - - - - - - Illustration  - - -- - - --- -  -

        i  nternational   iz   atio  n           
        i     12                       i                  
        
        i     12         iz    4    n  
        j                              j 


    - - - - - -- - - -- - - -- - - - - - -- - - -- - 
    
     1. abbr = 0
     2. abbr ends in digit
            nn
            n1
    

    - - - - -- T est cases - - - - - -- - - - -- 

"internationalization"
"i12iz4n"
"apple"
"a2e"
"internationalization"
"i5a11o1"


"a"
"01"

"hi"
"2i"
    
    */
    
    public boolean validWordAbbreviation(String word, String abbr) {
        
        int i=0;
        int j=0;
        int num = 0;
        
        while (i < word.length() && j < abbr.length()){
            
            
            if (Character.isDigit(abbr.charAt(j))){
                
                //j < abbr.length() for nn n1 case
                //leaves the loop
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))){
                    num = num * 10 + abbr.charAt(j) - '0';
                    
                    if (num == 0) return false;
                    j++;
                }
                
                i += num;
                num = 0;
            }else if (!Character.isDigit(abbr.charAt(j))){
                
                if (word.charAt(i) != abbr.charAt(j)) return false;
                i++;
                j++;
            }
        }
        
        return i == word.length() && j == abbr.length();
    }
}