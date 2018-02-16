/*
Author: Debjyoti Guha
Date: 14/02/2018
Description: Stack Implementation
*/
import java.util.Scanner;
public class Stack {
    private int top,size,a[],flag = 0;
    Stack(int n){
        top = -1;
        size = n;
        a = new int[size];
    }


    void push(int item){
        if(top >= size-1){
            System.out.println("Stack Overflow!");
        }
        else{
            a[++top] = item;
            System.out.println("Pushed "+item);
        }
    }
    void pop(){
        if(top == -1){
            System.out.println("Stack Underflow!");
        }
        else{
            System.out.println("Popped "+a[top--]);
        }
    }
    void display(){
        if(top == -1)
            System.out.println("Stack is empty!");
        else{
            System.out.println("Elements stored are");
            for(int i=top;i>=0;i--) {
                System.out.println(a[i]);
            }
        }
    }
    void checkpali(){
        for(int i= 0,j = top;j>=top/2;i++,j--) {
            if (a[i] != a[j]) {
                flag = 1;
                break;
            }
        }
        if(flag == 1)
            System.out.println("Not a Palindrome");
        else
            System.out.println("Palindrome");
    }
}

class StackDemo{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        Boolean exit = false;
        System.out.println("Enter no of elements: ");
        int n = s.nextInt();
        Stack stk = new Stack(n);
        do{
            System.out.println("1.Push\t2.Pop\t3.Display\t4.Check-Palindrome\t5.Exit");
            System.out.println("Enter choice: ");
            int ch = s.nextInt();
            switch (ch){
                case 1:
                        System.out.println("Enter item to push: ");
                        int item = s.nextInt();
                        stk.push(item);
                        break;
                case 2:
                        stk.pop();
                        break;
                case 3:
                        stk.display();
                        break;
                case 4:
                        stk.checkpali();
                        break;
                case 5:
                        exit = true;
                        break;
                default:
                        System.out.println("Invalid Choice!");
            }
        }while (!exit);
    }
}
