class Solution {
    //make sure you do follow up
    //trick, if its a toeplitz, only 1 new element should be added to front, 1 deleted from end
    //kind of like a sequence 1,2,3,4 | 5,1,2,3
    public boolean isToeplitzMatrix(int[][] matrix) {
       
        int row = matrix.length;
        int col = matrix[0].length;
        
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(matrix[i-1][j-1] != matrix[i][j]) return false;
            }
        }
        return true;
    }
}


//follow up
/*
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        List<Integer> buffer = new LinkedList();
        for (int i=0; i<col; i++){
            buffer.add(matrix[0][i]);
        }
        for (int i=1; i<row; i++){
            for (int j = 1; j<col; j++){
                
                if (buffer.get(j-1) != matrix[i][j]) return false;
            }
            //remove 4 -> end of first line
            //add 5 -> front of second line
            //the elements stay the same if toeplitz
            buffer.remove(col-1);
            buffer.add(0, matrix[i][0]);
        }
        
        return true;
    }
}




*/