class Solution {
    /*
    
        /home//foo/../.
        
        .    -> ignore
        ..   -> pop
        foo  -> add to stack
        ""   -> ignore
        home -> add stack
        
    */
    public String simplifyPath(String path) {
        
        Stack<String> stack = new Stack();
        
        String[] paths = path.split("/");
        StringBuilder sb = new StringBuilder();
        
        for (String p : paths){
            
            if (p.equals(".") || p.equals("")) continue;
            if (p.equals("..")){
                
                if (!stack.isEmpty()) stack.pop();
            }else{
                stack.push(p);
            }
        }
        
        if (stack.isEmpty()){
            sb.append("/");
            return sb.toString();
        }
        for (String s : stack){
            sb.append("/");
            sb.append(s);
        }
        
        return sb.toString();
    }
}