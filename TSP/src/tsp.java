import java.util.Scanner;
public class tsp {
    static int cost = 0;
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int a[][] = new int[10][10];
        int visited[] = new int[10];
        System.out.println("enter number of cities");
        int n = s.nextInt();
        create(a,visited,n);
        System.out.println("The path is");
        mincost(a,n,0,visited);
        System.out.println("Total cost = "+cost);
    }
    public static void create(int a[][],int visited[],int n){
        int i,j;
        Scanner s = new Scanner(System.in);
        System.out.println("enter the cost matrix");
        for (i=0;i<n;i++)
            for(j=0;j<n;j++)
                a[i][j] = s.nextInt();
        visited[1] = 0;
    }
    public static void mincost(int a[][],int n,int city,int visited[]){
        int city_no;
        visited[city] = 1;
        System.out.print((city+1)+" -> ");
        city_no = least(a,visited,n,city);
        if(city_no == 999){
            city_no = 0;
            System.out.println(" "+(city_no+1));
            cost += a[city][city_no];
            return;
        }
        mincost(a,n,city_no,visited);
    }
    public static int least(int a[][],int visited[],int n, int c){
        int i,min_node = 999, min = 999, new_min = 0;
        for(i=0;i<n;i++)
            if((a[c][i] !=0) && (visited[i] ==0) )
                if(a[c][i] < min){
                    min = a[i][0] + a[c][i];
                    new_min = a[c][i];
                    min_node = i;
                }
        if(min != 999)
            cost += new_min;
        return  min_node;
    }
}
