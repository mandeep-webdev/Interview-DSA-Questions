/*
class iPair {
    int first, second;

    iPair(int first, int second) {
        this.fist = first;
        this.second = second;
    }
}
*/
class Solution {
    
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        int V = adj.size();
        ArrayList<Integer> distance = new ArrayList<>(V);
      
      // Initialize distances to "infinity"
        for(int i = 0; i< V;i++){
            distance.add(Integer.MAX_VALUE);
            
        }
      
        distance.set(src,0); // Set the source node's distance to 0

       // Min-Heap (PriorityQueue) with custom comparator
        PriorityQueue<iPair> minHeap = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.second));
        minHeap.add(new iPair(src,0)); // Add the source node with distance 0

        // Process the priority queue
        while(!minHeap.isEmpty()){
            iPair pair = minHeap.poll();
            int curDistance = pair.second;
            int curNode = pair.first;
            
            for(iPair neighbor : adj.get(curNode)){
                 int neighborNode = neighbor.first;
                 int edgeWeight = neighbor.second;
              // Update the distance if a shorter path is found
                 int updatedDistance = edgeWeight + curDistance;
                 if(updatedDistance < distance.get(neighborNode)){
                     distance.set(neighborNode,updatedDistance);
                     minHeap.add(new iPair(neighborNode,updatedDistance));
                 }
            }
        }
        return distance; // Return the shortest distances from the source
       
    }
}
