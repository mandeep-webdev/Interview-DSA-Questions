/*********************************************** Java **************************************************/
//Approach-1 (DFS)
//T.C : O(m*n)
//S.C : O(1) Auxiliary Space
class Solution {
    public int dfs(int[][] grid, int i, int j, int row,int col){
      
        // Base cases: Add to perimeter when we reach water or go out of bounds
        if(i<0 || i>=row || j<0 || j>=col || grid[i][j] == 0){
           return 1; // Water or out-of-bounds contributes 1 to the perimeter

        }
         // If the cell is already visited, no perimeter contribution
        if(grid[i][j] == -1) {
            return 0 ;
        }
         // Mark the cell as visited
        grid[i][j] = -1;
        
        // Explore in 4 directions and sum up the perimeter contributions
        int perimeter = 0;
        perimeter+= dfs(grid,i-1,j,row,col); // Up
        perimeter+= dfs(grid,i+1,j,row,col); // Down
        perimeter+= dfs(grid,i,j-1,row,col); // Left
        perimeter+= dfs(grid,i,j+1,row,col); // Right
      
    return perimeter;


    }
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int perimeter = 0;
        //let's traverse in the 2d matrix
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col;j++){
                // when i find the land cell, i will traverse further
                if(grid[i][j] == 1) {
                    perimeter =  dfs(grid, i, j,row,col);
                }

            }
        }
        return perimeter;
    }


}

//Approach-2 (BFS)
//T.C : O(m*n)
//S.C : O(m*n)
