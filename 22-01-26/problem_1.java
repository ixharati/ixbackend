import java.util.*;
public class problem_1{
    public static String checkNumber(int n){
        if(n>0)
            return "Positive number";
        else if(n<0)
            return "Negative number";
        else
            return "Zero";
    }
    public static String checkEvenOdd(int n){
        if(n%2==0)
            return "Even number";
        else
            return "odd number";

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String number= checkNumber(n);
        String evenOdd= checkEvenOdd(n);
        System.out.println(number + ", "+ evenOdd);
    }
}
