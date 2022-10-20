class Solution {
    
    /*
        Time: o(n)
        Space: o(1)    
    */
    public int[][] kClosest(int[][] points, int k) {
    
        int left = 0;
        int right = points.length-1;
        
        while (left < right){
            int j = qSelect(points, left, right);
            
            //everything left of j is smaller, meaning even if they are not sorted
            //we found the smallests up to j or kth
            if (j == k) break;
            
            if (j < k){
                left = j + 1;
            }else{
                right = j - 1;
            }
        }
        
        return Arrays.copyOfRange(points, 0, k);
        
    }
    
    public int qSelect(int[][] points, int lo, int hi){
        int pivot = dist(points[hi]);
        int i=lo;
        for (int j=lo; j<hi; j++){
            if (dist(points[j]) <= pivot){
                swap(points, i, j);
                i++;
            }
        }
        swap(points, i, hi);
        return i;
        
    }
    
    public int dist(int[] point){
        return (point[0] * point[0]) + (point[1] * point[1]);
    }
    
    public void swap(int[][] points, int i, int j){
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}
/*
    
    use qSelect and swap up until qSelect returns == k

            k = 2
        [
         [3,3],   -- distance:  1
         [5,-1],  -- distance:  5
         [-2,4]   -- distance:  2
        ]

        --- after q select -- 
        [
         [3,3],   -- distance:  1
         [-2,4]   -- distance:  2  -- return up till here
         [5,-1],  -- distance:  5
        ]


        qSelect
        [3,3], [5,-1] ,[-2,4]
        left->         <-right
    
    */

/*
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
      //Arrays.sort(points, (p1,p2) -> (p1[0]*p1[0] + p1[1]*p1[1]) - (p2[0]*p2[0] + p2[1]*p2[1]));
      //Arrays.sort(points, (p1,p2) -> p1[0]*p1[0] + p1[1]*p1[1] - p2[0]*p2[0] - p2[1]*p2[1]);
        
        //p1-p2 poll removes smallest - min heap
        //p2-p1 poll removes the biggest - max heap
        
        int[][] result = new int[k][2];
        
     PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1,p2) ->  
     (p2[0]*p2[0] + p2[1]*p2[1]) - (p1[0]*p1[0]+p1[1]*p1[1]));
     

         for(int[] point : points){
             pq.offer(point);
             
             //remove biggest
              if (pq.size() > k){
                  pq.poll();
              }
         }
        
        int i=0;
        while (!pq.isEmpty()){
            result[i++] = pq.poll();
        }

        //System.out.println(Arrays.deepToString(points));
        System.out.println(Arrays.deepToString(pq.toArray()));
        
        
        return result;
    }
}
*/