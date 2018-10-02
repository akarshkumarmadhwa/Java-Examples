import java.util.*;
public class Graph {
    class Edge{
        int src,dest,weight;
        Edge(){
            src = dest = weight = 0;
        }
    }
    int V, E;
    Edge edge[];
    Graph(int v, int e){
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i =0;i<e;i++)
            edge[i] = new Edge();
    }
    private void BellmanFord(Graph graph, int src)
    {
        int V = graph.V, E = graph.E;
        int dist[] = new int[V];

        for (int i=0; i<V; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;

        for (int i=1; i<V; ++i)
        {
            for (int j=0; j<E; ++j)
            {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int weight = graph.edge[j].weight;
                if (dist[u]!=Integer.MAX_VALUE &&
                        dist[u]+weight<dist[v])
                    dist[v]=dist[u]+weight;
            }
        }
        for (int j=0; j<E; ++j)
        {
            int u = graph.edge[j].src;
            int v = graph.edge[j].dest;
            int weight = graph.edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE &&
                    dist[u]+weight < dist[v])
                System.out.println("Graph contains negative weight cycle");
        }
        printArr(dist, V);
    }
    private void printArr(int dest[], int v){
        System.out.println("Vertex\tDistance from source");
        for (int i=0;i<v;i++)
            System.out.println(i+"\t"+dest[i]);
    }
    public static void main(String args[]){
        int s,d,w;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of vertices & edges");
        int V = sc.nextInt();
        int E = sc.nextInt();
        Graph graph = new Graph(V,E);
        System.out.println("Enter source Dest and Weight for each vertex");
        for (int i=0;i<E;i++){
            s = sc.nextInt();
            d = sc.nextInt();
            w = sc.nextInt();
            graph.edge[i].src = s;
            graph.edge[i].dest = d;
            graph.edge[i].weight = w;
        }
        System.out.println("Enter the source");
        int src = sc.nextInt();
        graph.BellmanFord(graph,src);
    }
}
