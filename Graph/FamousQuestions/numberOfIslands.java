//TC --- O(m*n)
// SC -- O(m*n)
class Pair {
    int row;
    int col;
    public Pair(int r, int c){
        this.row = r;
        this.col = c;

    }
}
class Solution {
  // BFS function to explore an island
   public void bfs(int[][] visited,char[][] grid, int i, int j,int m, int n){
    Queue<Pair> que = new LinkedList<>();
    // Directions to move in 4 possible ways: Up, Down, Left, Right
    int[] dRow = {-1,1,0,0};
    int[] dCol = {0,0,-1,1};
     // Mark the cell as visited
    visited[i][j] = 1;
    que.add(new Pair(i,j));

    while(!que.isEmpty()){
        Pair cords = que.poll();
        int row = cords.row;
        int col = cords.col;
        // Check all 4 possible neighbors
        for(int k=0; k<4; k++){
            int newRow = row + dRow[k];
            int newCol = col + dCol[k];
    // Check boundaries and if the cell is unvisited land
            if(newRow>=0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == '1' && visited[newRow][newCol] == 0 ){
                visited[newRow][newCol] = 1;
                que.add(new Pair(newRow,newCol));
            }

        }


    }
   }
    public int numIslands(char[][] grid) {
       int rows = grid.length;
       int cols = grid[0].length;
       // 2D visited array
       int[][] visited = new int[rows][cols]; 
       int count = 0;
       // lets traverse the grid

       for(int i=0; i<rows; i++){
        for(int j=0; j<cols; j++){
          // here i have found the land now call any traversal to mark its adjacent cell as visited
            if(visited[i][j] == 0 && grid[i][j] == '1' ){
                bfs(visited,grid,i,j,rows,cols);
                count ++;
            }
        }

       }
       return count;
    }
}
