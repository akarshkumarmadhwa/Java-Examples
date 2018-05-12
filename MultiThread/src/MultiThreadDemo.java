import java.util.Random;
class sqTh implements Runnable{
    int n;
    sqTh(int num){
        n = num;
    }
    public void run(){
        System.out.println("Second Thread: square of "+n +" is = "+n*n);
    }
}
class cuTh implements Runnable{
    int n;
    cuTh(int num){
        n = num;
    }
    public void run(){
        System.out.println("Third Thread: cube of "+n +" is = "+n*n*n);
    }
}
class rthread implements Runnable{
    int num;
    Random R = new Random();
    public void run(){
        for(int i = 0;i<5;i++){
            num = R.nextInt(100);
            System.out.println("First Thread: Generated "+num);
            Thread T1 = new Thread(new sqTh(num));
            T1.start();
            Thread T2 = new Thread(new cuTh(num));
            T2.start();
            try{
                Thread.sleep(1000);
                System.out.println("-----------------------------------------------");
            }
            catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
public class MultiThreadDemo {
    public static void main(String args[]){
        Thread t = new Thread(new rthread());
        t.start();
    }
}
