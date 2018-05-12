import java.util.Scanner;

class FloydAlgo {
    private int min(int a, int b) {
        return a < b ? a : b;
    }

    void Floyd(int p[][], int n) {
        int i, j, k;
        for (k = 0; k < n; k++)
            for (i = 0; i < n; i++)
                for (j = 0; j < n; j++)
                    p[i][j] = min(p[i][j], p[i][k] + p[k][j]);
    }
}

public class FloydDemo {
    public static void main(String args[]) {
        FloydAlgo F = new FloydAlgo();
        Scanner s = new Scanner(System.in);
        int n, i, j;
        System.out.println("Enter the number of vertices");
        n = s.nextInt();
        int a[][] = new int[n + 10][n + 10];
        System.out.println("Enter the cost matrix");
        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++)
                a[i][j] = s.nextInt();
        F.Floyd(a, n);
        System.out.println("The resultant matrix is");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
