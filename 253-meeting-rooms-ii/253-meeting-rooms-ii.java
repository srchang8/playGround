class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        
        /*
                Algorithm:  put meeting end times to min queue(smallest comes out of queue.poll)
                
                    queue represents num of meetings overlapped
                
                    1. Sort by meeting start time
                    2. check overlaps
                        put first end time
                        
                    if next meeting starts before the min earliest end in the queue
                        add end time to queue
                    
                    
                    
--  -   --  -   -   -- Complexity - -- - -- - --- 

            time: sort = O(NlogN) + o(n) num of add operation from queue at worst all collide
            space: min heap = o(n) at worst all collide 
        
        */
        
        
        
        if (intervals.length == 0 || intervals == null) return 0;
        
        
        //smallest always comes first
        Arrays.sort(intervals, (currInt, nextInt) -> (currInt[0] - nextInt[0]));
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        //offer end time
        minHeap.offer(intervals[0][1]);
        
        for (int i=1; i<intervals.length; i++){
        
            //if new start time is after a meeting ended
            //use the same room
            if (intervals[i][0] >= minHeap.peek()){
                //if we are using the same room
                //make sure to empty old
                minHeap.poll();
            }
            
            minHeap.offer(intervals[i][1]);
            
        }
    
        
        return minHeap.size();
    }
}

//we are basically putting all times into a pq
        //then removing overlaps
        // the result would be intervals without overlaps, aka the total rooms needed
        
        //important to understand why did we sort by start time?
        //since we sorted by start time, we only need to worry about the overlap
        //if overlap, then we need another room, if we can use the same room then 
        //make sure to empty the old room.
        
        //sort intervals by first
        //tricky part : rooms free up so you cannot just count overlaps
        //question is asking for min
        //things i learned, when asking for min try a min heap
        //queue.offer is safer than add when out of space