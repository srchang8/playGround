/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    /*    
        space - o(n)
        time - o(n)
    
    */
    public int depthSum(List<NestedInteger> nestedList) {
        
        Queue<NestedInteger> queue = new LinkedList(nestedList);
        int level = 1;
        int sum = 0;
        
        while (!queue.isEmpty()){
            int size = queue.size();
            
            for (int i = 0; i<size; i++){
                NestedInteger nI = queue.poll();
                
                if (nI.isInteger()){
                    sum += nI.getInteger() * level;
                }else{
                    //biggest trick - addAll 
                    //you want to add all the nested NestInteger objects
                    //cant do offer(nI.getList()) - cant add List<NestedInteger>
                    
                    for (NestedInteger n : nI.getList()){
                        queue.offer(n);
                    }
                    //queue.addAll(nI.getList());
                }
            }
            level++;
        }
        
        return sum;
    }
}


    /*
    Question: Sum all nested: integer * level
    
    algo: level traversal using a queue and add level by level
    -start with: all curr level to queue 
    
    IMPORTANT!!!! 
        NestedInteger.getInteger() super useful, tells you if its a nested list or not
        question is asking to multiply by LEVEL
    
    
        //Very similar to level traversal
    //add everything on 1st level
    //if nested, add to queue for next level
    //real trick is queue.addAll(ni.getList()), NestedInteger allows you to add nicely
    
        
        
    [[1,1],2,[1,[2,2],1],[1,1]]
           
L1         2
L2   1,1      1,[2,2],1   1,1
L3               2, 2
       
       
       Algo: Level traversal with a queue
       
       1. put List of NestedInteger into queue
       2. start at level 1 for multiplication
*/




















