class Solution {
   /*

    1. parse into String[] paths
    2. process through stack
        
        /home//foo/../boo/.
        
        .    -- ignore
        boo  -- add
        ..   -- pop
        foo  -- add
        " "  -- ignore
        home -- add
        
        IMPORTANT - - - - -
        EMPTY case return /
    
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