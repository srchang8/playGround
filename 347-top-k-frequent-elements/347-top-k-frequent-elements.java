class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        /*
        - - - -- Bucket sort - - - -
        
        Time: o(n + k)   where:
                            n = elements
                            k = buckets
        
        Space: same as above
                       
        - - - - - -- - -- - - -- - -
        
        nums = [1,1,1,2,2,3,5,5,5] size 9
        
                       5
                   3,2,1
       bucket = [0,1,2,3,4,5,6,7,8,9]
        
        */
        
        HashMap<Integer, Integer> map = new HashMap();
       for (int n : nums){
           map.put(n, map.getOrDefault(n, 0) + 1);
       }
        
        List<Integer>[] bucket = new List[nums.length+1];
        for (int key : map.keySet()){
         
            int freq = map.get(key);
            if (bucket[freq] == null){
                bucket[freq] = new ArrayList();
            }
            bucket[freq].add(key);
        }
        
        int[] result = new int[k];
        int count=0;
        
        for (int i=bucket.length-1; i>= 0; i--){
            if (bucket[i] == null) continue;
            
            for (Integer n : bucket[i]){
                if (count < k){
                    result[count++] = n;
                }
            }
        }
        
        return result;
    }
}
//HEAP SOLUTION

// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
        
//         HashMap<Integer, Integer> map = new HashMap();
//         for (int n : nums){
//             map.put(n, map.getOrDefault(n, 0) + 1);
//         }
        
//         Queue<Integer> pq = new PriorityQueue<Integer>((currInt, nextInt) -> map.get(currInt) - map.get(nextInt));
        
//         for (int key : map.keySet()){
//             pq.offer(key);
//             if (pq.size() > k) pq.poll();
//         }
        
//         int count = 0;
//         int[] result = new int[k];
//         while (!pq.isEmpty()){
//             result[count++] = pq.poll();
//         }
        
//         return result;
//     }
// }