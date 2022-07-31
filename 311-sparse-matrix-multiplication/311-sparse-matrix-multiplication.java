class Solution {
    /*
    
    how to multiply matrix
    https://www.mathsisfun.com/algebra/matrix-multiplying.html
    
    [1,2,3]       [7, 8, 9]
    [4,5,6]   x   [0, 0, 0]    =    [37, 38, 45]
                  [10,11,12]        [88, 92, 108]
                  
    explanation:
    
    1x7 + 2x0 + 3x10  = 37
    
    1x8 + 2x0 + 3x11  = 38
    
    1x9 + 2x0 + 3x12  = 45
    
    4x7 + 5x0 + 6x10  = 88
    
    

    test case:
    [[1,2,3],[4,5,6]]
    [[7,8,9],[0,0,0],[10,11,12]]
    
    
    [1=0, 2=1, 3=2]      [7=0, 8=1, 9=2]
    [4=0, 5=1, 6=2]             []
                        [10=0, 11=1, 12=2]




given:
        [[1,2,3],
         [4,5,6]]

         [7,  8, 9]
         [0,  0, 0]
        [10, 11, 12]


    after compression

 map1: {
                0:[[0,1],[1,2],[2,3]],
                1:[[0,4],[1,5],[2,6]]
            }

        map2: {
            0:[[0,7],[2,10]],
            1:[[0,8],[2,11]],
            2:[[0,9],[2,12]]}



    map1: {0:[[0,1],[1,2],[2,3]],
          1:[[0,4],[1,5],[2,6]]}
          
map2: {0:[[0,7],[2,10]],
      1:[[0,8],[2,11]],
      2:[[0,9],[2,12]]}
      
      
    
         [1,2,3]
         [4,5,6]

         [7,  8, 9]
         [0,  0, 0]
        [10, 11, 12]
        
        
        row x col
        
        1. compress into maps to skil 0's
            y   [x, val]
        map<y, List<int[]>
        
        
            x   [y, val]
        map<x, List<int[]>
        
        
        2. multiply row x col
        
        
        0 [1,2,3]
        1 [4,5,6]
        
        0 [7,8,9]
        1 []
        2 [10,11,12]
        
        
        
        
          [1,2,3]       [7, 8, 9]
          [4,5,6]   x   [0, 0, 0]    =    [37, 38, 45]
                        [10,11,12]        [88, 92, 108]
                  
        
    */
    
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        
        HashMap<Integer, List<int[]>> map1 = new HashMap();
        HashMap<Integer, List<int[]>> map2 = new HashMap();
        
        
        // compress matrix
        // key is row number, value is the list of pairs (index, value)
        for (int y=0; y<mat1.length; y++){
            map1.put(y, new ArrayList());
            for (int x=0; x<mat1[0].length; x++){
                if (mat1[y][x] != 0){
                    map1.get(y).add(new int[]{x, mat1[y][x]});
                }    
            }
        }
        
         // key is col number, value is the list of pairs (index, value)
        for (int x=0; x<mat2[0].length; x++){
            map2.put(x, new ArrayList());
            for (int y=0; y<mat2.length; y++){
                if (mat2[y][x] != 0){
                    map2.get(x).add(new int[]{y, mat2[y][x]});
                }
            }
        }

        //2x3
        /*
        
            [ , , ]
            [ , , ]
        */
        int[][] result = new int[mat1.length][mat2[0].length];
        for (int y=0; y<mat1.length; y++){
            for (int x=0; x<mat2[0].length; x++){
                
                result[y][x] = multHelper(map1.get(y), map2.get(x));
            }
        }
        
        return result;
    }
    
    // [0:1, 1:2, 2:3] [0:7, 1:8, 2:9]
    public int multHelper(List<int[]> rowList, List<int[]>  colList){
        int y=0;
        int x=0;
        int result = 0;
        
        while (y < rowList.size() && x <colList.size()){
            int yIdx = rowList.get(y)[0];
            int xIdx = colList.get(x)[0];
            
            if (yIdx == xIdx){
                result += rowList.get(y)[1] * colList.get(x)[1];
                y++;
                x++;
            }else if (yIdx < xIdx){
                y++;
            }else{
                x++;
            }
        }
        
        
        return result;
    }
}