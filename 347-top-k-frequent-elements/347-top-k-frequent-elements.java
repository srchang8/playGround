class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap();
        for (int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        Queue<Integer> pq = new PriorityQueue<Integer>((currInt, nextInt) -> map.get(currInt) - map.get(nextInt));
        
        for (int key : map.keySet()){
            pq.offer(key);
            if (pq.size() > k) pq.poll();
        }
        
        int count = 0;
        int[] result = new int[k];
        while (!pq.isEmpty()){
            result[count++] = pq.poll();
        }
        
        return result;
    }
}