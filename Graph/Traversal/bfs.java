//Time Complexity: O(V + E) --total nodes in queue + total degree ie 2E
//Space Complexity: O(V) 

class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
       int[] visited = new int[V];
       ArrayList<Integer> bfs = new ArrayList<>();
       Queue<Integer> que = new LinkedList<>();
       que.add(0);
       visited[0] = 1;
       
       while(!que.isEmpty()){
           int size = que.size();
           for(int i=0; i<size;i++){
              int curNode =  que.remove();
              bfs.add(curNode);
              for(int neighbour : adj.get(curNode)){
                  if(visited[neighbour]!= 1){
                      visited[neighbour] = 1;
                      que.add(neighbour);
                  }
                  
              }
           }
       }
       return bfs;
    }
}
