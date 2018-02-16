/*
Author: Debjyoti Guha
Date: 14/02/2018
Description: Storing Student Details
*/
import java.util.Scanner;
class Student {
    private String usn, name, branch, phno;

    Student(String u, String n, String b, String p) {
        usn = u;
        name = n;
        branch = b;
        phno = p;
    }

    void print() {
        System.out.println(usn + " \t " + name + " \t " + branch + " \t " + phno);
    }
}
class StudentInfo{
    public static void main(String args[]){
        int n;
        String usn, name, branch, phno;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the no of Students: ");
        n = s.nextInt();
        Student a[] = new Student[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter USN NAME BRANCH PH.NO");
            usn = s.next();
            name = s.next();
            branch = s.next();
            phno = s.next();
            a[i] = new Student(usn,name,branch,phno);
        }
        System.out.println("STUDENT INFO");
        System.out.println("-----------------");
        for (int i=0;i<n;i++){
            System.out.println("USN  \t  NAME  \t  BRANCH  \t  PH.NO");
            a[i].print();
        }
    }
}
