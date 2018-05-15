import java.util.Scanner;
public class Hamiltonian {
    private static boolean found = false;
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int n = s.nextInt();
        int g[][] = new int[n+1][n+1];
        int x[] = new int[n+1];
        System.out.println("Enter the edge 1 or 0");
        for(int i=1;i<=n;i++) {
            for (int j = 1; j <= n; j++) {
                if ((i != j) && (i < j)) {
                    System.out.println(i + " and " + j + " : ");
                    g[j][i] = g[i][j] = s.nextInt();
                }
                if (i == j)
                    g[i][j] = 0;
            }
        }
        for(int i=1;i<=n;i++)
            x[i] = 0;
        x[1] = 1;
        System.out.println("Solution");
        Hamiltoniann(2,g,x,n);
        if(!found)
            System.out.println("No solution!");
    }
   private static void Hamiltoniann(int k,int g[][],int x[],int n){
        while (true){
            NextValue(k,g,x,n);
            if(x[k] == 0)
                return;
            if(k == n){
                for (int i = 1;i<=k;i++)
                    System.out.print(x[i]+" ");
                System.out.println(" ");
                found = true;
                return;
            }
            else
                Hamiltoniann(k+1,g,x,n);
        }
    }
    private static void NextValue(int k,int g[][],int x[],int n){
        while(true){
            x[k] = (x[k]+1)%(n+1);
            if(x[k] == 0)
                return;
            if(g[x[k-1]][x[k]] != 0){
                int j;
                for (j=1;j<k;j++)
                    if(x[k] == x[j])
                        break;
                if(j == k)
                    if((k<n) || (k == n) && g[x[n]][x[1]] != 0)
                        return;
            }
        }
    }
}
