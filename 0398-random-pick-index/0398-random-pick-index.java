// class Solution {
    
    
//     /*
//         IMPORTANT: question is just asking to get a random index that = target
        
        
//         Algorith: 
//             1. count number of elm occurances as we go
//             2. use count to randomize potential idx to return
//                 use random.nextIn(count) 
        
        
//         REMEMBER: rand.nextInt(count) == 0
                  
//                   random.nextInt(count) randomly pick from 0-count
//                   count = 5
//                   exclusive count so nextInt(count) goes from 0-4 
        
//         PICK ALWAYS EXIST or else algo wont work
        
        
//         idx = i only happens randomly as we go because rand.nextInt(count) == 0 only sometimes
        
//  -- - -  -- Question clarification - - -- - - - -- 
        
//         Map<Elem, List<index with this elem>
//                     +
//         return random from index from list
        
        
//         random.nextInt(count) randomly pick from 0-count
    
//     */
    
    
//     //essentially youre doing the same thing as hasmap and using random.nextInt(count) to pick a possible index
//     // numbers are not sorted probably
//     //trick here is cant use extra space
   
    
//     /*
//         iterate through nums, count target occurance
    
//     */
//     int[] nums;
//     Random rand;
    
//     public Solution(int[] nums) {
    
//         this.nums = nums;
//         this.rand = new Random();
//     }
    
//     public int pick(int target) {
        
//         int count = 0;
//         int idx = 0;
        
//         for (int i=0; i<nums.length; i++){
            
//             // if nums[i] is equal to target, i is a potential candidate
//             // which needs to be chosen uniformly at random
//             if (nums[i] == target){
                
//                /*
//                 get index = target
//                 use count to randommize if we should return this index
//                 increment count of possible candidates
//                 */
//                 count++;
//                 if (rand.nextInt(count) == 0){
//                     //first occur will always happen
//                     //random choose after
//                     idx = i;
//                 }
//             }
//         }
        
//         return idx;
//     }
// }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */






//Hashmap solution, i dont think accepted by interviewer too easy
class Solution {

    //this is much simpler than random pick weight
    //question is just asking for random index = target
    //get all nums[i] = target
    //then randomly pick an index
        
    // <element, list<index with this element>
    HashMap<Integer, List<Integer>> map;
    public Solution(int[] nums) {
        
        map = new HashMap();
        for (int i=0; i<nums.length; i++){
            if (!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList());
            }
            map.get(nums[i]).add(i);
        }
        
    }
    
    //meat is here
    //to get random index from list:
    //random * list size
    public int pick(int target) {
        List<Integer> list = map.get(target);
        
        double random = Math.random() * list.size();
        return list.get((int)random);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */