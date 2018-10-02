import java.util.*;
public class Graph {
    class Edge{
        int src,dest,weight;
        Edge(){
            src = dest = weight = 0;
        }
    }
    int V,E;
    Edge edge[];
    Graph(int v, int e){
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i=0;i<e;i++)
            edge[i] = new Edge();
    }
    void BellmanFord(Graph graph,int src){
        int V = graph.V, E = graph.E;
        int dist[] = new int[V];
        for (int i=0;i<V;i++)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
        for (int i =1;i<V;i++)
            for (int j=0;j<E;j++){
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int w = graph.edge[j].weight;
                if(dist[u] != Integer.MAX_VALUE && dist[u]+w < dist[v])
                    dist[v] = dist[u]+w;
            }
        for (int j=0;j<E;j++){
            int u = graph.edge[j].src;
            int v = graph.edge[j].dest;
            int w = graph.edge[j].weight;
            if(dist[u] != Integer.MAX_VALUE && dist[u]+w < dist[v])
                System.out.println("Graph contains -ve weight cycle!");
        }
        printArr(dist,V);
    }
    void printArr(int dist[],int v){
        System.out.println("Vertex\tDistance from source");
        for(int i=0;i<v;i++)
            System.out.println(i+"\t\t"+dist[i]);
    }
    public static void main(String args[]){
        int s,d,w;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of vertex & edges");
        int v = sc.nextInt();
        int e = sc.nextInt();
        Graph graph = new Graph(v,e);
        System.out.print("Enter Source, Dest & weight of each vertex");
        for (int i=0;i<e;i++){
            s = sc.nextInt();
            d = sc.nextInt();
            w = sc.nextInt();
            graph.edge[i].src = s;
            graph.edge[i].dest = d;
            graph.edge[i].weight = w;
        }
        System.out.println("Enter source node");
        int src = sc.nextInt();
        graph.BellmanFord(graph,src);
    }
}
