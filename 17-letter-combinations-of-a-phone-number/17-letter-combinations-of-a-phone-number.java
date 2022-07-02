class Solution {
    
    /*
        Time: o(4^n * n)  === letters ^digits * digits
        Space: o(n) n == number of digits
    
    
    Time complexity: 4^n because 4 is the max string length for ex "7" -> "pqrs"
    */
     Map<String, String> phone = new HashMap<String, String>() {{
    put("2", "abc");
    put("3", "def");
    put("4", "ghi");
    put("5", "jkl");
    put("6", "mno");
    put("7", "pqrs");
    put("8", "tuv");
    put("9", "wxyz");
  }};
    
    List<String> result = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        
        
        if (digits.length() == 0){
            return result;
        } 
        
        helper("",digits);
        
        return result;
                
    }
    
    public void helper(String s, String nextDigit){
        
        if (nextDigit.length() == 0){
            result.add(s);
            return;
        }
         
        String digit = nextDigit.substring(0,1);
        String letters = phone.get(digit);
        
        for (int i =0; i<letters.length(); i++){
            
            //how to for loop through a,b,c | e,f,g etc
            //String letter = letters.substring(i, i+1);
            char letter = letters.charAt(i);
            
            //substring(1) returns everything after the first index
            // 1234 will return 234
            helper(s + letter, nextDigit.substring(1));
        }
    }
}