import java.util.Scanner;
public class CRCMain {
    private static int xor(int x, int y){
        if(x==y)
            return 0;
        else
            return 1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m,n,d[],g[],r[],s[],r1[],flag=0,msb,i,j,k;
        System.out.println("Enter no of data and generator bits");
        n = sc.nextInt();
        m = sc.nextInt();
        d = new int[m+n];
        g = new int[m];
        System.out.println("Enter data word");
        for(i=0;i<n;i++)
            d[i] = sc.nextInt();
        System.out.println("Enter generator word");
        for(i=0;i<m;i++)
            g[i] = sc.nextInt();
        for(i=0;i<m-1;i++)
            d[n+i] = 0;
        r = new int[m+n];
        for(i=0;i<m;i++)
            r[i] = d[i];
        for(i=0;i<n;i++){
            k = 0;
            msb = r[i];
            for(j=i;j<m+i;j++) {
                if (msb == 1)
                    r[j] = xor(r[j], g[k]);
                k++;
            }
            r[m+i] = d[m+i];
        }
        System.out.println("code bit");
        for(i=n;i<n+m-1;i++){
            d[i] = r[i];
            System.out.print(d[i]+" ");
        }
        System.out.println("\ndata bit");
        for(i=0;i<n+m-1;i++){
            System.out.print(d[i]+" ");
        }
        System.out.println("\nre-enter code word");
        s = new int[n+m+1];
        for(i=0;i<n+m-1;i++)
            s[i] = sc.nextInt();
        r1 = new int[m+n];
        for(i=0;i<m;i++)
            r1[i] = s[i];
        for(i=0;i<n;i++){
            k = 0;
            msb = r1[i];
            for(j=i;j<m+i;j++) {
                if (msb == 1)
                    r1[j] = xor(r1[j], g[k]);
                k++;
            }
            r1[m+i] = s[m+i];
        }
        for(i=n;i<n+m-1;i++){
            if(r1[i] != 0){
                flag = 1;
                break;
            }
        }
        if(flag == 1)
            System.out.println("ERROR!");
        else
            System.out.println("NO ERROR!");
    }
}
