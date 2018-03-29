import java.util.Scanner;
import java.util.Random;
class QuickSort{
    void Quick(int a[],int low,int high){
        if(low>=high)
            return;
        int k = partition(a,low,high);
        Quick(a,low,k-1);
        Quick(a,k+1,high);
    }
    private int partition(int a[], int low, int high){
        int key = a[high];
        int i = low-1;
        for(int j=low;j<high;j++){
            if(a[j]<key){
                i++;
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        int tmp = a[i+1];
        a[i+1] = a[high];
        a[high] = tmp;
        return i+1;
    }
}
public class QuickMain {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        QuickSort Q = new QuickSort();
        System.out.println("How many elements?");
        int n = s.nextInt();
        int[] a = new int [n];
        for (int i=0;i<n;i++)
            a[i] = r.nextInt(n);
        long st = System.nanoTime();
        Q.Quick(a,0,n-1);
        long et = System.nanoTime();
        System.out.println("Elements after sorting");
        for (int i =0;i<n;i++)
            System.out.println(a[i]);
        System.out.println("Time Elapsed "+(et-st)+" ns");
    }
}
