import java.util.Scanner;
class DivideException extends Exception{
    DivideException(){
        super("Divide by zero!");
    }
}
public class ExceptionDemo {
    private static double divide(int a, int b) throws DivideException{
        if(b == 0)
            throw new DivideException();
        return (double)a/b;
    }
    public static void main(String args[]){
        Scanner s =new Scanner(System.in);
        System.out.println("Enter two numbers");
        int x = s.nextInt();
        int y = s.nextInt();
        try{
            double c = divide(x,y);
            System.out.println("Ratio = "+c);
        }
        catch (DivideException e){
            System.out.println("ERROR: "+e);
        }
    }
}
