import java.util.Scanner;
public class KrushkalDemo {
    private static int cost[][] = new int [10][10];
    private static int parent[] = new int[10];
    private int find(int i){
        while(parent[i] != i)
            i = parent[i];
        return i;
    }
    private int uni(int i, int j){
        if(i != j){
            parent[j] = i;
            return 1;
        }
        return 0;
    }
    public static void main(String args[]){
        KrushkalDemo K = new KrushkalDemo();
        int i,j,a=0,b=0,u=0,v=0,mincost=0,min,n,ne=1;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        n = s.nextInt();
        System.out.println("Enter the cost matrix");
        for (i=0;i<n;i++) {
            for (j = 0; j < n; j++) {
                cost[i][j] = s.nextInt();
                if (cost[i][j] == 0)
                    cost[i][j] = 999;
            }
        }
        System.out.println("Edges of minimum cost spanning tree are \n");
        for (i=0;i<n;i++)
            parent[i] = i;
        while (ne<n){
            for (i=0,min=999;i<n;i++) {
                for (j = 0; j < n; j++)
                    if (cost[i][j] < min) {
                        min = cost[i][j];
                        a = u = i;
                        b = v = j;
                    }
            }
            u = K.find(u);
            v = K.find(v);
            if(K.uni(u,v) == 1){
                System.out.println("\n"+ne+++" edge[ "+a+" "+b+" ] = "+min);
                mincost += min;
            }
            cost[a][b] = cost[b][a] = 999;
        }
        System.out.println("\nMinimum Cost = "+mincost);
    }
}
