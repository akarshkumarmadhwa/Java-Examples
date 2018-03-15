/*
Author: Debjyoti Guha
Date: 15/02/2018
Description: KnapSack Algorithm using Greedy method. 
*/
import java.util.Scanner;

class Knapsack {
    void Sack(int n,int m,float w[],float p[]){
        float rem = m,swap, profit = 0;int i;
        float[] x = new float[n];
        float[] div = new float[n];
        //set all x[] to 0
        for(i = 0;i<n;i++){
            x[i]=0;
        }
        //find p/w
        for(i = 0;i<n;i++){
            div[i] = p[i]/w[i];
            //System.out.println(div[i]+" ");
        }

        //sorting
        for (i = 0 ; i < n-1  ; i++ )
        {
            for(int j=0;j<n-i-1;j++) {
                if (div[j] < div[j + 1]) {

                    swap = p[j];
                    p[j] = p[j+1];
                    p[j+1] = swap;

                    swap = w[j];
                    w[j] = w[j+1];
                    w[j+1] = swap;

                }
            }

        }
       /* System.out.println("After Sorting");
        for( i = 0;i<n;i++){
            System.out.println(w[i]+"   "+p[i]);
        }*/
        for( i =0; i<n ; i++){
            if(w[i]<rem){
                profit = profit+p[i];
                rem = rem-w[i];
                x[i] = 1;
            }
            else
                break;
        }
        if(i<=n) {
            x[i] = rem / w[i];
            profit = profit + p[i] * x[i];
            System.out.println("Profit" );
            System.out.println(profit );
            System.out.println("Optimal Solution");
            for (i = 0; i < n; i++)
                System.out.println(x[i] + "  ");
        }
    }

}

public class GreedyKnapSack {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.println("How many elements? ");
        int n = s.nextInt();
        float[] w = new float[n];
        float[] p = new float[n];
        System.out.println("Enter Capacity");
        int m = s.nextInt();
        System.out.println("Enter Weight");
        for (int i = 0; i < n; i++) {
            w[i] = s.nextFloat();
        }
        System.out.println("Enter Profit");
        for (int i = 0; i < n; i++) {
            p[i] = s.nextFloat();
        }
        System.out.println("W\t\t\tP");
        for (int i = 0; i < n; i++) {
            System.out.println(w[i] + "\t\t" + p[i]);
        }
        Knapsack G = new Knapsack();
        G.Sack(n, m, w, p);
    }
}
