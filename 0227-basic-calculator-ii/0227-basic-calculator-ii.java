class Solution {
    
    
    /*
    
    33 + 2 * 2
    
    for no stack solution: basically 2 levels: +- are added to result, * / will be done later
    
    level 1: result +-
    level 2: prevSum /*
    
    sum level 1 + level 2 
    
    result + prevSum
    
    
    */
    public int calculate(String s) {
        
        //remove front and back spaces
        // " 33+ 2*2 " -> "33+ 2*2"
        //s = s.trim();
        
        int num = 0;
        char prevSign = '+';
        
        //prevNum & result basically replace the stack
        //prevNum is a place holder before adding to stack(result)
        int prevNum = 0;
        int result = 0;
        
        for (int i=0; i<s.length(); i++){
            
            
            char c = s.charAt(i);
            
            if (Character.isDigit(c)){
                num = (num * 10) + (c - '0');
                //cant continue because if string ends with a digit
                //we still want to enter below loop
            }
            
            //if sign
            if (c != ' ' && !Character.isDigit(c) || i == s.length()-1){
                
                if (prevSign == '+'){
                    result += prevNum;
                    prevNum = num;
                }else if (prevSign == '-'){
                    result += prevNum;
                    prevNum = -num;
                }else if (prevSign == '/'){
                    prevNum = prevNum / num;
                }else if (prevSign == '*'){
                    prevNum = prevNum * num;
                }
                
                num = 0;
                prevSign = c;
            }
        }
        
        
        
        return result + prevNum;
        
    }
}

/*
class Solution {
    
    /*
    NOT DONE, STACK SOLUTION NOT ACCEPTED BY FB
    IMPORTANT:  - - -- - - - - -- - - 
        
        lastSign
        
            if c
                if lastSign
            
            lastSign = c
            num = 0
            
        DONT FORGET LAST EDGE CASE 
        
            i < s.length() - 1
            
    -  -- - - - - -- - - -- - -- - - -- - -  
        
        left to right * /
        
        order doesnt matter when +-
        
        int currNum
        int lastSign
        
        * / do it right away
        + - add to stack
    

        
        char lastSign
        
        order is from left to right when only division and multiplication
        2*15/2 = 15
        
        when + - / * then we do left to right  * / first
        
        when only + -, order doesnt matter
        
        
        Algo:
        
        1. do * and / first
        2. stack should only have + - nums
        3. sum up stack
        
        iterate through s
        keep track of lastSign and num
        
        if digit, set it to num
        
        if sign
            push to stack + -
            push pop for / *
            
            num = 0
            lastSign = sign
            
        
        sum stack
        
    public int calculate(String s) {
        
        Stack<Integer> stack = new Stack();
        
        int num = 0;
        char lastSign = '+';
        
        for (int i=0; i<s.length(); i++){
            
            char c = s.charAt(i);
            
            //keep appending 33
            //if digit
            if (Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }
            
            //if sign
            if (c != ' ' && !Character.isDigit(c) || i == s.length()-1){
                
                //+ - just add to stack
                //* / calculate now
                if (lastSign == '+'){
                    stack.push(num);
                }else if (lastSign == '-'){
                    stack.push(-num);
                }else if (lastSign == '/'){
                    stack.push(stack.pop() / num);
                }else if (lastSign == '*'){
                    stack.push(stack.pop() * num);
                }
                lastSign = c;
                num = 0;
            }
        }
        
        
        //calculate the + - num in the stack
        int sum = 0;
        while (!stack.isEmpty()){
            sum += stack.pop();
        }
        
        return sum;
    }
}

*/