import java.util.*;

public class problem_2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=0;
        System.out.println("All numbers: ");
        for(int i=1; i<=n; i++){
            System.out.print(i+" ");
            sum+=i;
        }
        System.out.println();
        System.out.println("Even numbers:");
        for(int i=1;i<=n;i++){
            if(i%2 == 0)
                System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("Sum:"+sum);
        
    }
}

