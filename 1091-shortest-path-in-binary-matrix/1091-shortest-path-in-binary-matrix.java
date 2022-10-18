class Solution {
    
    
    /*
        
        Time: o(n)
        Space: o(n)
        
    */
    private static final int[][] directions = new int[][]{
        
                   {-1, -1},{-1, 0},{-1, 1}, 
                   { 0, -1},        { 0, 1}, 
                   { 1, -1}, {1, 0},{ 1, 1}
    };
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        //is answer even possible>?
        // Firstly, we need to check that the start and target cells are open.
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }
        
        // Set up the BFS.
        Queue<int[]> queue = new LinkedList();
        grid[0][0] = 1;
        queue.add(new int[]{0, 0});
        
        int distance = 0;
        
        // Carry out the BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            distance = grid[row][col];
            
            //found answer, reached bottom right
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return distance;
            }
            
            //add to new neighbor to queue and + 1 to distance of neighbor
            for (int[] neighbour : getNeighbors(grid, row, col)) {
                int neighbourRow = neighbour[0];
                int neighbourCol = neighbour[1];
                queue.add(new int[]{neighbourRow, neighbourCol});
                grid[neighbourRow][neighbourCol] = distance + 1;
            }
        }
        
        // The target was unreachable.
        return -1;
    }
    
    
    /*
        insert node, output list of neighbors
        check every direction possible
        dont add if out of bounds
    */

    
    
    public List<int[]> getNeighbors(int[][] grid, int y, int x){
        
        List<int[]> result = new ArrayList();
        
        for (int[] d : directions){
            int yNeighbor = y + d[0];
            int xNeighbor = x + d[1];
            
            if (yNeighbor<0 || yNeighbor>=grid.length || xNeighbor<0 || xNeighbor>=grid[0].length || grid[yNeighbor][xNeighbor] != 0){
                continue;
            }
            result.add(new int[]{yNeighbor, xNeighbor});
        }
        
        return result;
    }
    
}

/*
    
    IMPORTANT: space complexity is not multiplied by 8, because it gets removed!!
    
    BFS typically used to find distance between nodes
    
    How is this a graph?
    every 0 "white square" is a node
    
    we are trying to find the shortest distance from one node to another
    
    
    
       start->     123 x   7 8
                   2 x x   7 8
                   3 x 5 6 7 x 
                   4 4 x x x 8
                   5 x x      9  <- FOUND!
                   
        
        we use bfs to find distance from 1 node to neighbor node
        
        we +1 to distance to represent how many steps to get there
        
    */