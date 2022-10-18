class Solution {
    /*
    
    Time: o(n)
    Space: o(1)
    
    
    can be done with stack but interviwer might want no extra memory
    
    counter/stack only adds (
    unmatched bracket = ( + )
    
    
    
        same idea as stack,
        
        just use left as a stack
        
    */
    public int minAddToMakeValid(String s) {
        
        //stack representation
        // left++
        // if (left != 0) left--
        // if (left == 0) right++
        
        
        int left = 0;
        int right = 0;
        
        for (int i=0; i<s.length(); i++){
            
            char c = s.charAt(i);
            
            if (c == '('){
                left++;
                continue;
            }
            
            if (c == ')'){
                if (left != 0){
                    left--;
                }else{
                    right++;
                }
            }
        }
        
        return left + right;
    }
}

/*

Stack version but itnerviwer might ask for no stack
class Solution {
    public int minAddToMakeValid(String s) {
        
        Stack<Character> stack = new Stack();
        int count = 0;
        for (int i=0; i<s.length(); i++){
            
            if (s.charAt(i) == '('){
                stack.push('(');
                continue;
            }
            
            if (s.charAt(i) == ')'){
                if (!stack.isEmpty()){
                    stack.pop();
                }else{
                    count++;
                }
            }
        }
        
        return stack.size() + count;
    }
}

*/