class Solution {
    public static void dfs(int node,int[] visited,ArrayList<ArrayList<Integer>> adj){
        visited[node] = 1;
        for(int neighbour : adj.get(node)){
            if(visited[neighbour] == 0){
                dfs(neighbour,visited,adj);
            }
        }
        
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<V ; i++){
            adjList.add(new ArrayList<Integer>());
        }
        // Convert adjacency matrix to adjacency list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1) { // Check if edge exists
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        
        int count = 0;
        int[] visited = new int[V+1];
        for(int i=0; i< V; i++){
            if(visited[i] == 0){
                dfs(i,visited,adjList);
               count++;
            }
             
            
        }
        return count;
    }
};
