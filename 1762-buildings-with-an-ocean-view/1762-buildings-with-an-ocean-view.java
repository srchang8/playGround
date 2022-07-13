class Solution {
    
     /*
            //need to come back make sure you understand follow up. Monotonic stack
        
            not too hard question
            
            start from the right and keep track of maxHeight
            
            watch out for [1,3,2,4] or [1,2,4,3]
            
        
        */
    public int[] findBuildings(int[] heights) {
      
        List<Integer> result = new ArrayList();
        
        int before = -1;
        
        for (int i=heights.length-1; i>=0; i--){
            if (heights[i] > before){
                result.add(i);
                before = heights[i];
            }
        }
        
        int[] res = new int[result.size()];
        Collections.sort(result);
        
        for (int i=0; i<res.length; i++){
            res[i] = result.get(i);
        }
        
        return res;
    }
}

/* idea:
    1. start from the right side
    2. keep track of tallest from right
    3. before = Integer.MIN_VALUE;
*/



/*

 FB follow up: can only do left to right
 
 use a stack, idea is if curr height is bigger than all the element in the stack. then pop
 
 stack only keeps track of new maxes
 
 stack represents buildings with a view (their index)
 
 


public int[] findBuildings(int[] heights) {
      
        List<Integer> result = new ArrayList();
        
     Stack<Integer> stack = new Stack();
     //starting point 0, assuming first building has a view to compare
     stack.push(0);
    
    for (int i=1; i<heights.length; i++){
        
        //while loop make sure the new max is bigger than all we seen before
        while (!stack.isEmpty() && heights[i] >= heights[stack.peek()]){
            stack.pop();
        }
        
        stack.push(i);
    }
    
         //Our stack now contains only the buildings that have a view of the ocean and we need to return it in the appropriate form
    int[] result = new int[stack.size()];
    int n = stack.size();
    for(int i = n-1; i>=0; i--){
        result[i] = stack.pop();
    }
    return result;
    }
    
*/