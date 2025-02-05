//Time Complexity: O(V + E)
// Space Complexity: O(V) => stack space in case of skewed graph is O(V) + visited array O (V)  + resulted list O(V) = 3 O(V) = O(V)

class Solution {
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] visited,ArrayList<Integer>result){
        visited[node] = 1;
        result.add(node);
        
        for(int neighbour : adj.get(node)){
            // if node is not visited , process it
            if(visited[neighbour] == 0) {
                dfs(neighbour,adj,visited,result);
            }
        }
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int[] visited = new int[V];
        ArrayList<Integer> result = new ArrayList<>();
        dfs(0,adj,visited,result);
        return result;
    }
}
