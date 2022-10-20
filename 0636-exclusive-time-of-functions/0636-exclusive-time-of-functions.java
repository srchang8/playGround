class Solution {
  
  
    
     /*
     
    intuition:
    its just a stack question similar to [] ();
    Alorithm:
    currTime - prevTime = total time when we have Start,End
    
    key is: single processing, it ends deepest processes first
    stack [ [ ] ]
    
    int[] result keep adding to it
    careful with -1 + 1 for time
    
    keep track of prev time
    currTime - prevTime + 1
    
    [1,4]
    */
      public int[] exclusiveTime(int n, List<String> logs) {
        
        Stack<Integer> stack = new Stack();
        int prevTime = 0;
        int[] result = new int[n];
        
        for (String log : logs){
          
          String[] logArr = log.split(":");
          
          int id = Integer.valueOf(logArr[0]);
          int currLogTime = Integer.valueOf(logArr[2]);
          Boolean start = logArr[1].equals("start");
          
          if (start){
                //keep updating time for prev Id
                if (!stack.isEmpty()){
                    int topId = stack.peek();
                    result[topId] += currLogTime - prevTime - 1;
                }
            stack.push(id);
          }
          else{
            //we have start - end
            //+1 cus offset 0
            //stack.pop();
            result[stack.pop()] += currLogTime - prevTime + 1;
          }
          
          prevTime = currLogTime;
        }
      
        return result;
      }
  }