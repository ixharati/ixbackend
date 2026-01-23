import java.util.*;

public class problem_3 {
    public static int add(int a, int b){
        return a+b;
    }

    public static boolean isEven(int n) {
        if (n % 2 == 0) {
            return true;
        }
        return false;
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        switch (n){
            case 1:
                int a=sc.nextInt();
                int b=sc.nextInt();
                System.out.println("Sum: "+add(a,b));
                break;
            case 2:
                int num1=sc.nextInt();
                if(isEven(num1))
                    System.out.println(num1+" is even");
                else
                    System.out.println(num1+" is odd");
                break;
            case 3:
                int num2=sc.nextInt();
                System.out.println("Factorial of n is "+ factorial(num2));
        }
        
    }
}
