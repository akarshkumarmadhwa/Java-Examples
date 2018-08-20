import java.util.Scanner;
public class CrcMain {
    private static void check(int m, int n, int[] d, int[] g, int[] r) {
        int i;
        int k;
        int msb;
        int j;
        for (i=0; i<n; i++){
            k = 0;
            msb = r[i];
            for (j=i;j<m+i;j++){
                if(msb == 1)
                    r[j] = xor(r[j],g[k]);
                k++;
            }
            r[m+i] = d[m+i];
        }
    }
    private static int xor(int a, int b){
        if(a == b)
            return 0;
        else
            return 1;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int m,n,i,d[],g[],r[],s[],r1[],flag=0;
        System.out.println("Enter number of Data and Generator");
        n = sc.nextInt();
        m = sc.nextInt();
        d = new int[n+m];
        g = new int[m];
        System.out.println("enter Data-Word");
        for(i=0;i<n;i++)
            d[i] = sc.nextInt();
        System.out.println("enter Generator");
        for(i=0;i<m;i++)
            g[i] = sc.nextInt();
        for(i=0;i<m-1;i++)
            d[n+i] = 0;
        r = new int[m+n];
        for(i=0;i<m;i++)
            r[i] = d[i];
        check(m, n, d, g, r);
        System.out.println("Code-Bit");
        for (i=n;i<n+m-1;i++){
            d[i] = r[i];
            System.out.print(d[i]+" ");
        }
        System.out.println("\nData-Bit");
        for (i=0;i<n+m-1;i++)
            System.out.print(d[i]+" ");
        System.out.println("\nre-enter Code-Word");
        s = new int[n+m+1];
        for (i=0;i<n+m-1;i++)
            s[i] = sc.nextInt();
        r1 = new int[m+n];
        for (i=0;i<m;i++)
            r1[i] = s[i];
        check(m, n, s, g, r1);
        for (i=n;i<n+m-1;i++){
            if(r1[i] != 0){
                flag = 1;
                break;
            }
        }
        if(flag == 1)
            System.out.println("ERROR!");
        else
            System.out.println("No Error!");

    }
}
