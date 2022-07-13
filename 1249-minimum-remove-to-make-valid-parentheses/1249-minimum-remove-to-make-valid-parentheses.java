class Solution {
    
    /*
    
    Time: o(n)
    Space: o(n)
    
    follow up: solve without stack
     
      Input: "lee(t(c)o)de)("
     
    - - - - -- - first loop remove ")" - -  - - -- 
    openSeen = 3
    balance = 1
    
    
     --  -- - -- - Second loop remove "("
    sb = lee(t(c)o)de(
    
    openToKeep = -1
    
    lee(t(c)o)de
    
    
    
    */
    
    //use a stack to store the indexes you want to delete
    
    // extra ) will be marked right away
    // extra ( will remain in stack
    public String minRemoveToMakeValid(String s) {
        
        StringBuilder sb = new StringBuilder(s);
        
        //store index of char to remove
        Stack<Integer> stack = new Stack();
        
        for (int i=0; i<sb.length(); i++){
            
            if (sb.charAt(i) == '(' ){
                stack.push(i);
                continue;
            }
            
            if (sb.charAt(i) == ')'){
                if (!stack.isEmpty()){
                    stack.pop();
                }else{
                    sb.setCharAt(i, '*');
                }
            }
        }
        
        //mark leftover (( in stack
        while (!stack.isEmpty()){
            sb.setCharAt(stack.pop(), '*');
        }
        
        //change * to ""
        return sb.toString().replaceAll("\\*", "");
    }
}

/*
stack only contains (
pop stack when we see )
mark no match ) with *

below are possible cases
() pop
) mark *
( mark *

*/