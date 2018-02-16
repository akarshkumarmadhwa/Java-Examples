/*
Author: Debjyoti Guha
Date: 10/02/2018
Description: Simple Game using Math.random() to guess the random number in between 1 - 100
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        boolean got = false;
        int y = 1;
        while (y == 1){
            int randomNum = (int) (Math.random() * 100) + 1;
            Scanner s = new Scanner(System.in);
            System.out.println("# Guess The Number between [1-100] # Total Guess = 10 #");
            for (int i = 10; i > 0; i--) {
                System.out.println("Guess left# " + i + " Enter the value: ");
                int n = s.nextInt();
                if (n > randomNum)
                    System.out.println("The Number is less than " + n);
                else if (n < randomNum)
                    System.out.println("The Number is greater than " + n);
                else {
                    got = true;
                    break;
                }
            }
            if (got)
                System.out.println("Congratulations! You've Guessed it correctly");
            else {
                System.out.println("Sorry! Better luck next time");
                System.out.println("The number was " + randomNum);
            }
                System.out.println("Continue(1/0)? ");
                Scanner p = new Scanner(System.in);
                int c = p.nextInt();
                if(c == 1)
                    y = 1;
                else
                    y = 0;
        }
    }
}
