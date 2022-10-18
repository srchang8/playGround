
/*
    
    use a queue to know what to subtract, because you need to maintain the size
    
    IMPORTANT: ask what happens if we reached max size
    
    use queue and curr sum
    
    */
class MovingAverage {

    int maxSize;
    Queue<Integer> queue;
    double currSum;
    
    public MovingAverage(int size) {
        queue = new LinkedList();
        currSum = 0;
        maxSize = size;
        
    }
    
    public double next(int val) {
        currSum += val;
        queue.offer(val);
        
        if (queue.size() > maxSize){
            currSum -= queue.poll();
        }
        
        return currSum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */