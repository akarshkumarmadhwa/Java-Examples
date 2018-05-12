import java.util.Scanner;
class KnapSack {
    int x[] = new int[10];
    int p[] = new int[10];
    int w[] = new int[10];
    int v[][] = new int[10][10];
    private int i, j;
    private int max(int a, int b) {
        return a > b ? a : b;
    }

    void KnapSackDemo(int n, int m) {
        for (i = 0; i <= n; i++)
            for (j = 0; j <= m; j++) {
                if (i == 0 || j == 0)
                    v[i][j] = 0;
                else if (w[i] > j)
                    v[i][j] = v[i - 1][j];
                else
                    v[i][j] = max(v[i - 1][j], v[i - 1][j - w[i]] + p[i]);
            }
    }
    void KnapItem(int n,int m){
        for (i=0;i<n;i++)
            x[i] = 0;
        i = n;
        j = m;
        while (i !=0 && j != 0){
            if(v[i][j] != v[i-1][j]){
                x[i] = 1;
                j = j-w[i];
            }i--;
        }
    }
}
public class KnapSackDynamic {
    public static void main(String args[]){
        int n,m,i;
        KnapSack K = new KnapSack();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of items");
        n = s.nextInt();
        System.out.println("Enter the capacity of the sack");
        m = s.nextInt();
        System.out.println("Enter the weights");
        for (i=1;i<=n;i++)
            K.w[i] = s.nextInt();
        System.out.println("Enter the profits");
        for (i=1;i<=n;i++)
            K.p[i] = s.nextInt();
        K.KnapSackDemo(n,m);
        System.out.println("The maximum profit is "+K.v[n][m]);
        K.KnapItem(n,m);
        System.out.println("Items selected are");
        for (i=1;i<=n;i++)
            if(K.x[i] == 1)
                System.out.println(i+" ");
    }
}
