class iPair {
    int node;
    int weight;
    iPair(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int l = times.length;
        ArrayList<ArrayList<iPair>> adj = new ArrayList<>(n+1);
        for(int i=0; i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<l ; i++){
            int s = times[i][0];
            int t = times[i][1];
            int w = times[i][2];
            adj.get(s).add(new iPair(t,w));
        }
        
        int[] distance = new int[n+1];
        // store infinite value in distance array
        for(int i=1; i<=n;i++){
            distance[i] = Integer.MAX_VALUE;
        }
        // k is the source node
        distance[k] = 0;
        PriorityQueue<iPair> minHeap = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.weight));
        minHeap.add(new iPair(k,0));
        while(!minHeap.isEmpty()){
            iPair pair =  minHeap.poll();
            int curNode = pair.node;
            int curDistance = pair.weight;
            // explore the neighbours
            for(iPair neighbour : adj.get(curNode)){
                int neighbourNode = neighbour.node;
                int weight = neighbour.weight;
                int newDistance = curDistance + weight;
                if(newDistance < distance[neighbourNode]){
                    distance[neighbourNode] = newDistance;
                    minHeap.add(new iPair(neighbourNode,newDistance));

                }


            }
        }
        int maxDistance = Integer.MIN_VALUE;
        for(int i=1; i<=n;i++){
            if(distance[i] == Integer.MAX_VALUE){
                return -1;
            }
            if(distance[i] > maxDistance){
                maxDistance = distance[i];
            }
        }
        return maxDistance;

    }
}
