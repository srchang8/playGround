class Solution {
    
    
    /*
        Time: o(n * 3^L)
            n = num of cells
            3 = num of directions we can go, its 4 but we cant cross self so its 4-1
            L = length of word
        
        Space: o(L + n)
        
        L = max length of recursive stack 
        n = boolean visited
        
    
    */
    boolean found = false;
    
    private static final int[][] dir = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
    
    public boolean exist(char[][] board, String word) {
       
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int y=0; y<board.length; y++){
            for (int x=0; x<board[0].length; x++){
                
                if (board[y][x] == word.charAt(0)){
                    
                    helper(board, word, visited, y, x, 0);
                    if (found) return true;
                }
            }
        }
        
        return found;
    }
    
    public void helper(char[][] b, String word, boolean[][] vis, int y, int x, int currC){
        
        if (currC == word.length()){
            found = true;
            return;
        }
        
        if (y<0 || y >= b.length || x < 0 || x >= b[0].length || vis[y][x] || b[y][x] != word.charAt(currC)){
            return;
        }

        vis[y][x] = true;
        currC++;

        for (int[] d : dir){
             int yN = y + d[0];
             int xN = x + d[1];
            
             helper(b,word,vis,yN,xN,currC);
            
        }
        vis[y][x] = false;
        
        
    }
}

    /*
        ["C","A","A"],
        ["A","A","A"],
        ["B","C","D"]
        
[["C","A","A"],["A","A","A"],["B","C","D"]]
"AAB"

        1. find first
        2. start going from there and search for next letter
        3. check directions, and if current letter
        4.if count == word size we found all letters
        
        edge case: we need visited[] so we dont cross over, or reuse
    
    */