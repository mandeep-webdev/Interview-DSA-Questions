//----------------------------------------DFS-------------------------------------
class Solution {
    public void dfs(int[][] image,int sr,int sc, int m, int n, int color, int originalColor){
        // check for out of bound indexes
        if(sr<0 || sc <0 || sr>=m || sc>=n) return;
        // do nothing of adjacent pixel doesnot have original color of starting pixel or if newColor is already assigned
        if(image[sr][sc] != originalColor || image[sr][sc] == color) return;
        // change the pixel color
        image[sr][sc] = color;
        // explore all 4 sides
        dfs(image,sr-1,sc,m,n,color,originalColor);
        dfs(image,sr+1,sc,m,n,color,originalColor);
        dfs(image,sr,sc-1,m,n,color,originalColor);
        dfs(image,sr,sc+1,m,n,color,originalColor);



    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int totalRows = image.length;
        int totalColums = image[0].length;
       // store the original color of the starting pixel 
       int originalColor = image[sr][sc];
       dfs(image,sr,sc,totalRows,totalColums,color,originalColor);
       return image;
    }
}
