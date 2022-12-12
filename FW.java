// Floyd Warshall Algorithm in Java

public class FW {
    final static int INF = 9999;

    public void dijkstra(int[][] graph, int source) 
    {
        
        int c = graph.length;
        boolean[] visitedVertex = new boolean[c];
        int[] dist = new int[c];
        for (int i = 0; i < c; i++) 
        {
        visitedVertex[i] = false;
        dist[i] = Integer.MAX_VALUE;
        }

        dist[source] = 0;
        for (int i = 0; i < c; i++) 
        {

        int u = findminDist(dist, visitedVertex);
        visitedVertex[u] = true;

        for (int v = 0; v < c; v++) 
        {
            if (!visitedVertex[v] && graph[u][v] != 0 && (dist[u] + graph[u][v] < dist[v])) {
            dist[v] = dist[u] + graph[u][v];
            }
        }

        }

        for (int i = 0; i < dist.length; i++) 
        {
        System.out.println(String.format("Distance from %s to %s is %s", source, i, dist[i]));
        }

    }

  // Finding the minimum dist
  private static int findminDist(int[] dist, boolean[] visitedVertex) 
  {
    int minDist = Integer.MAX_VALUE;
    int minDistVertex = -1;
    for (int i = 0; i < dist.length; i++) {
      if (!visitedVertex[i] && dist[i] < minDist) {
        minDist = dist[i];
        minDistVertex = i;
      }
    }
    return minDistVertex;
  }
  
    void floydWarshall(int graph[][], int n) {
      int matrix[][] = new int[n][n];
      int i, j, p;
  
      for (i = 0; i < n; i++)
        for (j = 0; j < n; j++)
          matrix[i][j] = graph[i][j];
  
      for (p = 0; p < n; p++) {
        for (i = 0; i < n; i++) {
          for (j = 0; j < n; j++) {
            if (matrix[i][p] + matrix[p][j] < matrix[i][j])
              matrix[i][j] = matrix[i][p] + matrix[p][j];
          }
        }
      }
       printMatrix(matrix, n);
    }
  
    void printMatrix(int matrix[][], int n) {
      for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
          if (matrix[i][j] == INF)
            System.out.print("INF ");
          else
            System.out.print(matrix[i][j] + "  ");
        }
        System.out.println();
      }
      System.out.println();
    }

    static int[][] generateMatrix(int n)
    {

        int values[][] = new int[n][n];

        for (int i = 0; i < values.length; i++) 
        {
            for (int j = 0; j < values[i].length; j++) 
            {
                values[i][j] = ((int) (Math.random() * 10));            
            }
        }
        return values;
    }
  
    public static void main(String[] args) {

      int n = 8;   
        
      int graph[][] = generateMatrix(n);
      FW a = new FW();


     a.printMatrix(graph, 8);

      long startTime = System.currentTimeMillis();
      a.floydWarshall(graph, n);
      long endTime = System.currentTimeMillis();

     System.out.println("\nTime Taken is: " + (endTime-startTime));

    

    }
}