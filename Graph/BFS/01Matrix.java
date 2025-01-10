// Time Complexity: O(m * n)
// Space Complexity: O(m * n)

class Node {
    int first;
    int second;
    int third;
    Node(int _first, int _second, int _third){
        this.first = _first;
        this.second = _second;
        this.third = _third;

    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
       int m = mat.length;
       int n = mat[0].length;
       int[][] visited = new int[m][n];
       int[][] distance = new int[m][n];
       Queue<Node> que = new LinkedList<>();
       // mark each cell of visited array as 0 means cell is not visited yet
       for(int i=0; i<m; i++){
        for(int j=0; j<n;j++){
            visited[i][j]=0;
        }

       }
       // lets traverse the matrix
      for(int i = 0; i<m ;i++) {
        for(int j=0; j<n; j++){
            // using bfs only for those cell having 0 in it
            if(visited[i][j] == 0 && mat[i][j]==0){
                visited[i][j] = 1; // mark as visited;
                que.add(new Node(i,j,0));
            }
        }
      }

        while(!que.isEmpty()){
            int row = que.peek().first;
            int col = que.peek().second;
            int dis = que.peek().third;
            que.remove();
            distance[row][col] = dis; 
            
  // Define the 4 directions: up, down, left, right
            int[] dRow = {-1,1,0,0};
            int[] dCol = {0,0,-1,1};
 // Traverse in all 4 directions
            for(int k=0; k<4; k++){
                int newRow = row + dRow[k];
                int newCol = col + dCol[k];
                 // Check if the new position is within bounds and not visited
                if(newRow >=0 && newRow<m && newCol >=0 && newCol <n && visited[newRow][newCol] == 0){
                    visited[newRow][newCol] = 1;
                    que.add(new Node(newRow, newCol, dis+1));
                }

            }

        }
       
return distance;
       
    }

}
