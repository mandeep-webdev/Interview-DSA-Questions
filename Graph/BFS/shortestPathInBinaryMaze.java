class Pair {
    int row;
    int col;
    Pair(int r, int c){
        this.row = r;
        this.col = c;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // find the total number of rows and columns
        int m = grid.length;
        int n = grid[0].length;
        // if the first and last cells are unvisited cells then return -1
        if(grid[0][0]== 1 || grid[m-1][n-1] == 1) {
            return -1;
        }

        int[][] visited = new int[m][n];
        

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        visited[0][0] = 1;

        int level = 1;


        int[] dRow = {-1,-1,-1,0,0,1,1,1};
        int[] dCol = {-1,0,1,-1,1,-1,0,1};

        while(!q.isEmpty()){

            int size = q.size();

            for(int i=0; i< size; i++) {
            Pair cc = q.poll();
            int cr = cc.row;
            int ccol = cc.col;

            // if it is destination cell
            if(cr == m-1 && ccol == n-1){
                return level;
            }

            // explore its all 8 directions

            for(int k=0; k<8;k++){
                int newRow = cr + dRow[k];
                int newCol = ccol + dCol[k];
                // if cell is within boundry and valid
                if(newRow>=0 && newRow<m && newCol>=0&& newCol<n && grid[newRow][newCol] == 0 && visited[newRow][newCol] != 1){
                    q.add(new Pair(newRow,newCol));
                    visited[newRow][newCol] = 1;
                }
            }

           




            }
             level ++;
            

        }
        return -1;


    }
}
