class Solution {
    
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        
        // total number of vertices
        int V = adj.size();
        ArrayList<Integer> distance = new ArrayList<>(V);
        
        // store infinite value in distance list because i don't know the shortest distance yet.
        
        for(int i=0; i<V ; i++){
            distance.add(Integer.MAX_VALUE);
        }
        // distance from src to src is 0
        distance.set(src,0);
        
        PriorityQueue<iPair> minHeap = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.second));
        
        
        // add the src node in minHeap
        
        minHeap.add(new iPair(src,0));
        
        // Take set for keep tracking the visited nodes
        Set<Integer> visited = new HashSet<>();
        
        while(!minHeap.isEmpty()){
            iPair pair = minHeap.poll();
            int curNode = pair.first;
            int curDistance = pair.second;
            
            // lets check wheather it is visited, if it does then skip the process
            
            if(visited.contains(curNode)){
                continue;
            }
            // mark the current node as visited
            visited.add(curNode);
            
           // Process all neighbors of the current node
            
            for(iPair neighbour : adj.get(curNode)){
                int neighbourNode = neighbour.first;
                int edgeWeight = neighbour.second;
                
                int updatedDistance = curDistance + edgeWeight;
                if(updatedDistance < distance.get(neighbourNode)){
                    distance.set(neighbourNode,updatedDistance);
                    minHeap.add(new iPair(neighbourNode,updatedDistance));
                }
            }
        }
        return distance;
         
       
    }
}
