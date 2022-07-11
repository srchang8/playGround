class Solution {
    
    /*
        
        not too difficult but understand why BFS is likely better
        
        Overall solution:
        
        check top left
        check right bottom
        
        check commonality 
        
        
        algorithm:
        
        1. add all top & left into a pacific ocean queue
            -then do BFS and mark is reachable
        2. add all right & bottomw into atlantic ocean
            -then do bfs and mark as reachable
        3. check commonaility if both reachable add to result
        
        */
    
    
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int numRows;
    private int numCols;
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        // Check if input is empty
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        // Save initial values to parameters
        numRows = matrix.length;
        numCols = matrix[0].length;
        
        // Setup each queue with cells adjacent to their respective ocean
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        
        boolean[][] pacificReachable = new boolean[numRows][numCols];
        boolean[][] atlanticReachable = new boolean[numRows][numCols];
        
        //add verticals: left col and right col
        for (int y = 0; y < matrix.length; y++) {
            pacificQueue.offer(new int[]{y, 0});
            atlanticQueue.offer(new int[]{y, matrix[0].length - 1});
        }
        
        //add horizontal: top and bottom row
        for (int x = 0; x < matrix[0].length; x++) {
            pacificQueue.offer(new int[]{0, x});
            atlanticQueue.offer(new int[]{matrix.length - 1, x});
        }
        
        
        // Perform a BFS for each ocean to find all cells accessible by each ocean
        bfs(matrix, pacificQueue, pacificReachable);
        bfs(matrix, atlanticQueue, atlanticReachable);
        
        
        // Find all cells that can reach both oceans
        List<List<Integer>> commonCells = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    commonCells.add(List.of(i, j));
                }
            }
        }
        return commonCells;
    }
    
    
    
    
    private void bfs(int[][] grid, Queue<int[]> queue, boolean[][] visited) {
        
        while (!queue.isEmpty()) {
            
            int[] p = queue.poll();
            int y = p[0];
            int x = p[1];
            
            
            // This cell is reachable, so mark it
            visited[y][x] = true;
            
            for (int[] dir : DIRECTIONS) { // Check all 4 directions
                int yN = p[0] + dir[0];
                int xN = p[1] + dir[1];
                
                // check valid neighbors
                if (yN < 0 || yN >= numRows || xN < 0 || xN >= numCols ||
                    visited[yN][xN] || grid[yN][xN] < grid[p[0]][p[1]]) {
                    continue;
                }
            
               
                queue.offer(new int[]{yN, xN});
            }
        }
      
    }
}