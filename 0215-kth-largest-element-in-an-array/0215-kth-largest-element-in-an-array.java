class Solution {
        
    /*
        
        QuickSelect runtime:
        Time: o(n) on average, o(n^2) on worst case
        Space: o(1)
        
        Heap runtime: 
        Time: o(n log(k))
            priority queue insertion takes log(k)
            do it for each N
        space: o(k) 
            
    */
    
    public int findKthLargest(int[] nums, int k) {
        
        //IMPORTANT kth LARGEST that means from right
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        
        //keep partitioning until we get j == kth
        //that means everything left on the left of k is smaller than k
        //and everything on the right of k is bigger than k
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            
            //shrink lo and hi until j == k
            
            if (j == k) break;
            if(j < k) {
                lo = j + 1;
            } else {
                hi = j - 1;
            }
        }
        return nums[k];
    }
    
    
    //main algorithm
    //choose last digit as pivot
    //keep swapping i and j until we find element bigger than pivot
    //once done scanning, place pivot correctly by swapping i with pivot index
    //i keeps track of where pivot needs to go
    //j is the scanner
    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[hi];
        int i = lo;
        for (int j = lo; j < hi; j++) {
            
            
            //find element bigger than pivot and put it to the right of pivot eventually
            //swap only matters when i != j
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        //place pivot where everything before it is 
        //smaller and everything after is bigger
        swap(nums, i, hi);
        return i;//position where selected(hi) was placed
    }

    private void swap(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    //quick select explanation
    //basically the partitioning algo, starts with the last element, and finds its order/placement
        //we dont need to know the order for every number, just that there are this many smaller elements than 
        //the selected element
        
        //quick select/sort is a good choice because it does not necessary sort the whole arr
        // but it randomly finds an integer with everything on left smaller and right bigger
    
    
    
    
    //easy solution
//     public int findKthLargest(int[] nums, int k) {
        
        
//         //easy way out is below but i think they are looking for quick select
//         if (nums.length == 0) return 0;
        
//         PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
//         //PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        
//         for (int num : nums ){
//             pQueue.add(num);
//             if (pQueue.size() > k) pQueue.poll();
//         }
        
        
//         return pQueue.poll();
//     }
}



//3,2,1,5,6,-1,-2,-3,4
        //https://www.youtube.com/watch?v=MZaf_9IZCrc amazing explanation
        //quick select works well because we dont need to order the entire array

    
        // left of i represents items smaller than selected
        //everything between i and J represent numbers bigger than selected
        
        
        /*
    priority Queue but probably too simple
    
    q select is faster
    
    kth = from the right
    
    init:
    [ 3 , 2 , 1 , 5 , 6 , 4]
    left->           <-right
    
    quick Select
        everything before i is smaller than pivot
        everything between i & j are nums bigger than pivot
        at the end swap
    
    i and j swap but stay together 
    [ 3 , 2 , 1 , 5 , 6 , 4]
      i
      j
     
     
    [ 3 , 2 , 1 , 5 , 6 , 4]
              i
                      j
     
     last iteration swap
    [ 3 , 2 , 1 , 5 , 6 , 4]
                  i
                          j
    [ 3 , 2 , 1 , 4 , 6 , 5]
                  
     
     
    */