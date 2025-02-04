//Time Complexity: O(V + E)
// Space Complexity: O(V) 
class Solution {
    public void dfs(ArrayList<Integer> result , ArrayList<ArrayList<Integer>> adj, int[] visited, int node){
        if(visited[node] == 0){
            visited[node] = 1;
            result.add(node);
            for(int neighbour : adj.get(node)){
                dfs(result,adj,visited,neighbour);
            }
        }
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int[] visited = new int[V];
        ArrayList<Integer> result = new ArrayList<>();
        dfs(result,adj,visited,0);
        return result;
        
    }
}
