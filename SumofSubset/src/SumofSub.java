import java.util.Scanner;
public class SumofSub {
    final static int max = 20;
    final static int s[] = new int[max];
    final static int x[] = new int[max];
    static int d,n;
   // static boolean found = false;
    void SumOfSubSet(int p,int k,int r){
        int i;
        x[k] = 1;
        /*if(k == n){
            for (i=1;i<=k;i++)
                if(x[i] == 1) break;
            if( i == k) return;
        }*/
        if((p+s[k]) == d){
            for (i=1;i<=k;i++)
                if(x[i] == 1)
                    System.out.print("\t"+s[i]);
            System.out.println();
            /*found = true;
            return;*/
        }
        else if((p+s[k]+s[k+1]) <= d)
            SumOfSubSet(p+s[k],k+1,r-s[k]);
        if((p+r-s[k] >= d) && (p+s[k+1] <= d)){
            x[k] = 0;
            SumOfSubSet(p,k+1,r-s[k]);
        }
    }
    public static void main(String args[]){
        int i,n,sum=0;
        Scanner sc = new Scanner(System.in);
        SumofSub ss = new SumofSub();
        System.out.println("Enter max no");
        n = sc.nextInt();
        System.out.println("enter set in increasing order");
        for (i=1;i<=n;i++)
            s[i] = sc.nextInt();
        System.out.println("enter max subset value");
        d = sc.nextInt();
        for (i=1;i<=n;i++)
            sum += s[i];
        if((sum < d) || s[1] > d)
            System.out.println("No Subset possible!");
        else
            ss.SumOfSubSet(0,1,sum);
        /*if(!found)
            System.out.println("no subset possible!");*/
    }
}
