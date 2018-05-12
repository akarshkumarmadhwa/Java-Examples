/*
Author: Debjyoti Guha
Date: 06/05/2018
Description: Prim's Algorithm.
*/
import java.util.Scanner;
class PrimsAlgo {
    void Prim (){
        int[][] c;
        int[] d,v;
        int i, j, n, u, min, source,x,total=0;
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
        u = 0;
        for (j = 1; j < n; j++)
        {
            x = u;
            min = 999;
            for (i = 0; i < n; i++)
                if(v[i] == 0)
                    if (d[i] < min) {
                        min = d[i];
                        u = i;
                    }

            v[u] = 1;
            total += min;
            for (i = 0; i < n; i++)
                if (c[u][i] != 999 && v[i] == 0)
                    if (d[i] >  c[u][i])
                        d[i] =  c[u][i];
            System.out.println("\nedge [ "+x+","+u+" ] and weight = "+min);

        }
        System.out.println("\nTotal cost = "+total);
    }
}
public class PrimsDemo {
    public static void main(String args[]){
       PrimsAlgo P = new PrimsAlgo();
        P.Prim();
    }
}
