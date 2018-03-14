/*
Author: Debjyoti Guha
Date: 14/03/2018
Description: Read and Display Employee Details
*/
import java.util.Scanner;

class Staff {
    private String staffID, name, ph;
    private long salary;
    Scanner s = new Scanner(System.in);

    void read() {
        System.out.println("Enter ID,NAME,PH.NO,SALARY");
        staffID = s.next();
        name = s.next();
        ph = s.next();
        salary = s.nextInt();
    }

    void print() {
        System.out.println(staffID + "\t" + name + "\t" + ph + "\t" + salary);
    }
}
    class Teaching extends Staff{
       private String domain; private String [] publication;
       private int n,i;
        void read() {
            super.read();
            System.out.println("Enter the Domain");
            domain = s.next();
            System.out.println("How many publications?");
            n = s.nextInt();
            publication = new String[n];
            System.out.println("Enter " + n + " publications");
            for (i = 0; i < n; i++) {
                publication[i] = s.next();
            }
        }
            void print(){
                super.print();
                System.out.println("DOMAIN: " +domain);
                for (i=0;i<n;i++){
                    System.out.println("PUBLICATION: " +publication[i]);
                }
            }
    }
    class Technical extends Staff{
        private int n,i;
        private String[] skills;
        void read(){
            super.read();
            System.out.println("How many skills?");
            n = s.nextInt();
            skills = new String[n];
            System.out.println("Enter "+n +" Skills");
            for (i=0;i<n;i++){
                skills[i] = s.next();
            }
        }
        void print(){
            super.print();
            for (i=0;i<n;i++){
                System.out.println("SKILL: " +skills[i]);
            }
        }
    }
    class Contract extends Staff{
        private String period;
        void read(){
            super.read();
            System.out.println("Enter period");
            period = s.next();
        }
        void print(){
            super.print();
            System.out.println("PERIOD: " +period);
        }
    }

public class StaffDemo {
    public static void main(String[] args){
        Teaching th = new Teaching();
        Technical t = new Technical();
        Contract c = new Contract();
        System.out.println("Enter Teaching Details");
        th.read();
        System.out.println("Enter Technical Details");
        t.read();
        System.out.println("Enter Contract Details");
        c.read();
        System.out.println("TEACHING DETAILS");
        System.out.println("STAFF ID \t NAME \t Ph.No \t SALARY");
        th.print();
        System.out.println("TECHNICAL DETAILS");
        System.out.println("STAFF ID \t NAME \t Ph.No \t SALARY");
        t.print();
        System.out.println("TEACHING DETAILS");
        System.out.println("STAFF ID \t NAME \t Ph.No \t SALARY");
        c.print();

    }
}
