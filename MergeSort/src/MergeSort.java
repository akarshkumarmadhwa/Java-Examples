/*
Author: Debjyoti Guha
Date: 28/02/2018
Description: MergeSort Implementation
*/
import java.util.Scanner;
import java.util.Random;
class MergeS{
   void MergeSort(int a[],int low,int high){
       int mid;
        if(low<high){
            mid = (low+high)/2;
           MergeSort(a,low,mid);
           MergeSort(a,mid+1,high);
           Merge(a,low,high,mid);
        }
    }
    private void Merge(int a[],int low,int high,int mid){
       int[] b = new int[50000];
       int h = low;
       int i = low;
       int j = mid+1;
       while ((h<=mid) && (j<=high)){
           if(a[h]<=a[j]){
               b[i] = a[h];
               h++;
           }
           else{
               b[i] = a[j];
               j++;
           }
           i++;
       }
       if(h>mid){
           for (int k = j; k<=high; k++){
               b[i] = a[k];
               i++;
           }
       }
       else{
           for (int k = h; k<=mid; k++){
               b[i] = a[k];
               i++;
           }
       }
        for (int k = low; k<=high; k++){
            a[k] = b[k];
        }
    }
}
public class MergeDemo {
    public static void main(String args[]){
        Random r = new Random();
        Scanner s = new Scanner(System.in);
        MergeS M = new MergeS();
        System.out.println("How many elements? ");
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0;i<n;i++)
            a[i] = r.nextInt(n);
        long st = System.nanoTime();
        M.MergeSort(a,0,n-1);
        long et = System.nanoTime();
        System.out.println("Elements after Sorting");
        for (int i = 0;i<n;i++)
            System.out.println(a[i]);
        System.out.println("Elapsed Time "+(et-st)+" ns");
    }
}

