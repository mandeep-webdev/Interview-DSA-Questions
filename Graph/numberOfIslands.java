//------------------------------DFS Approach------------------------------
// TC -- O(m*n)
// SC --- O(1)
class Solution {
    public void dfs(char[][] grid, int i, int j, int m, int n){
        // return if goes out of bound index or if it is water node
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] == '0' ){
            return;
        }
        // if the node is already visited return
        if(grid[i][j] == '$') {
            return;
        }
        // mark the node as visited
        grid[i][j] = '$';
        // Explore all 4 directions
        dfs(grid,i-1,j,m,n); // up
        dfs(grid,i+1,j,m,n); // down
        dfs(grid,i,j-1,m,n); // left
        dfs(grid,i,j+1,m,n); // right



    }
    public int numIslands(char[][] grid) {
        int totalRows = grid.length;
        int totalColums = grid[0].length;
        int count = 0;

        for(int i = 0; i<totalRows; i++){
            for(int j=0; j<totalColums; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j,totalRows,totalColums);
                }

            }
        }
        return count;
    }
}
