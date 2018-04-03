/*
Author: Debjyoti Guha
Date: 02/04/2018
Description: Dijkstra's Algorithm. 
*/
import java.util.Scanner;
class Dijkstra {
    void dijks (){
        int[][] c;
        int[] d,v;
        int i, j, n, u=0, min, source;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter no of vertices");
        n = s.nextInt();
        d = new int[n];
        v = new int[n];
        c = new int[n][n];
        System.out.println("Enter the adjacency matrix");
        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++)
                c[i][j] = s.nextInt();
        System.out.println("Enter the source");
        source = s.nextInt();
        for (i = 0; i < n; i++) {
            v[i] = 0;
            d[i] = c[source][i];
        }
        v[source] = 1;
        d[source] = 0;
        for (j = 1; j < n; j++)
        {
            min = 999;
            for (i = 0; i < n; i++)
                if(v[i] == 0)
                    if (d[i] < min) {
                        min = d[i];
                        u = i;
                    }

            v[u] = 1;
            for (i = 0; i < n; i++) 
                if (c[u][i] != 999 && v[i] == 0) 
                    if (d[i] > d[u] + c[u][i])
                        d[i] = d[u] + c[u][i];

        }
        System.out.println("Total cost");
        for (i = 0; i < n; i++)
            System.out.println("cost to reach " + i + " from " + source + " is " + d[i]);
    }
}
public class DijkstraMain {
    public static void main(String args[]){
        Dijkstra D = new Dijkstra();
        D.dijks();
    }
}
