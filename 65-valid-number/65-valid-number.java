class Solution {
    
    /*
    
    Runtime:
    
    time = o(n)
    space = o(1)

  
    Not a good Problem, just memorize    
    
    ------- Algorithm  - - - - - -- - - -
    
    traverse char by char and check diff things depending on if char are the following
    
    1. Track 4 things:
    
        digits - use var
        +-
        e      - use var
        .      - use var
        
    2. check conditions for each
        
        mark seen digit
        
        +- char before must must be lowercase e unless strings starts with +-
        
        e || E 
         already seen e or E                     1e1e  return false
         have not seen Digit                      e1   return false
         
        .
          already seen .                         .1.1  return flase
          . cannot be in front of exponent       e.    return false
        
        
        - - - - -- - - - -- Notes  - -- - - -- - -- - -
        
        if char is 5
              mark seen digit
        if char is -+
            has to be at beginning or there needs
            to be e before it
        if char is e || E
            no E or E before it
            mark seenExponent
            resset seenDigit
        if char is .
            cant have seen . already
            cant have seen exponent
            mark seenDot
    */
    public boolean isNumber(String s) {
        
        boolean seenDigit = false;
        boolean seenExponent = false;
        boolean seenDot = false;
        
        for (int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            
            if (Character.isDigit(curr)){
                seenDigit = true;
            }else if (curr == '-' || curr == '+'){
                if (i>0 && s.charAt(i-1) != 'e') return false;
            }else if (curr == 'e' || curr == 'E'){
                if (seenExponent || !seenDigit) return false;
                seenExponent = true;
                seenDigit = false;
            } else if (curr == '.'){
                if (seenDot || seenExponent) return false;
                seenDot = true;
            }else{
                //G76
                return false;
            }
        }
     
        return seenDigit;
    }
}

/*
     
     
     
       - - - - - -- - -  Algorithm - - - - -- - - - -- - -- - - -- 
    
    1. check if its a decimal num or integer
    
        integer = "-12e+1"      |     decimal num = "53.5e93"
        
        integer = atleast 1 digit, sign +- must start or be after E
    
    
    - - - - - -- - --  Rules - - - - -- - - -- -- - -- - - - - - - - -- -
    
    1. Digits
        at least 1 digit
    
    
    2. Signs +-
        must start with sign or be right after 'e', 'E'
        
        ex: -63e+7
    
    
    3. Exponents
            only have 1 'e' or 'E'
            must appear after . or integer
       
       ex: 1e3   or  .45e1
       fail: e1.5
    
    
    4. Dots
        only 1 . per number
        can only be before exponent
       
       fail: 63e+1.0
    
    
    
        -12e1


*/


