class iPair {
    int node;
    int weight;
    iPair(int node,int weight){
        this.node = node;
        this.weight = weight;
        
    }
}

class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        
        // Create adjacency list
        List<List<iPair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
         // Populate adjacency list
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            int weight = edge[2];
            adj.get(src).add(new iPair(dest, weight));
            adj.get(dest).add(new iPair(src, weight)); // Assuming undirected graph
        }
        
          // Initialize distance and parent arrays
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        
        
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
         // Min-heap for Dijkstra's algorithm
        PriorityQueue<iPair> minHeap = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.weight));
        minHeap.add(new iPair(1, 0));
        
        
        while(!minHeap.isEmpty()){
            iPair pair = minHeap.poll();
            int curNode = pair.node;
            int curDistance = pair.weight;
            
            for(iPair neighbor : adj.get(curNode)){
                 int neighborNode = neighbor.node;
                int edgeWeight = neighbor.weight;

                int updatedDistance = curDistance + edgeWeight;

                if (distance[neighborNode] > updatedDistance) {
                    distance[neighborNode] = updatedDistance;
                    minHeap.add(new iPair(neighborNode, updatedDistance));
                    parent[neighborNode] = curNode;
                }
            }
        }
       // Trace the shortest path from destination to source
        List<Integer> path = new ArrayList<>();
        if (distance[n] == Integer.MAX_VALUE) {
            path.add(-1); // No valid path exists
            return path;
        }

        int node = n;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1); // Add the source node

        // Reverse the path to get it from source to destination
        Collections.reverse(path);

        // Add the total weight as the first element
        path.add(0, distance[n]);

        return path;
    }
}
