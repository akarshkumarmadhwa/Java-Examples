import java.util.Scanner;
import java.util.StringTokenizer;

class Customer {
    private String data;

    void read() {
        System.out.println("Enter customer details in the format (NAME,DD/MM/YY)");
        Scanner s = new Scanner(System.in);
        data = s.nextLine();
    }
    void disp(){
        StringTokenizer tk = new StringTokenizer(data,"/");
        System.out.println("Customer Details");
        System.out.println(tk.nextToken()+" , "+tk.nextToken()+" , "+tk.nextToken());
    }
}
public class CustomerMain {
    public static void main(String args[]){
        Customer c = new Customer();
        c.read();
        c.disp();
    }
}
